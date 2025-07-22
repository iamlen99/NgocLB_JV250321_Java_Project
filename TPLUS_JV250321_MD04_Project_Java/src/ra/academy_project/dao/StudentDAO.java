package ra.academy_project.dao;

import ra.academy_project.model.Student;

import java.util.Optional;

public interface StudentDAO {
    Optional<Student> login(String email, String password);
}
