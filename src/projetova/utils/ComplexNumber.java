package projetova.utils;

public class ComplexNumber {
    public double realPart;
    public double imaginaryPart;
    public static final double NINETY_IN_RADIUS = Math.toRadians(90);

    public ComplexNumber(double r, double i) {
        this.setRealPart(r);
        this.setImaginaryPart(i);
    }
    
    public ComplexNumber plus(ComplexNumber cn) {
        return new ComplexNumber (
                       this.getRealPart() + cn.getRealPart(),
                       this.getImaginaryPart() + cn.getImaginaryPart()
                   );
    }
    
    public ComplexNumber times(double n) {
        return new ComplexNumber(n*this.getRealPart(), n*this.getImaginaryPart());
    }
    
    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    
    public static ComplexNumber rotate(Couple<ComplexNumber> c) {
        return ComplexNumber.rotate(c.y.minus(c.x));
    }
    
    public static ComplexNumber rotate(ComplexNumber c) {
        int xx = (int) (c.getRealPart() * Math.cos(NINETY_IN_RADIUS)
                 + c.getImaginaryPart() * Math.sin(NINETY_IN_RADIUS));
        int yy = (int) (- c.getRealPart() * Math.sin(NINETY_IN_RADIUS)
                 - c.getImaginaryPart() * Math.cos(NINETY_IN_RADIUS));
        
        return new ComplexNumber(xx, yy);
    }
    
    public ComplexNumber put(ComplexNumber cn) {
        return this.plus(cn);
    }
    
    public ComplexNumber minus(ComplexNumber cn) {
        return this.plus(new ComplexNumber(-cn.getRealPart(), -cn.getImaginaryPart()));
    }
    
    @Override
    public String toString() {
        return  "" + this.realPart + 
                ((this.imaginaryPart < 0)? this.imaginaryPart:
                                           "+" + this.imaginaryPart) + "i";
    }
}
