import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


//not refactoring to Complex.
public class MyDrawPixel{
    public static void drawPixel(Canvas c, int x, int y, int size, Color color){
        GraphicsContext cGC = c.getGraphicsContext2D();
        cGC.setStroke(color);
        cGC.setLineWidth(size);
        cGC.strokeRect(x,y,(double) size, (double) size);
        cGC.fillRect(x,y,(double) size, (double) size);
    }
}
