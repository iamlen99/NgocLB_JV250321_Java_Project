package ra.academy_project.dao.impl;

import ra.academy_project.dao.StudentDAO;
import ra.academy_project.model.Student;
import ra.academy_project.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public Optional<Student> login(String email, String password) {
        Optional<Student> result = Optional.empty();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE email = ? AND password = ?";
        try {
            conn = DBUtil.openConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, password);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setDob(LocalDate.parse(rs.getString("dob")));
                student.setEmail(rs.getString("email"));
                student.setSex(rs.getBoolean("sex"));
                student.setPhone(rs.getString("phone"));
                student.setPassword(rs.getString("password"));
                student.setCreateAt(LocalDate.parse(rs.getString("create_at")));
                result = Optional.of(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(preStmt);
            DBUtil.closeConnection(conn);
        }
        return result;
    }
}
