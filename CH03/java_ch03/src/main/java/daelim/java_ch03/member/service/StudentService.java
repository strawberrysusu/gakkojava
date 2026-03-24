package daelim.java_ch03.member.service;

import daelim.java_ch03.member.Student;
import daelim.java_ch03.member.dao.StudentDao;
import java.util.Map;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void register(Student student) {
        if (!exist(student.getsNum())) {
            studentDao.insert(student);
        } else {
            System.out.println("already registered student : " + student.getsNum());
        }
    }

    public Student select(String sNum) {
        if (exist(sNum)) {
            return studentDao.select(sNum);
        }

        System.out.println("student not found : " + sNum);
        return null;
    }

    public Map<String, Student> selectAll() {
        return studentDao.getStudentDB();
    }

    public void modify(Student student) {
        if (exist(student.getsNum())) {
            studentDao.update(student);
        } else {
            System.out.println("cannot modify. student not found : " + student.getsNum());
        }
    }

    public void delete(String sNum) {
        if (exist(sNum)) {
            studentDao.delete(sNum);
        } else {
            System.out.println("cannot delete. student not found : " + sNum);
        }
    }

    private boolean exist(String sNum) {
        Student student = studentDao.select(sNum);
        return student != null;
    }
}
