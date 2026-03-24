package daelim.java_ch03.member.dao;

import daelim.java_ch03.member.Student;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentDao {

    private final Map<String, Student> studentDB = new LinkedHashMap<>();

    public Map<String, Student> getStudentDB() {
        return studentDB;
    }

    public void insert(Student student) {
        studentDB.put(student.getsNum(), student);
    }

    public Student select(String sNum) {
        return studentDB.get(sNum);
    }

    public Map<String, Student> selectAll() {
        return getStudentDB();
    }

    public void update(Student student) {
        studentDB.put(student.getsNum(), student);
    }

    public void delete(String sNum) {
        studentDB.remove(sNum);
    }
}
