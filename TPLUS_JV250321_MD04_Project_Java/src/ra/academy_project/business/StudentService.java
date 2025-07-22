package ra.academy_project.business;
import ra.academy_project.model.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> login(String email, String password);
}
