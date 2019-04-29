package projetova.fractal.dragoncurve.display;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.filechooser.FileSystemView;
import org.javatuples.Pair;
import projetova.fractal.dragoncurve.model.DragonCurve;
import projetova.utils.ComplexNumber;
import projetova.utils.GifSequenceWriter;
import projetova.utils.StdDraw;

public class DragonGrid {

    public DragonCurve dragonCurve;
    public double squareSideLength = 4f;
    public int width = 1366;
    public int height = 768;
    public boolean color = false;
    public boolean writeOnGif = true;

    private final String desktop = FileSystemView.getFileSystemView()
            .getHomeDirectory()
            .getAbsolutePath();
    private static ImageOutputStream output;
    private static GifSequenceWriter writer;

    public DragonGrid(DragonCurve dc, boolean color, boolean writeOnGif) throws IOException {
        this.dragonCurve = dc;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.002);
        StdDraw.setXscale(-width / 2, width / 2);
        StdDraw.setYscale(-height / 2, height / 2);
        this.color = color;
        this.writeOnGif = writeOnGif;

        if (writeOnGif) {
            try {
                output = new FileImageOutputStream(
                        new File(desktop + "//" + "DragonCurve.gif")
                );
            } catch (IOException ex) {
                System.out.println(ex);
                throw ex;
            }
        } else {
            output = null;
        }
    }

    public DragonCurve getDragonCurve() {
        return dragonCurve;
    }

    public void setDragonCurve(DragonCurve dragonCurve) {
        this.dragonCurve = dragonCurve;
    }

    public double getSquareSideLength() {
        return squareSideLength;
    }

    public void setSquareSideLength(int squareSideLength) {
        this.squareSideLength = squareSideLength;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw() throws IOException {
        if (!this.color) {
            this.drawWithoutColors();
        } else {
            this.drawWithColors();
        }
    }

    public void drawWithColors() throws IOException {
        LinkedList<Pair<ComplexNumber, Integer>> list
                = this.getDragonCurve().getResumedColorizedList();

        ComplexNumber last = list.get(0).getValue0().times(this.getSquareSideLength());
        int i = -1;
        for (Pair<ComplexNumber, Integer> element : list) {
            ComplexNumber complexElement = element.getValue0();
            StdDraw.setPenColor(this.setColor(element.getValue1()));
            ComplexNumber scaledElement = complexElement.times(this.getSquareSideLength());
            StdDraw.line(last.getRealPart() + 100, last.getImaginaryPart() + 150,
                    scaledElement.getRealPart() + 100, scaledElement.getImaginaryPart() + 150);

            if (writeOnGif && i != element.getValue1()) {
                i = element.getValue1();
                try {
                    writeOnGif(3);
                } catch (IOException ex) {
                    throw ex;
                }
            }

            last = scaledElement;
        }

        if (writeOnGif && writer != null && output != null) {
            try {
                writeOnGif(5);
            } catch (IOException ex) {
                throw ex;
            }
            writer.close();
            output.close();
        }

    }

    public void setColor(int i) {
        this.setColor(new Integer(i));
    }

    private Color setColor(Integer i) {
        String s[] = {
            "#000000", // preto
            "#E50400", // vermelho
            "#2321F0", // azul
            "#94FF4D" // verde
        };

        return new Color(
                Integer.valueOf(s[i % s.length].substring(1, 3), 16),
                Integer.valueOf(s[i % s.length].substring(3, 5), 16),
                Integer.valueOf(s[i % s.length].substring(5, 7), 16)
        );
    }

    public void drawWithoutColors() {
        LinkedList<ComplexNumber> list
                = this.getDragonCurve().getResumedList();

        ComplexNumber last = list.get(0).times(this.getSquareSideLength());
        for (ComplexNumber element : list) {
            ComplexNumber scaledElement = element.times(this.getSquareSideLength());
            StdDraw.line(last.getRealPart(), last.getImaginaryPart(),
                    scaledElement.getRealPart(), scaledElement.getImaginaryPart());
            last = scaledElement;
        }
    }

    public static void writeOnGif(int n) throws IOException {
        for(int i = 0; i < n; i++) {
            writeOnGif();
        }
    }
    
    public static void writeOnGif() throws IOException {
        BufferedImage bi = getScreenShot();

        if (writer == null) {
            writer = new GifSequenceWriter(output,
                    bi.getType(), 1, true);
        }

        writer.writeToSequence(bi);
    }

    public static BufferedImage getScreenShot() {
        BufferedImage image = new BufferedImage(StdDraw.getFrame().getWidth(),
                StdDraw.getFrame().getHeight(),
                BufferedImage.TYPE_INT_RGB);
        StdDraw.getFrame().paint(image.getGraphics());
        return image;
    }
}
