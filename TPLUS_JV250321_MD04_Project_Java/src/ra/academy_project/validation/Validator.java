package ra.academy_project.validation;

import java.util.Scanner;

public class Validator {
    public static boolean isEmpty (String data) {
        return data == null || data.trim().isEmpty();
    }

    public static String inputNotEmptyData (Scanner scanner, String message) {
        System.out.print(message);
        do {
            String input = scanner.nextLine();
            if (!isEmpty(input)) {
                return input;
            }
            System.err.println("Ban chua nhap gi ca!");
        } while (true);

    }

    public static boolean isInteger(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int inputValidInteger(Scanner scanner, String message) {
        System.out.print(message);
        do {
            String input = scanner.nextLine();
            if (isInteger(input)) {
                return Integer.parseInt(input);
            }
            System.err.println("Vui long nhap vao mot so nguyen:");
        } while (true);
    }
}
