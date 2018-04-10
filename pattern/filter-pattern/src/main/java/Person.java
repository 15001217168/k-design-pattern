import java.awt.*;

public class Person {


    private  String name;
    private String sex;
    private String maritalStatus;

    public Person(String name,String sex,String maritalStatus)
    {
        this.name=name;
        this.sex=sex;
        this.maritalStatus=maritalStatus;
    }

    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
}
