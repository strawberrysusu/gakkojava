package daelim.java_ch03;

import daelim.java_ch03.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ScopeMainClass {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        InitSampleData initSampleData_01 = ctx.getBean("initSampleData", InitSampleData.class);
        InitSampleData initSampleData_02 = ctx.getBean("initSampleData", InitSampleData.class);

        if (initSampleData_01.equals(initSampleData_02)) {
            System.out.println(" initSampleData_01 == initSampleData_02");
        } else {
            System.out.println(" initSampleData_01 != initSampleData_02");
        }

        ctx.close();
    }
}
