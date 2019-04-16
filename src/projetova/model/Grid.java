package projetova.model;

public class Grid
{
    public int x, y;
    public char[][] matrix;

    public Grid () {
        this(40);
    }

    public Grid(int n)
    {
        this(n, n);
    }

    public Grid(int n, int m) {
        this.matrix = new char[n][m];
    }

    public int getRows()
    {
        return this.matrix.length;
    }

    public int getColumns()
    {
        return this.matrix[0].length;
    }

    public char get(int x, int y) {
        if (y >= -1 && y < 0)
            return matrix[x][this.matrix[0].length+y];

        if (y >= 0 && y < this.matrix[0].length)
            return this.matrix[x][y];

        if (y >= this.matrix[0].length && y < this.matrix[0].length +1)
            return this.matrix[x][0];

        return '\0';
    }

    public char[][] get() {
        return this.matrix;
    }

    public void set(int x, int y, char c) {
        this.matrix[x][y] = c;
    }

    public void init(Rule r, int x, int y)
    {
        this._init();
        this.set(x, y, '1');

        char[] c = new char[3];
        String s;
        for(int i = 1; i < this.matrix.length; i++)
        {
            for(int j = 0; j < this.matrix[0].length; j++)
            {
                c[0] = this.get(i-1, j-1);
                c[1] = this.get(i-1, j);
                c[2] = this.get(i-1, j+1);
                s = new String(c);

                if(r.getPattern().get(s))
                    this.set(i, j, '1');
            }
        }
    }

    public void init(Rule r)
    {
        this.init(r, 0, this.matrix[0].length/2);
    }

    public void _init()
    {
        for(int i = 0; i < this.matrix.length; i++)
            for(int j = 0; j < this.matrix[0].length; j++)
                this.set(i, j, '0');
    }
}
