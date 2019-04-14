package projetova.core;

import javax.swing.JFrame;
import projetova.display.GridPanel;
import projetova.display.Window;
import projetova.model.Grid;
import projetova.model.Rule;

public class Main
{    
    public static void main(String args[])
    {
        Grid g = new Grid(200, 339);
            g.init(new Rule(30));
        
        GridPanel gp = new GridPanel(g);
        gp.setSquareSideLength(4);
        
        int width = gp.getWidth();
        int height = gp.getHeight();
        
        Window window = new Window();
        window.setTitle("Rule 30");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.add(gp);
        window.pack();
    }
}
