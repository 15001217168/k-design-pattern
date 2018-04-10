
import java.util.List;
import java.util.ArrayList;

public class Meal {

    private List<Item> _items = new ArrayList<Item>();

    public void addItem(Item item) {
        _items.add(item);
    }

    public float getCost() {
        float cost = 0f;
        for (Item i : _items) {
            cost += i.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item i : _items) {
            System.out.print("Item : " + i.name());
            System.out.print(", Packing : " + i.packing().pack());
            System.out.println(", Price : " + i.price());
        }
    }
}
