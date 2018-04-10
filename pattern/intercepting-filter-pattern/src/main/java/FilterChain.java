import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<IFilter> filters = new ArrayList<IFilter>();
    private Target target;

    public void addFilter(IFilter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (IFilter item : filters) {
            item.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
