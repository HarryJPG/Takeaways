import java.util.HashMap;
import ecs100.*;
/**
 * Stores food in orders
 *
 * @author Harry Booth-Beach
 * @version 2/09/2021
 */
public class Orders
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Food> foodMap;
    private HashMap<Integer, Food> ordersMap;
    /**
     * Constructor for objects of class Orders
     */
    public Orders()
    {
        // initialise instance variables
        foodMap = new HashMap<Integer, Food>();
        ordersMap = new HashMap<Integer, Food>();
        // Create food
        Food f1 = new Food(1, "cheese burger", 15.00);
        Food f2 = new Food(2, "big mac", 20.00);
        Food f3 = new Food(3, "chicken nugget", 500.00);
        Food f4 = new Food(4, "fish and chips", 0.50);
        
        // Add food to list
        foodMap.put(1, f1);
        foodMap.put(2, f2);
        foodMap.put(3, f3);
        foodMap.put(4, f4);
        
    }
    
    public void addFood(String foodName, int quantity)
    {
        
    }
}
