import ecs100.*;
/**
 * Support class for Orders
 *
 * @author Harry Booth-Beach
 * @version 2/09/2021
 */
public class Food
{
    // fields
    private int foodId;
    private String foodName;
    private double price;
    
    /**
     * Constructor for objects of class Food
     */
    public Food(int fdId, String fdnm, double prce)
    {
        this.foodId = fdId;
        this.foodName = fdnm;
        this.price = prce;
    }
    
    /**
     * Getter for id
     * 
     * @return id
     */
    public int getFoodId()
    {
        return this.foodId;
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