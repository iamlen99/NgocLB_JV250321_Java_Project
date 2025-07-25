package ra.academy_project.presentation;

import ra.academy_project.business.EnrollmentService;
import ra.academy_project.business.impl.EnrollmentServiceImpl;
import ra.academy_project.validation.Validator;

import java.util.Scanner;

public class EnrollmentManagementPresentation {
    public final EnrollmentService enrollmentService;

    public EnrollmentManagementPresentation() {
        enrollmentService = new EnrollmentServiceImpl();
    }

    public void enrollmentManagementMenu(Scanner scanner) {
        boolean isExit = false;
        do {
            System.out.println("======================== MENU ENROLLMENT MANAGEMENT ========================");
            System.out.println("1. Hien thi hoc vien theo tung khoa hoc");
            System.out.println("2. Them hoc vien vao khoa hoc");
            System.out.println("3. Xoa hoc vien khoi khoa hoc");
            System.out.println("4. Quay ve menu chinh");
            System.out.println("============================================================================");

            int choice = Validator.inputValidInteger(scanner, "Nhap lua chon: ");

            switch (choice) {
                case 1:
                    displayCourseEnrolledStudents();
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    isExit = true;
                    break;

                default:
                    System.out.println("Vui long chon tu 1-4");
            }
        } while (!isExit);
    }

    public void displayCourseEnrolledStudents (){
        System.out.printf("| %-12s | %-12s | %-22s | %-11s | %-20s | %-20s | %-10s |\n", "Ma dang ky", "Ma sinh vien", "Ten sinh vien"
                , "Ma khoa hoc", "Ten khoa hoc", "Ngay dang ky", "Trang thai");
        enrollmentService.displayCourseEnrolledStudents();
    }
}
