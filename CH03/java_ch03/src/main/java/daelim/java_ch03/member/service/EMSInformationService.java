package daelim.java_ch03.member.service;

import daelim.java_ch03.member.DBConnectionInfo;
import java.util.List;
import java.util.Map;

public class EMSInformationService {

    private String info;
    private String copyRight;
    private String ver;
    private int sYear;
    private int sMonth;
    private int sDay;
    private int eYear;
    private int eMonth;
    private int eDay;
    private List<String> developers;
    private Map<String, String> administrators;
    private Map<String, DBConnectionInfo> dbInfos;

    public void printEMSInformation() {
        System.out.println("EMS INFORMATION START =============");
        System.out.println("info : " + info);
        System.out.println("copyRight : " + copyRight);
        System.out.println("version : " + ver);
        System.out.println("service period : " + sYear + "-" + sMonth + "-" + sDay
                + " ~ " + eYear + "-" + eMonth + "-" + eDay);

        System.out.println("developers");
        for (String developer : developers) {
            System.out.println("- " + developer);
        }

        System.out.println("administrators");
        for (Map.Entry<String, String> administrator : administrators.entrySet()) {
            System.out.println("- " + administrator.getKey() + " : " + administrator.getValue());
        }

        System.out.println("database connections");
        for (Map.Entry<String, DBConnectionInfo> dbInfo : dbInfos.entrySet()) {
            DBConnectionInfo value = dbInfo.getValue();
            System.out.println("- " + dbInfo.getKey() + " : "
                    + value.getUrl() + " / " + value.getUserId() + " / " + value.getUserPw());
        }
        System.out.println("END =============");
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public void setsYear(int sYear) {
        this.sYear = sYear;
    }

    public void setsMonth(int sMonth) {
        this.sMonth = sMonth;
    }

    public void setsDay(int sDay) {
        this.sDay = sDay;
    }

    public void seteYear(int eYear) {
        this.eYear = eYear;
    }

    public void seteMonth(int eMonth) {
        this.eMonth = eMonth;
    }

    public void seteDay(int eDay) {
        this.eDay = eDay;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    public void setAdministrators(Map<String, String> administrators) {
        this.administrators = administrators;
    }

    public void setDbInfos(Map<String, DBConnectionInfo> dbInfos) {
        this.dbInfos = dbInfos;
    }
}
