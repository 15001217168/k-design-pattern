import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements ICriteria {
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> res=new ArrayList<Person>();
        for(Person item:persons)
        {
            if(item.getMaritalStatus().equalsIgnoreCase("SINGLE"))
            {
                res.add(item);
            }
        }
        return  res;
    }
}
