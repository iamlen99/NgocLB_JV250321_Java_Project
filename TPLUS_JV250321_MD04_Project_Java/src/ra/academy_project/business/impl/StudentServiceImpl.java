package ra.academy_project.business.impl;

import ra.academy_project.business.StudentService;
import ra.academy_project.dao.StudentDAO;
import ra.academy_project.dao.impl.StudentDAOImpl;
import ra.academy_project.model.Student;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    public final StudentDAO studentDAO;
    public StudentServiceImpl() {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    public Optional<Student> login(String email, String password) {
        return studentDAO.login(email, password);
    }
}
