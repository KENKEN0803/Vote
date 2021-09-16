package Pack;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class voteController {
    private voteDAO dao;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String vote(Model model, HttpSession httpSession, @RequestParam("uid") String uid, @RequestParam("pw") String pw) {
        System.out.println("login 처리 실행");
        System.out.println("사용자 입력 id : " + uid);
        System.out.println("사용자 입력 pw : " + pw);
        Map<String, String> map;

        int result = 3;

        // int result
        // 1 : 로그인 성공
        // 2 : 로그인 비밀번호 불일치
        // 3 : 아이디 존재 X

        try {
            dao = new voteDAO();
            map = dao.readAll();
            result = dao.isin(uid, pw, map);
            System.out.println(result);
            if (result == 1) {
                model.addAttribute("uid", uid);

                httpSession.setAttribute("uid", uid);

            } else {
                System.out.println("로그인 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            model.addAttribute("result", result);
        }
        return "voteView";
    }

    @RequestMapping(value = "/vote")
    public String vote(HttpSession httpSession, HttpServletResponse response) { // CID값이 0인지 다시 검증
        String uid = (String) httpSession.getAttribute("uid");
        System.out.println(uid);
        dao = new voteDAO();
        if (dao.select(uid)) {

            httpSession.setAttribute("uid", uid);
            return "voteView";
        } else {
            try {
                response.sendRedirect("/vote");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping(value = "/voteViewProcess")
    public String voteProcess(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        HttpSession httpSession = httpServletRequest.getSession();
        String uid = (String) httpSession.getAttribute("uid"); // 세션값 가져옴
        String voteResult = httpServletRequest.getParameter("radio"); //라디오버튼결과

        dao = new voteDAO();
        dao.update(voteResult, uid);

        try {
            response.sendRedirect("/vote");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
