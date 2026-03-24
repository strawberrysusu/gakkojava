package java_ch04.contact.service;

import java_ch04.contact.ContactSet;
import java_ch04.contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactRegisterService {

    private ContactDao contactDao;

    public ContactRegisterService() {
        System.out.println("default constructor");
    }

    @Autowired
    public ContactRegisterService(ContactDao contactDao) {
        System.out.println("1 : " + contactDao);
        this.contactDao = contactDao;
    }

    public void register(ContactSet contactSet) {
        String name = contactSet.getName();
        if (verify(name)) {
            contactDao.insert(contactSet);
        } else {
            System.out.println("The name has already registered.");
        }
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet == null ? true : false;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
