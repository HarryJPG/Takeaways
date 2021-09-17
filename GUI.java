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
    static final double BOX_WIDTH = 120;
    static final double BOX_HEIGHT = 40;
    static final double BOX1_X = 50;
    static final double BOX2_X = BOX1_X + BOX_WIDTH + 20;
    static final double BOX3_X = BOX1_X + 2*BOX_WIDTH + 40;
    static final double BOX_Y = 20;
    static final double TEXT_X = 40;
    static final double TEXT_Y = BOX_Y + 25;
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
        UI.drawRect(BOX1_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawString("Food", TEXT_X + BOX1_X, TEXT_Y);
        UI.drawRect(BOX2_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawString("Sides", TEXT_X + BOX2_X, TEXT_Y);
        UI.drawRect(BOX3_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        UI.drawString("Drinks", TEXT_X + BOX3_X, TEXT_Y);
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
     * Check to see if any dropdown menu is being clicked
     */
    public void doMouse(String action, double x, double y)
    {
        if (action.equals("clicked"))
            {
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
            }
    }
}