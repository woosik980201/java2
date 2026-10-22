
package jdbc;

import java.sql.*;

public class JDBCConnector {

    private static final String DRIVER_PATH =
            "oracle.jdbc.OracleDriver";
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER_NAME = "c##pws";
    private static final String PASSWORD = "1234";

    private static Connection con;

    public static Connection getConnection() {

        // 1. JDBC Driver Load
        try {
            Class.forName(DRIVER_PATH);
            System.out.println("JDBC Driver 클래스 메모리 로드 성공");

            // 2. Connection
            con = DriverManager.getConnection(
                    URL, USER_NAME, PASSWORD);

            System.out.println("Connection Done Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver 클래스를 찾을 수 없습니다.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return con;
    }

    public static void resultSetTest() {

        // 3. SQL문 작성
        String sql = "SELECT * FROM 고객";

        if (con == null) {
            System.out.println("DB 연결이 되어 있지 않습니다.");
            return;
        }

        // 4. SQL 실행 및 결과 조회
        try (PreparedStatement pstmt =
                     con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.print(rs.getString("고객아이디") + "\t");
                System.out.print(rs.getString("고객이름") + "\t");
                System.out.print(rs.getString("직업") + "\t");
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("SQL 실행 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        getConnection();
        resultSetTest();
    }
}