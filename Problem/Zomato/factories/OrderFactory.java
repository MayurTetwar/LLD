package Problem.Zomato.factories;

import Problem.Zomato.models.*;
import Problem.Zomato.strategies.*;
import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}