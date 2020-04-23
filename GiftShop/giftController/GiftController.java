package GiftShop.giftController;

import GiftShop.giftmodel.Gift;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class GiftController {
    public static void myGift() {
        Gift gift = new Gift();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id:");
        gift.setID(scanner.nextInt());
        System.out.println("Nhap name:");
        gift.setName(scanner.next());
        System.out.println("Nhap price:");
        gift.setPrice(scanner.nextDouble());
        System.out.println("Nhap qty:");
        gift.setQty(scanner.nextInt());
    }

    public static void getID() {
        Gift gift = new Gift();
        gift.getID();
    }

    public static void getName() {
        Gift gift = new Gift();
        gift.getName();
    }

    public static void getPrice() {
        Gift gift = new Gift();
        gift.getPrice();
    }

    public static void getQty() {
        Gift gift = new Gift();
        gift.getQty();
    }

    public void select() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement statement = connection.createStatement();
        ) {
            Gift gift = new Gift();

            ResultSet resultSet = statement.executeQuery("select * from gift");
            System.out.println("ID \t\t name \t\t price \t\t qty");
            int i = 1;
            while (i > 0) {

//                getID();
                System.out.print(gift.getID() + "\t\t  " + gift.getName() + "\t\t\t  " + gift.getPrice() + "\t\t\t   " + gift.getQty() + "\n");
//                getName();
                ;
//                getPrice();
                ;
//                getQty();
                ;
                i = -1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        Gift gift = new Gift();
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement statement = connection.createStatement();
        ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap id:");
            gift.setID(scanner.nextInt());
            System.out.println("Nhap name:");
            gift.setName(scanner.next());
            System.out.println("Nhap price:");
            gift.setPrice(scanner.nextDouble());
            System.out.println("Nhap qty:");
            gift.setQty(scanner.nextInt());

            String select = "insert into gift values (" + gift.getID() + ",'" + gift.getName() + "'," + gift.getQty() + ", " + gift.getPrice() + ")";
            int countInsert = statement.executeUpdate(select);
            System.out.println(countInsert + " ban ghi da select");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        Gift gift = new Gift();
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement statement = connection.createStatement();
        ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap id ban muon xoa:");
            int id = scanner.nextInt();
            gift.setID(id);
            String select = "DELETE FROM gift WHERE id = " + gift.getID();
            int count = statement.executeUpdate(select);
            System.out.println(count + " ban ghi da delete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
