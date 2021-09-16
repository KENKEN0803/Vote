package Pack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {// 변경 요함
    Connection conn = null;
    String server = "thezone.ccejljkrqsuj.ap-northeast-2.rds.amazonaws.com";
    String database = "db01";
    String user_name = "root";
    String password = "88198819";

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false&useUnicode=true&characterEncoding=utf8&&characterSetResults=UTF-8", user_name, password);
            System.out.println("jdbc:mysql://" + server + "/" + database + "?useSSL=false&useUnicode=true&characterEncoding=utf8" + user_name + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
