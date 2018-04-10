
import java.util.List;
import java.util.ArrayList;

public class Meal {

    private List<IItem> _items = new ArrayList<IItem>();

    public void addItem(IItem item) {
        _items.add(item);
    }

    public float getCost() {
        float cost = 0f;
        for (IItem i : _items) {
            cost += i.price();
        }
        return cost;
    }

    public void showItems() {
        for (IItem i : _items) {
            System.out.print("Item : " + i.name());
            System.out.print(", Packing : " + i.packing().pack());
            System.out.println(", Price : " + i.price());
        }
    }
}
