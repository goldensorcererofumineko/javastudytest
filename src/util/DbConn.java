package util;

import login.LoginFrame;

import java.sql.*;

public class DbConn {

    private Connection getconn() {


        String url = "jdbc:mysql://localhost:3306/weavus";
        String user = "root";
        String password = "";

        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public boolean login(String id, String pw) {
        Connection conn = getconn();
        try {
            String sql = "SELECT * FROM userinfo where id=? and pw=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();

            //中身の確認
            if (rs.next()) {
                LoginFrame.userIdl = rs.getString("id");
                return true;
            }
            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


