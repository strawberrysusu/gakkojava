package daelim.java_ch03;

import daelim.java_ch03.member.Student;
import daelim.java_ch03.member.service.EMSInformationService;
import daelim.java_ch03.member.service.PrintStudentInformationService;
import daelim.java_ch03.member.service.StudentService;
import daelim.java_ch03.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        // 샘플 데이터
        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        String[] sNums = initSampleData.getsNums();
        String[] sIds = initSampleData.getsIds();
        String[] sPws = initSampleData.getsPws();
        String[] sNames = initSampleData.getsNames();
        int[] sAges = initSampleData.getsAges();
        char[] sGenders = initSampleData.getsGeners();
        String[] sMajors = initSampleData.getsMajors();

        // 데이터베이스에 샘플 등록
        StudentService studentService = ctx.getBean("studentService", StudentService.class);
        for (int i = 0; i < sNums.length; i++) {
            studentService.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
        }

        // 학생 리스트
        PrintStudentInformationService printStudentInformationService =
                ctx.getBean("printStudentInformationService", PrintStudentInformationService.class);
        printStudentInformationService.printStudentInfo();

        // 학생 등록
        studentService.register(new Student("test006", "test", "0000", "학생등록", 26, 'W', "FFF"));

        // 학생 리스트
        printStudentInformationService.printStudentInfo();

        // 학생 출력
        Student selectStudent = studentService.select("test006");

        System.out.println("SELECT STUDENT START =============");
        System.out.println("sNum : " + selectStudent.getsNum());
        System.out.println("sId : " + selectStudent.getsId());
        System.out.println("sPw : " + selectStudent.getsPw());
        System.out.println("sName : " + selectStudent.getsName());
        System.out.println("sAge : " + selectStudent.getsAge());
        System.out.println("sGender : " + selectStudent.getsGender());
        System.out.println("sMajor : " + selectStudent.getsMajor());
        System.out.println("END =============");

        // 학생 수정
        selectStudent.setsMajor("전공수정");
        studentService.modify(selectStudent);
        printStudentInformationService.printStudentInfo();

        // 학생 삭제
        studentService.delete("spring005");
        printStudentInformationService.printStudentInfo();

        // 시스템 정보
        EMSInformationService emsInformationService =
                ctx.getBean("eMSInformationService", EMSInformationService.class);
        emsInformationService.printEMSInformation();

        ctx.close();
    }
}
