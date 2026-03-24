package daelim.java_ch03.member.service;

import daelim.java_ch03.member.Student;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PrintStudentInformationService {

    private final StudentService studentService;

    public PrintStudentInformationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void printStudentInfo() {
        Map<String, Student> allStudents = studentService.selectAll();
        Set<String> keys = allStudents.keySet();
        Iterator<String> iterator = keys.iterator();

        System.out.println("STUDENT LIST START =============");
        while (iterator.hasNext()) {
            String key = iterator.next();
            Student student = allStudents.get(key);
            printStudent(student);
        }

        System.out.println("END =============");
    }

    private void printStudent(Student student) {
        System.out.print("sNum : " + student.getsNum() + "\t");
        System.out.print("sId : " + student.getsId() + "\t");
        System.out.print("sPw : " + student.getsPw() + "\t");
        System.out.print("sName : " + student.getsName() + "\t");
        System.out.print("sAge : " + student.getsAge() + "\t");
        System.out.print("sGender : " + student.getsGender() + "\t");
        System.out.print("sMajor : " + student.getsMajor());
        System.out.println();
        System.out.println("------------------------------");
    }
}
