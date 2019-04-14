package projetova.display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import projetova.model.Grid;

public class GridPanel extends JPanel
{
    Grid grid;
    int squareSideLength = 10;
    
    public GridPanel(Grid grid)
    {
        this.grid = grid;
    }
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int n = grid.getRows();
        int m = grid.getColumns();
        int length = this.squareSideLength;
        
        for (int y = 0; y < n; y++)
        {
            for (int x = 0; x < m; x++)
            {
                if(this.grid.get(y, x) == '1')
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.WHITE);
                
                g.fillRect(5 + x * length, 15 + y * length, this.squareSideLength, this.squareSideLength);

                g.setColor(Color.BLACK);
                g.drawRect(5 + x * length, 15 + y * length, this.squareSideLength, this.squareSideLength);
            }
        }
    }
    
    public void setSquareSideLength(int length) 
    {
        this.squareSideLength = length;
    }
}
