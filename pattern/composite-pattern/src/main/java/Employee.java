import java.util.ArrayList;
import java.util.List;

public class Employee {
    private  String name;
    private String dept;
    private  int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates=new ArrayList<Employee>();
    }

    public void add(Employee item) {
        subordinates.add(item);
    }
    public  void  remove(Employee item)
    {
        subordinates.remove(item);
    }
    public  List<Employee> getSubordinates()
    {
        return  subordinates;
    }
    public String toString(){
        return ("Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]");
    }
}
