//algorithm comes from Dr. Petra Bonfert-Taylor's "Analysis of a Complex Kind", lecture 4: How to Find Julia Sets on coursera

public class IterCheck{

    //Default, change if necessary
    public static int maxIter= 10000;

    //Note: making recursive causes StackOverflowError
    public static int iterCheck(Complex xy, Complex c, int maxIter){
        Complex xyNew;
        if (xy.norm() >c.radius()){
            return 0;
        }

        for (int i=0; i<maxIter; ++i){

            xyNew=(xy.squared()).add(c);
            if (xyNew.norm() > c.radius()){
                return i;
            }
            xy=xyNew;


        }
        return -1;
    }
}
/*
ITERCHECK Lambda
(xy,c, maxIter)->{
    Complex xyNew;
    if (xy.norm() >c.radius()){
        return 0;
    }
   for (int i=0; i<maxIter; ++i){
       xyNew=(xy.squared()).add(c);
       if (xyNew.norm() > c.radius()){
            return i;
        }
        xy=xyNew;
        }
        return -1;
    }

}


 */