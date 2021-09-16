package Pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

public class voteDAO {

    DBconn dBconn = new DBconn();
    Connection conn = dBconn.connect();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "";

    public void resourceClose() {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (resultSet != null) resultSet.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
        }
    }

    public Map<String, String> readAll() {
        Map<String, String> map = null;

        try {
            String sql = "select * from user";

            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                map = new Hashtable<String, String>();

                while (resultSet.next()) {
                    System.out.println("db 저장된 id : " + resultSet.getString("UID"));
                    System.out.println("db 저장된 pw : " + resultSet.getString("PW"));
                    User user = new User(resultSet.getString("UID"), resultSet.getString("PW"));
                    map.put(user.getUID(), user.getPW());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resourceClose();
        }


        return map;
    }

    public int isin(String uname, String pw, Map<String, String> map) {
        if (map.containsKey(uname)) {
            if (pw.equals(map.get(uname)))
                return 1;
            else
                return 2;
        } else
            return 3;
    }

    public boolean select(String uid) {
        try {
            sql = "select * from user where UID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, uid);
            resultSet = preparedStatement.executeQuery();
            System.out.println("쿼리실행");
            if (resultSet.next()) {
                String res = resultSet.getString("CID");
                if (res == null) {
                    return false;
                } else if (!res.equals("0")) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            resourceClose();
        }
        return true;
    }

    public void update(String voteResult, String uid) {
        try {
            sql = "update user set CID = ? where UID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, voteResult);
            preparedStatement.setString(2, uid);
            preparedStatement.executeUpdate();
            System.out.println("쿼리실행");
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            resourceClose();
        }
    }

    public ResultSet select() {
        try {
            sql = "select CID, count(*) as count from user group by CID ORDER BY CID;";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("쿼리실행");
            return resultSet;
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
//            resourceClose();
        }
        return null;
    }

}
