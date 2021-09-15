import ecs100.*;
import java.awt.Color;
/**
 * GUI for takeaways orders
 *
 * @author Harry Booth-Beach
 * @version 3/09/2021
 */
public class GUI
{
    private Orders od;
    private Food fd;
    private boolean foodMenuOpen = false;
    private boolean sidesMenuOpen = false;
    private boolean drinksMenuOpen = false;
    static final double BOX_X = 50;
    static final double BOX_Y = 20;
    static final double BOX_WIDTH = 120;
    static final double BOX_HEIGHT = 40;
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        od = new Orders();
        UI.initialise();
        UI.setMouseListener(this::doMouse);
        menu();
    }
    
    /**
     * Create main menu
     */
    public void menu()
    {
        UI.drawRect(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawRect(BOX_X + BOX_WIDTH + 20, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawRect(BOX_X + 2*BOX_WIDTH + 40, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
    }
    
    /**
     * Dropdown food menu
     */
    public void ddmFood()
    {
        for (int i = 1; i <= 4; i++)
        {
            UI.setColor(Color.black);
            UI.drawRect(BOX_X, BOX_Y+BOX_HEIGHT*i, BOX_WIDTH, BOX_HEIGHT);
            foodMenuOpen = true;
        }
    }
    
    /**
     * Dropdown sides menu
     */
    public void ddmSides()
    {
        for (int i = 1; i <= 4; i++)
        {
            UI.setColor(Color.black);
            UI.drawRect(BOX_X + BOX_WIDTH + 20, BOX_Y+BOX_HEIGHT*i, BOX_WIDTH, BOX_HEIGHT);
        }
    }
    
    /**
     * Dropdown drinks menu
     */
    public void ddmDrinks()
    {
        for (int i = 1; i <= 4; i++)
        {
            UI.setColor(Color.black);
            UI.drawRect(BOX_X + 2*BOX_WIDTH + 40, BOX_Y+BOX_HEIGHT*i, BOX_WIDTH, BOX_HEIGHT);
        }
    }
    
    /**
     * Hide dropdown menu
     */
    public void hide()
    {
        UI.setColor(Color.white);
        UI.fillRect(BOX_X, BOX_Y + BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT*4);
        UI.setColor(Color.black);
    }
    
    /**
     * Check to see if any dropdown menu is being clicked
     */
    public void doMouse(String action, double x, double y)
    {
        if (action.equals("clicked"))
            {
                if ((x >= BOX_X) &&
                    (x <= BOX_X + BOX_WIDTH) &&
                    (y >= BOX_Y) &&
                    (y <= BOX_Y + BOX_HEIGHT))
                {
                    if (foodMenuOpen == false)
                        ddmFood();
                    else
                    {    
                        foodMenuOpen = false;
                        hide();
                    }
                }
            }
    }
}