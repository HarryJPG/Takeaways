import ecs100.*;
/**
 * Support class for Orders
 *
 * @author Harry Booth-Beach
 * @version 31/08/2021
 */
public class Food
{
    // fields
    private int id;
    private String foodName;
    private double price;
    
    /**
     * Constructor for objects of class Food
     */
    public Food(int id, String fdnm, double prce)
    {
        this.id = id;
        this.foodName = fdnm;
        this.price = prce;
    }
    
    /**
     * Getter for id
     * 
     * @return id
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * Getter for foodName
     * 
     * @return foodName
     */
    public String getFoodName()
    {
        return this.foodName;
    }
    
    /**
     * Getter for price
     * 
     * @return price
     */
    public double getPrice()
    {
        return this.price;
    }
}
