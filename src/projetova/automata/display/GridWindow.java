package projetova.automata.display;

import java.awt.Dimension;
import javax.swing.JFrame;

public class GridWindow extends JFrame
{
    public GridWindow()
    {
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public GridWindow(int width, int height)
    {
        this();
        this.setSize(width, height);
        this.setPreferredSize(new Dimension (width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.pack();
    }
}
