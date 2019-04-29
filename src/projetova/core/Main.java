package projetova.core;

import java.io.IOException;
import projetova.automata.display.GridPanel;
import projetova.automata.display.GridWindow;
import projetova.automata.model.Grid;
import projetova.automata.model.Rule;
import projetova.fractal.dragoncurve.display.DragonGrid;
import projetova.fractal.dragoncurve.model.DragonCurve;
import projetova.utils.ComplexNumber;

public class Main
{
    public static void main(String args[]) throws IOException {
//        Grid g[] = new Grid[3];
//        for(int i = 0; i < 3; i++)
//            g[i] = new Grid(200, 339);
//
//        g[0].init(new Rule(30));
//        g[1].init(new Rule(110));
//        g[2].init(new Rule(18));
//
//        GridPanel gp[] = new GridPanel[3];
//        for(int i = 0; i < 3; i++) {
//            gp[i] = new GridPanel(g[i]);
//            gp[i].setSquareSideLength(4);
//        }
//
//        GridWindow w[] = new GridWindow[3];
//        for(int i = 0; i < 3; i++) {
//            w[i].add(gp[i]);
//            w[i].pack();
//        }
        DragonCurve dc = new DragonCurve();
        dc.generateCurve(14);
        DragonGrid dg = new DragonGrid(dc, true, true);
        dg.draw();
    }
}
