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

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        od = new Orders();
        UI.initialise();
        UI.addTextField("Name", this::);
    }
    
}
