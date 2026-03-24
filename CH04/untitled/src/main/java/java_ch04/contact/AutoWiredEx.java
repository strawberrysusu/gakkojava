package java_ch04.contact;

import java_ch04.contact.service.FirstBean;
import java_ch04.contact.service.SecondBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWiredEx {

    @Autowired
    public AutoWiredEx(@Qualifier("usedBean") FirstBean firstBean, SecondBean secondBean) {
        System.out.println("firstBean : " + firstBean);
        System.out.println("secondBean : " + secondBean);
    }
}
