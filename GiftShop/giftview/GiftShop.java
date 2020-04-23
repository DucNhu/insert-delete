package GiftShop.giftview;

import GiftShop.giftController.GiftController;

import java.util.Scanner;

public class GiftShop {
    public static void main(String[] args) {
        GiftController giftController= new GiftController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:\n" +
                "1: Hiển thị toàn bộ chi tiết quà tặng\n" +
                "2: Thêm dữ liệu quà tặng\n" +
                "3: Xóa dữ liệu quà tặng\n" +
                "4: end");
        boolean T = true;
        while (T) {
            System.out.println("Nhập số bạn chọn:");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    giftController.select();break;
                case 2:
                    giftController.insert();break;
                case 3:
                    giftController.delete();break;
                case 4:  T = false;
                    System.out.println("END");break;
                default:
                    System.out.println("Vui lòng nhập lại");

            }
        }

    }
}

