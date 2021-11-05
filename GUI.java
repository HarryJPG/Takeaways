import ecs100.*;
import java.awt.Color;
/**
 * GUI for takeaways orders
 *
 * @author Harry Booth-Beach
 * @version 21/10/2021
 */
public class GUI
{
    private Orders od;
    private Food fd;
    private int orderLength = 0;
    private String orderName = "";
    private boolean foodMenuOpen = false;
    private boolean sidesMenuOpen = false;
    private boolean drinksMenuOpen = false;
    static final double BOX_WIDTH = 120;
    static final double BOX_HEIGHT = 40;
    static final double BOX1_X = 50;
    static final double BOX2_X = BOX1_X + BOX_WIDTH + 20;
    static final double BOX3_X = BOX1_X + 2*BOX_WIDTH + 40;
    static final double BOX_Y = 20;
    static final double TEXT1_X = 40;
    static final double TEXT2_X = 5;
    static final double TEXT_Y = BOX_Y + 25;
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        od = new Orders();
        UI.initialise();
        UI.addTextField("Name for order", this::getName);
        UI.addButton("End Order", this::orderSummary);
        UI.setMouseListener(this::doMouse);
        menu();
    }
    
    /**
     * Create main menu
     */
    public void menu()
    {
        UI.drawRect(BOX1_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawString("Food", TEXT1_X + BOX1_X, TEXT_Y);
        UI.drawRect(BOX2_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawString("Sides", TEXT1_X + BOX2_X, TEXT_Y);
        UI.drawRect(BOX3_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawString("Drinks", TEXT1_X + BOX3_X, TEXT_Y);
    }
    
    /**
     * Dropdown food menu
     */
    public void ddmFood()
    {
        if (foodMenuOpen == false)
        {
            for (int i = 1; i <= 4; i++)
            {
                UI.setColor(Color.black);
                UI.drawRect(BOX1_X, BOX_Y+BOX_HEIGHT*i, BOX_WIDTH, BOX_HEIGHT);
                fd = od.getMenuFood(i);
                UI.drawString(fd.getFoodName(), TEXT2_X + BOX1_X, TEXT_Y + BOX_HEIGHT*i);
            }
            foodMenuOpen = true;
        }
        else
        {
            UI.setColor(Color.white);
            UI.fillRect(BOX1_X, BOX_Y + BOX_HEIGHT + 1, BOX_WIDTH + 1, BOX_HEIGHT*4 + 1);
            UI.setColor(Color.black);
            foodMenuOpen = false;
        }
    }
    
    /**
     * Dropdown sides menu
     */
    public void ddmSides()
    {
        if (sidesMenuOpen == false)
        {
            for (int i = 1; i <= 4; i++)
            {
                UI.setColor(Color.black);
                UI.drawRect(BOX2_X, BOX_Y+BOX_HEIGHT*i, BOX_WIDTH, BOX_HEIGHT);
                fd = od.getMenuFood(i+4);
                UI.drawString(fd.getFoodName(), TEXT2_X + BOX2_X, TEXT_Y + BOX_HEIGHT*i);
            }
            sidesMenuOpen = true;
        }
        else
        {
            UI.setColor(Color.white);
            UI.fillRect(BOX2_X, BOX_Y + BOX_HEIGHT + 1, BOX_WIDTH + 1, BOX_HEIGHT*4 + 1);
            UI.setColor(Color.black);
            sidesMenuOpen = false;
        }
    }
    
    /**
     * Dropdown drinks menu
     */
    public void ddmDrinks()
    {
        if (drinksMenuOpen == false)
        {
            for (int i = 1; i <= 4; i++)
            {
                UI.setColor(Color.black);
                UI.drawRect(BOX3_X, BOX_Y+BOX_HEIGHT*i, BOX_WIDTH, BOX_HEIGHT);
                fd = od.getMenuFood(i+8);
                UI.drawString(fd.getFoodName(), TEXT2_X + BOX3_X, TEXT_Y + BOX_HEIGHT*i);
            }
            drinksMenuOpen = true;
        }
        else
        {
            UI.setColor(Color.white);
            UI.fillRect(BOX3_X, BOX_Y + BOX_HEIGHT + 1, BOX_WIDTH + 1, BOX_HEIGHT*4 + 1);
            UI.setColor(Color.black);
            drinksMenuOpen = false;
        }
    }
    
    /**
     * Add food to order
     */
    public void addFood()
    {
        int quantity = UI.askInt("How many " + fd.getFoodName() + "(s)? ");
        if (quantity > 0 && quantity < 10)
        {
            while (quantity != 0)
                {
                    quantity--;
                    od.addFood(fd);
                    orderLength++;
                }
        }
        else
        {
            UI.println("Please input a valid number (1-9)");
            addFood();
        }
    }
    
    /**
     * Print all list items and total cost
     */
    public void orderSummary()
    {
        if (orderName == "")
        {
            UI.println("Please input a name for the order");
        }
        else if (orderName.length() > 30)
        {
            UI.println("Please input a name 30 or less characters");
        }
        else
        {
            double totalCost = 0;
            int orderRecieve = 0;
            String orderOption;
            while (orderRecieve != 1 && orderRecieve != 2)
            {
                orderRecieve = UI.askInt
                ("Pick up(1) or deliver(2)? ");
            }
            if (orderRecieve == 1)
            {
                orderOption = "is to be picked up";
            }
            else
            {
                orderOption = "will be delivered to you";
            }
            UI.println("Your order is: ");
            for (int i = 1; i <= orderLength; i++)
            {
                fd = od.getOrderFood(i);
                UI.println(fd.getFoodName());
                totalCost += fd.getPrice();
            }
            UI.println("Your name for the order is: " + orderName);
            UI.println("You order " + orderOption);
            UI.println("The total cost of your order is: $" + totalCost + "0");
        }
    }
    
    /**
     * Get the name for the order
     */
    public void getName(String name)
    {
        orderName = name;
    }
    
    /**
     * Check to see if any dropdown menu is being clicked
     */
    public void doMouse(String action, double x, double y)
    {
        if (action.equals("clicked"))
            {
                // open or close drop down menus
                if ((x >= BOX1_X) &&
                    (x <= BOX1_X + BOX_WIDTH) &&
                    (y >= BOX_Y) &&
                    (y <= BOX_Y + BOX_HEIGHT))
                {
                    ddmFood();
                }
                else if ((x >= BOX2_X) &&
                    (x <= BOX2_X + BOX_WIDTH) &&
                    (y >= BOX_Y) &&
                    (y <= BOX_Y + BOX_HEIGHT))
                {
                    ddmSides();
                }
                else if ((x >= BOX3_X) &&
                    (x <= BOX3_X + BOX_WIDTH) &&
                    (y >= BOX_Y) &&
                    (y <= BOX_Y + BOX_HEIGHT))
                {
                    ddmDrinks();
                }
                
                // add clicked food to list
                if (foodMenuOpen == true)
                {
                    for (int i = 1; i <= 4; i++)
                    {
                        if ((x >= BOX1_X) &&
                            (x <= BOX1_X + BOX_WIDTH) &&
                            (y >= BOX_Y + BOX_HEIGHT) &&
                            (y <= BOX_Y + BOX_HEIGHT + BOX_HEIGHT*i))
                        {
                            fd = od.getMenuFood(i);
                            this.addFood();
                            break;
                        }
                    }
                }
                
                if (sidesMenuOpen == true)
                {
                    for (int i = 1; i <= 4; i++)
                    {
                        if ((x >= BOX2_X) &&
                            (x <= BOX2_X + BOX_WIDTH) &&
                            (y >= BOX_Y + BOX_HEIGHT) &&
                            (y <= BOX_Y + BOX_HEIGHT + BOX_HEIGHT*i))
                        {
                            fd = od.getMenuFood(i+4);
                            this.addFood();
                            break;
                        }
                    }
                }
                
                if (drinksMenuOpen == true)
                {
                    for (int i = 1; i <= 4; i++)
                    {
                        if ((x >= BOX3_X) &&
                            (x <= BOX3_X + BOX_WIDTH) &&
                            (y >= BOX_Y + BOX_HEIGHT) &&
                            (y <= BOX_Y + BOX_HEIGHT + BOX_HEIGHT*i))
                        {
                            fd = od.getMenuFood(i+8);
                            this.addFood();
                            break;
                        }
                    }
                }
            }
    }
}