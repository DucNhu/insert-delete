package GiftShop;

import java.sql.*;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Books book = new Books(0,"","",0,0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id ban can sua");
        int Id = scanner.nextInt();
        System.out.println("Nhap name ban can sua");
        String Name = scanner.next();
        System.out.println("Nhap author ban can sua");
        String Author = scanner.next();
        System.out.println("Nhap price ban can sua");
        double price = scanner.nextDouble();
        System.out.println("Nhap qty ban can sua");
        int qty = scanner.nextInt();
        book.setId(Id);
        book.setName(Name);
        book.setAuthor(Author);
        book.setPrice(price);
        book.setQty(qty);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");

                Statement stmt = conn.createStatement();
        ) {

//            xóa tất cả cuốn sách có id>800
            String sqlDelete = "delete from ebooks where id >800";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

            // Thêm cùng lúc 2 bản ghi
            String sqlInsert = "insert into ebooks values "
                    + "(800, 'Java Core', 'Dang Kim Thi', 15.55, 55),"
                    + "(8004, 'Java Advanced', 'James Gosling', 25.55, 55)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // Thêm 1 cuốn sách có thông tin là (2001, 'Java JDBC MySQL', 'ThiDK');
            sqlInsert = "insert into ebooks (id, title, author) values (2001, 'Java JDBC MySQL', 'ThiDK')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

//            Xoá một cuối sách có id là do người dùng nhập vào, ví dụ id = 2001
            sqlDelete = "delete from ebooks where id =2001";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

//            Thêm mới một cuốn sách có đầy đủ thông tin do người dùng nhập vào từ bàn phím?
            Scanner input=new Scanner(System.in);
            System.out.println("nhap id cua cuon sach: ");
            int id=input.nextInt();
            System.out.println("nhap ten cuon sach: ");
            String bookname=input.next();
            System.out.println("nhap ten tac gia: ");
            String tentacgia=input.next();
            System.out.println("nhap so tien: ");
            int sotien=input.nextInt();
            System.out.println("nhap so luong: ");
            int soluong=input.nextInt();
            sqlInsert="insert into ebooks values ("+id+",'"+bookname+"','"+tentacgia+"',"+sotien+","+soluong+")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // Issue a SELECT to check the changes
            String strSelect = "select * from ebooks";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("author") + ", "
                        + rset.getString("title") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
