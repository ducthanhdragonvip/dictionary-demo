package database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class kết nối tới database
 */
public class MysqlConnector {
    //UserName Mysql
    private static String userName = "root";
    // Password Mysql
    private static String password = "1234";
    // localhost để kết nối đến MySql
    private static String urlConnection = "jdbc:mysql://localhost:3307/ditc";

    private static Connection connection;

    public static void init() {
        try {
            connection = DriverManager.getConnection(urlConnection, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static {
        init();
    }

    /**
     * lấy data và đẩy từ vòa trong list
     */

    public static void takeDataToArray(ArrayList<WordModel> listWord) {
        try {
            if(connection != null) {
                System.out.println("Successful connect to database");
                // tạo truy vấn
                Statement statement = (Statement) connection.createStatement();
                // lệnh truy vấn lấy tất cả dữ liệu từ bảng có trong kết nối
                String sql = "SELECT * FROM main";
                // thực hiện truy vấn
                ResultSet rs = statement.executeQuery(sql);
                // gán dữ liệu
                while (rs.next()) {
                    int index =rs.getInt("id");
                    String word =rs.getString("word");
                    String meaning = rs.getString("meaning");
                    WordModel wordModel = new WordModel(index,word,meaning);
                    // thêm từ vào ArrayList
                    listWord.add(wordModel);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }


}
