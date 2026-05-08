package dealim.java_ch05.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {

    private Map<String, MemberVo> members = new HashMap<String, MemberVo>();

    public void insertMember(MemberVo memberVo) {
        System.out.println("MemberDao::insertMember");

        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        members.put(memberVo.getId(), memberVo);
        printAllMember();
    }

    public MemberVo getMember(MemberVo memberVo) {
        System.out.println("MemberDao::getMember");

        MemberVo member = members.get(memberVo.getId());

        if (member != null && memberVo.getPassword().equals(member.getPassword())) {
            return member;
        } else {
            return null;
        }
    }

    public void printAllMember() {
        System.out.println("MemberDao::printAllMember");

        Set<String> keys = members.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            MemberVo memberVo = members.get(key);

            System.out.println("id: " + memberVo.getId());
            System.out.println("password: " + memberVo.getPassword());
            System.out.println("email: " + memberVo.getEmail());
            System.out.println("phone: " + memberVo.getPhone());
        }
    }
}
