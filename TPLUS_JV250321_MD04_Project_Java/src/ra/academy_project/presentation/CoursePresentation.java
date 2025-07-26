package ra.academy_project.presentation;

import ra.academy_project.business.CourseService;
import ra.academy_project.business.impl.CourseServiceImpl;
import ra.academy_project.model.Course;
import ra.academy_project.pagination.Pagination;
import ra.academy_project.validation.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoursePresentation {
    public final CourseService courseService;

    public CoursePresentation() {
        courseService = new CourseServiceImpl();
    }

    public void courseManagementMenu(Scanner scanner) {
        boolean isExit = false;
        do {
            System.out.println("========================== MENU QUAN LY KHOA HOC ==========================");
            System.out.println("1. Hien thi danh sach khoa hoc");
            System.out.println("2. Them moi khoa hoc");
            System.out.println("3. Chinh sua thong tin khoa hoc");
            System.out.println("4. Xoa khoa hoc");
            System.out.println("5. Tim kiem theo ten");
            System.out.println("6. Sap xep theo ten hoac id");
            System.out.println("7. Quay ve menu chinh");
            System.out.println("============================================================================");

            int choice = Validator.inputValidInteger(scanner, "Nhap lua chon: ");

            switch (choice) {
                case 1:
                    displayAllCourses(scanner);
                    break;

                case 2:
                    addCourse(scanner);
                    break;

                case 3:
                    updateCourse(scanner);
                    break;

                case 4:
                    deleteCourse(scanner);
                    break;

                case 5:
                    findCourseByName(scanner);
                    break;

                case 6:
                    sortCoursesMenu(scanner);
                    break;

                case 7:
                    isExit = true;
                    break;

                default:
                    System.out.println("Vui long chon tu 1-7");
            }
        } while (!isExit);
    }

    public Course inputData(Scanner scanner) {
        Course course = new Course();
        course.setName(Validator.inputNotEmptyData(scanner, "Nhap ten khoa hoc: "));
        course.setDuration(Validator.inputPositiveInteger(scanner, "Nhap thoi luong khoa hoc (gio): "));
        course.setInstructor(Validator.inputNotEmptyData(scanner, "Nhap ten giang vien phu trach: "));
        return course;
    }

    public void displayAllCourses(Scanner scanner) {
        int currentPage = 1;
        final int pageSize = 5;
        int totalPages = courseService.getTotalPages(pageSize);
        System.out.println(totalPages);

        do {
            List<Course> courses = courseService.findAll(currentPage, pageSize);
            courseService.displayCourses(courses);
            int nextPage = Pagination.handlePagination(scanner, currentPage, totalPages);
            if (nextPage == -1) break;
            currentPage = nextPage;
        } while (true);
    }

    public void addCourse(Scanner scanner) {
        Course course = inputData(scanner);
        courseService.addCourse(course);
    }

    public void updateCourse(Scanner scanner) {
        int updateId = Validator.inputValidInteger(scanner, "Nhap id cua khoa hoc can cap nhat: ");
        courseService.findCourseById(updateId).ifPresentOrElse(course -> {
                    boolean isExit = false;
                    do {
                        System.out.println("1. Cap nhat ten khoa hoc");
                        System.out.println("2. Cap nhat thoi luong khoa hoc");
                        System.out.println("3. Cap nhat ten giang vien phu trach");
                        System.out.println("4. Thoat");

                        int choice = Validator.inputValidInteger(scanner, "Nhap lua chon: ");

                        switch (choice) {
                            case 1:
                                String newCourseName = Validator.inputNotEmptyData(scanner, "Nhap ten khoa hoc moi: ");
                                course.setName(newCourseName);
                                break;
                            case 2:
                                int newDuration = Validator.inputPositiveInteger(scanner, "Nhap thoi luong khoa hoc moi: ");
                                course.setDuration(newDuration);
                                break;
                            case 3:
                                String newInstructor = Validator.inputNotEmptyData(scanner, "Nhap ten giang vien phu trach moi: ");
                                course.setInstructor(newInstructor);
                                break;
                            case 4:
                                isExit = true;
                                break;
                            default:
                                System.err.println("Vui long chon tu 1-4");
                        }
                        courseService.updateCourse(course);
                    } while (!isExit);
                },
                () -> {
                    System.err.println("Id ban vua nhap khong ton tai!");
                });
    }

    public void deleteCourse(Scanner scanner) {
        int deleteId = Validator.inputValidInteger(scanner, "Nhap id cua khoa hoc can xoa: ");
        courseService.findCourseById(deleteId).ifPresentOrElse(course -> {
                    System.out.print("Ban co chac chan muon xoa khoa hoc nay khong, neu co hay nhap 'y': ");
                    String confirm = scanner.nextLine();
                    if (!confirm.equalsIgnoreCase("y")) {
                        return;
                    }
                    courseService.deleteCourse(course);
                },
                () -> {
                    System.err.println("Id ban vua nhap khong ton tai!");
                });
    }

    public void findCourseByName(Scanner scanner) {
        String courseName = Validator.inputNotEmptyData(scanner, "Nhap ten khoa hoc can tim: ");
        courseService.findCourseByName(courseName);
    }

    public void sortCoursesMenu(Scanner scanner) {
        System.out.println("1. Sap xep theo ten tang dan");
        System.out.println("2. Sap xep theo ten giam dan");
        System.out.println("3. Sap xep theo id tang dan");
        System.out.println("4. Sap xep theo id giam dan");

        int choice = Validator.inputValidInteger(scanner, "Nhap lua chon: ");
        switch (choice) {
            case 1:
                sortCourseByNameASC(scanner);
                break;

            case 2:
                sortCourseByNameDESC(scanner);
                break;

            case 3:
                sortCourseByIdASC(scanner);
                break;

            case 4:
                sortCourseByIdDESC(scanner);
                break;

            default:
                System.out.println("Vui long chon tu 1-4");
        }
    }

    public void sortCourseByNameASC(Scanner scanner) {
//        List<Course> courses = courseService.findAll();
//        if (courses.isEmpty()) {
//            System.out.println("Danh sach trong.");
//        } else {
//            courses.stream().sorted(Comparator.comparing(Course::getName)).forEach(System.out::println);
//        }
    }

    public void sortCourseByNameDESC(Scanner scanner) {
//        List<Course> courses = courseService.findAll();
//        if (courses.isEmpty()) {
//            System.out.println("Danh sach trong.");
//        } else {
//            courses.stream().sorted(Comparator.comparing(Course::getName).reversed()).forEach(System.out::println);
//        }
    }

    public void sortCourseByIdASC(Scanner scanner) {
//        List<Course> courses = courseService.findAll();
//        if (courses.isEmpty()) {
//            System.out.println("Danh sach trong.");
//        } else {
//            courses.stream().sorted(Comparator.comparing(Course::getId)).forEach(System.out::println);
//        }
    }

    public void sortCourseByIdDESC(Scanner scanner) {
//        List<Course> courses = courseService.findAll();
//        if (courses.isEmpty()) {
//            System.out.println("Danh sach trong.");
//        } else {
//            courses.stream().sorted(Comparator.comparing(Course::getId).reversed()).forEach(System.out::println);
//        }
    }
}
