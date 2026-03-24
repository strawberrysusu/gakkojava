package java_ch04.contact;

import java_ch04.contact.service.ContactRegisterService;
import java_ch04.contact.service.ContactSearchService;
import java_ch04.contact.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        String[] names = initSampleData.getNames();
        String[] phoneNumbers = initSampleData.getPhoneNumbers();

        ContactRegisterService contactRegisterService = ctx.getBean("registerService", ContactRegisterService.class);
        for (int i = 0; i < names.length; i++) {
            ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
            contactRegisterService.register(contactSet);
        }

        ContactSearchService contactSearchService = ctx.getBean("searchService", ContactSearchService.class);

        System.out.println("===== 전체 연락처 정보 =====");
        for (String name : names) {
            ContactSet contactSet = contactSearchService.searchContact(name);
            System.out.println("name : " + contactSet.getName());
            System.out.println("phone number : " + contactSet.getPhoneNumber());
            System.out.println();
        }

        System.out.println("===== 특정 인물 연락처 =====");
        ContactSet contactSet = contactSearchService.searchContact("류현진");
        System.out.println("name : " + contactSet.getName());
        System.out.println("phone number : " + contactSet.getPhoneNumber());

        ctx.close();
    }
}
