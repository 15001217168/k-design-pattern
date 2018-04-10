import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<IOrder> orders = new ArrayList<IOrder>();

    public void takeOrder(IOrder order) {
        orders.add(order);
    }

    public void placeOrders() {
        for (IOrder order : orders) {
            order.execute();
        }
        orders.clear();
    }
}
