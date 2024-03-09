//part of refactoring

import java.awt.geom.Point2D;
import java.lang.Math;
public class Complex extends Point2D.Double{
    Complex(double x, double y){
        super(x,y);
    }
    Complex(){
        super();
    }
    public double norm(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
    public Complex add(Complex c){
        return new Complex(this.x+c.x, this.y+c.y);
    }
    public Complex squared(){
        return new Complex (this.x*this.x-this.y*this.y, 2*this.x*this.y);
    }
    //calculates escape radius for iterCheck;
    public double radius() {
        return (1 + Math.sqrt(1 + (4*this.norm()) ))/2;
    }

    //use as alternate constructor/converter
    public static Complex arrayToComplexCoord(int i, int j, double a, double b,
                                              double c, double d, int frameLength, int frameHeight){
        Complex point = new Complex();
        point.x=(a+( ( (double) j / (double) frameLength )*(b-a)));
        point.y= c+(((double) (frameHeight - i)/ (double) frameHeight) *(d-c)) ;
        return point;
    }

}