package ra.academy_project.presentation;

import ra.academy_project.validation.Validator;

import java.util.Scanner;

public class CousePresentation {
    public void courseManagementMenu(Scanner scanner) {
        boolean isExit = false;
        do {
            System.out.println("========== MENU COURSE MANAGEMENT ==========");
            System.out.println("1. Hien thi danh sach khoa hoc");
            System.out.println("2. Them moi khoa hoc");
            System.out.println("3. Chinh sua thong tin khoa hoc");
            System.out.println("4. Xoa khoa hoc");
            System.out.println("5. Tim kiem theo ten");
            System.out.println("6. Sap xep theo ten hoac id");
            System.out.println("7. Quay ve menu chinh");
            System.out.println("================================");

            int choice = Validator.inputValidInteger(scanner, "Nhap lua chon: ");

            switch (choice) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    isExit = true;
                    break;

                default:
                    System.out.println("Vui long chon tu 1-7");
            }
        } while (!isExit);
    }
}
