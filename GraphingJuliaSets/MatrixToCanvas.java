
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class MatrixToCanvas {

    public static Canvas matrixToCanvas(int[][] matrix) {
        final int MAX_THREADS=100;
       // ExecutorService pool= Executors.newFixedThreadPool(MAX_THREADS); fixMe: needed for threaded but not in general
        Canvas image= new Canvas(matrix.length,matrix[1].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++){

                /* Fixme: threaded version
                int threadI=i;
                int threadJ=j;
                pool.execute(()-> {
                    if (matrix[threadI][threadJ] < 0) {
                        MyDrawPixel.drawPixel(image, threadJ, threadI, 1, Color.BLACK);
                    } else if (matrix[threadI][threadJ] >= 0) {
                        MyDrawPixel.drawPixel(image, threadJ, threadI, 1, Color.WHITE);

                    }
                } );
                */

                 //original
                if(matrix[i][j]<0) {
                    MyDrawPixel.drawPixel(image, j, i, 1, Color.BLACK);
                }
                else if(matrix[i][j]>=0) {
                    MyDrawPixel.drawPixel(image, j, i, 1, Color.WHITE);
                }


            }
        }
        return image;
    }



}
