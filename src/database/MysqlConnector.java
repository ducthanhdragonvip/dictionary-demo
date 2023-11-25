package database;

import java.sql.*;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public class MysqlConnector {

    // username và password đăng nhập vào mysql
    private static String userName = "root";

    private static String password = "T1vodich";

    private static String urlConnection = "jdbc:mysql://localhost:3306/javafx?";

    private static Connection hasConnect;

    public static void init() {
        try {
            hasConnect = DriverManager.getConnection(urlConnection, userName, password);
        } catch (SQLException e) {
            // Throw
            e.printStackTrace();
        }
    }
    static {
        init();
    }

    // Hàm lấy dữ liều và đẩy từ vào list
    public static void takeData(ArrayList<WordModel> listWord) {
        try {
            // Nếu kết nối
            if (hasConnect != null) {
                System.out.println("kết nối thành công");

                // Tạo truy vấn thực hện với cơ sở dữ liệu
                Statement statement = (Statement) hasConnect.createStatement();
                String sql = "SELECT * FROM main";
                // Thực hiện truy vấn
                ResultSet rs = statement.executeQuery(sql);
                // nếu còn dữ liệu thì xử lí gán dữ liệu
                while(rs.next()) {
                    int id = rs.getInt("id");
                    // lấy giá trị nguyên từ cột id đang đc chỉ tới
                    String word = rs.getString("word");
                    String meaning = rs.getString("meaning");
                    WordModel wordModel = new WordModel(id, word, meaning);
                    listWord.add(wordModel);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }

    public static void addingWord(int id, String word, String meaning) {
        try {
            if (hasConnect != null) {
                System.out.println("Đã kết nối đến cơ sở dữ liệu");
            }
            // truy vấn lấy id cuối danh sách
            Statement statement = (Statement) hasConnect.createStatement();
            String sql = "SELECT id FROM main ORDER BY id DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(sql);
            int lastId = 0;
            if(rs.next()) {
                lastId = rs.getInt("id");
            }
            // Truy vấn thêm từ
            PreparedStatement preparedStatement = hasConnect.prepareStatement("INSERT INTO main VALUES (?, ?, ?)");
            preparedStatement.setInt(1, id); // gán giá trị thứ nhất là id
            preparedStatement.setString(2, word); // gán tham số thứ 2 là word
            preparedStatement.setString(3, meaning);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }

    public static void deleteWord(int id) {
        try {
            // Nếu kết nối
            if (hasConnect != null) {
                System.out.println("xóa thành công");

                // Tạo truy vấn thực hện với cơ sở dữ liệu
                //Statement statement = (Statement) hasConnect.createStatement();
                String sql = "DELETE FROM main WHERE id = ?";
                PreparedStatement statement = hasConnect.prepareStatement(sql);
                // Đổi từ int -> id
                statement.setString(1, String.valueOf(id));
                statement.execute();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }

    public static void updateWord(int id, String meaning) {
        try {
            if (hasConnect != null) {
                System.out.println("Đã kết nối đến cơ sở dữ liệu");

                String sql = "UPDATE main SET meaning = ? WHERE id = ?";
                // Tạo truy vấn
                PreparedStatement statement = hasConnect.prepareStatement(sql);
                statement.setString(1, meaning);
                statement.setInt(2, id);
                statement.execute();

            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }

    public static void takeNoteData(ArrayList<WordModel> notesList) {
        try {
            // Nếu kết nối
            if (hasConnect != null) {
                System.out.println("kết nối thành công");

                // Tạo truy vấn thực hện với cơ sở dữ liệu
                Statement statement = (Statement) hasConnect.createStatement();
                String sql = "SELECT * FROM notes";
                // Thực hiện truy vấn
                ResultSet rs = statement.executeQuery(sql);
                // nếu còn dữ liệu thì xử lí gán dữ liệu
                while(rs.next()) {
                    int id = rs.getInt("idNote");
                    // lấy giá trị nguyên từ cột id đang đc chỉ tới
                    String word = rs.getString("word");
                    String meaning = rs.getString("meaning");
                    WordModel wordModel = new WordModel(id, word, meaning);
                    notesList.add(wordModel);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }

    public static void addingNote(int id, String word, String meaning) {
        try {
            if (hasConnect != null) {
                System.out.println("Đã kết nối đến cơ sở dữ liệu khi thêm từ");
            }
            // truy vấn lấy id cuối danh sách
            Statement statement = (Statement) hasConnect.createStatement();
            String sql = "SELECT idNote FROM notes ORDER BY idNote DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(sql);


            int lastId = 0;
            if(rs.next()) {
                lastId = rs.getInt("idNote");
            }
            System.out.println(lastId);
            // Truy vấn thêm từ
            PreparedStatement preparedStatement = hasConnect.prepareStatement("INSERT INTO notes VALUES (?, ?, ?)");
            preparedStatement.setInt(1, id); // gán giá trị thứ nhất là id
            preparedStatement.setString(2, word); // gán tham số thứ 2 là word
            preparedStatement.setString(3, meaning);

            boolean execute = preparedStatement.execute();
            System.out.println("abc");

        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql khi thêm từ");
            e.printStackTrace();
        }
    }

    public static void deleteNote(int id) {
        try {
            // Nếu kết nối
            if (hasConnect != null) {
                System.out.println("kết nối thành công");

                // Tạo truy vấn thực hện với cơ sở dữ liệu
                //Statement statement = (Statement) hasConnect.createStatement();
                String sql = "DELETE FROM notes WHERE idNote = ?";
                PreparedStatement statement = hasConnect.prepareStatement(sql);
                // Đổi từ int -> id
                statement.setString(1, String.valueOf(id));
                statement.execute();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }

    public static void updateNote(int id, String meaning) {
        try {
            if (hasConnect != null) {
                System.out.println("Đã kết nối đến cơ sở dữ liệu");

                String sql = "UPDATE notes SET meaning = ? WHERE idNote = ?";
                // Tạo truy vấn
                PreparedStatement statement = hasConnect.prepareStatement(sql);
                statement.setString(1, meaning);
                statement.setInt(2, id);
                statement.execute();

            }
        } catch (SQLException e) {
            System.out.println("Lỗi ! Không thể kết nối đến mysql");
            e.printStackTrace();
        }
    }
}
