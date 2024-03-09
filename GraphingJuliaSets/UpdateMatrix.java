//TODO: REFACTOR

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UpdateMatrix {
    public static int [][] generateMatrix(Complex cParameter, double a, double b, double c, double d, int frameLength, int frameHeight, int maxIter){
         final int MAX_THREADS=(Runtime.getRuntime().availableProcessors())*5;
        ExecutorService pool= Executors.newFixedThreadPool(MAX_THREADS);
        int [][] dataFrame= new int[frameHeight][frameLength];
        for (int i = 0; i < frameHeight; ++i){
            for (int j = 0; j < frameLength; ++j){
                Complex mathCoord = Complex.arrayToComplexCoord(i,j,a,b,c,d, frameLength, frameHeight);

                int iThread=i;
                int jThread=j;
                pool.execute(()->{
                dataFrame[iThread][jThread]=IterCheck.iterCheck(mathCoord,cParameter,maxIter);
                }
                );
            }
        }
        pool.shutdown();
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException interrupt){
            System.out.println(interrupt+ " Time Out after 5 seconds");
        }
        return dataFrame;
    }
}
