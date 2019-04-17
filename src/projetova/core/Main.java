package projetova.core;

import javax.swing.JFrame;
import projetova.display.GridPanel;
import projetova.display.GridWindow;
import projetova.model.Grid;
import projetova.model.Rule;

public class Main
{
    public static void main(String args[])
    {
        Grid g[] = new Grid[3];
        for(int i = 0; i < 3; i++)
            g[i] = new Grid(200, 339);

        g[0].init(new Rule(30));
        g[1].init(new Rule(110));
        g[2].init(new Rule(18));

        GridPanel gp[] = new GridPanel[3];
        for(int i = 0; i < 3; i++) {
            gp[i] = new GridPanel(g[i]);
            gp[i].setSquareSideLength(4);
        }

        GridWindow w[] = new GridWindow[3];
        for(int i = 0; i < 3; i++) {
            w[i].add(gp[i]);
            w[i].pack();
        }
    }
}
