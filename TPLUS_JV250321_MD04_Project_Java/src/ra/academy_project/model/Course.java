package ra.academy_project.model;

import ra.academy_project.validation.Validator;

import java.time.LocalDate;

public class Course {
    private int id;
    private String name;
    private int duration;
    private String instructor;
    private LocalDate createAt;

    public Course() {
    };

    public Course(int id, String name, int duration, String instructor, LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.instructor = instructor;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return String.format("| %-3d | %-22s | %-10s | %-15s | %-10s |", this.id, this.name, this.duration + " gio"
                , this.instructor, this.createAt.format(Validator.formatter));
    }

    public static void printMenu() {
        System.out.printf("| %-12s | %-12s | %-11s | %-20s | %-20s | %-10s |\n", "Ma dang ky", "Ma sinh vien"
                , "Ma khoa hoc", "Ten khoa hoc", "Ngay dang ky", "Trang thai");
    }
}
