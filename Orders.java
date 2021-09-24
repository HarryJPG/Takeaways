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
    private HashMap<Integer, Food> orderMap;
    private int orderId = 0;
    
    /**
     * Constructor for objects of class Orders
     */
    public Orders()
    {
        // initialise instance variables
        foodMap = new HashMap<Integer, Food>();
        orderMap = new HashMap<Integer, Food>();
        // Create food
        Food f1 = new Food(1, "cheese burger", 15.00);
        Food f2 = new Food(2, "big burg", 20.00);
        Food f3 = new Food(3, "100 chicken nuggets", 500.00);
        Food f4 = new Food(4, "fish and chips", 0.50);
        Food f5 = new Food(5, "chips", 600.00);
        Food f6 = new Food(6, "salad", 1.50);
        Food f7 = new Food(7, "chicken tendies", 10.50);
        Food f8 = new Food(8, "children fingers", 30.50);
        Food f9 = new Food(9, "sparkling water", 10.00);
        Food f10 = new Food(10, "soup in a bottle", 90.00);
        Food f11 = new Food(11, "liquid chicken", 30.50);
        Food f12 = new Food(12, "cola", 6.00);
        
        // Add food to list
        foodMap.put(1, f1);
        foodMap.put(2, f2);
        foodMap.put(3, f3);
        foodMap.put(4, f4);
        foodMap.put(5, f5);
        foodMap.put(6, f6);
        foodMap.put(7, f7);
        foodMap.put(8, f8);
        foodMap.put(9, f9);
        foodMap.put(10, f10);
        foodMap.put(11, f11);
        foodMap.put(12, f12);
        
    }
    
    /**
     * Add food to order
     */
    public void addFood(Food name, double price)
    {
        orderId++;
        orderMap.put(orderId, name);
    }
    
    /**
     * Return food to GUI
     */
    public Food returnFood(int id)
    {
        return foodMap.get(id);
    }
}