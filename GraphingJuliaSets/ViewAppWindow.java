import javafx.application.Application;
import javafx.scene.Scene;
import javax.swing.JFrame;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;





public class ViewAppWindow extends Application{
    private Canvas pixelCanvas;
    private VBox menuBox;

    public static void main (String[] args){
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception{

        int frameHeight = 740;
        int frameLength = 740;
        BorderPane root= new BorderPane();

        menuBox = new VBox();

        TextField aField = new TextField("-3.0");
        TextField bField = new TextField("3.0");
        TextField cField = new TextField("-3.0");
        TextField dField = new TextField("3.0");
        TextField cReField = new TextField("-0.6");
        TextField cImField = new TextField("0.4");

        Complex cVal=new Complex(Double.parseDouble(cReField.getText()),Double.parseDouble(cImField.getText()));
        int [][] startMatrix = UpdateMatrix.generateMatrix(
                cVal,
                Double.parseDouble(aField.getText()),
                Double.parseDouble(bField.getText()),
                Double.parseDouble(cField.getText()),
                Double.parseDouble(dField.getText()),
                frameLength, frameHeight, IterCheck.maxIter);


        pixelCanvas = MatrixToCanvas.matrixToCanvas(startMatrix);
        root.setTop(pixelCanvas);

        Label xRangeLabel= new Label("Enter x range: min ");
        Label xRangeLabel2= new Label(" max ");
        Label yRangeLabel= new Label("Enter y range: min ");
        Label yRangeLabel2= new Label(" max ");
        Label cValLabel= new Label("Enter c as complex number: ");
        Label cValLabel2= new Label(" + i*");

        Button generateButton = new Button("Generate!");
        generateButton.setOnAction(
                e-> {
                    try {
                        Complex cValNew=new Complex(Double.parseDouble(cReField.getText()),Double.parseDouble(cImField.getText()));
                        Canvas pixelCanvas2 = new Canvas(frameLength,frameHeight);
                        pixelCanvas2 = MatrixToCanvas.matrixToCanvas(
                                UpdateMatrix.generateMatrix(
                                        cValNew,
                                        Double.parseDouble(aField.getText()),
                                        Double.parseDouble(bField.getText()),
                                        Double.parseDouble(cField.getText()),
                                        Double.parseDouble(dField.getText()),
                                        frameLength, frameHeight, IterCheck.maxIter
                                )
                        );
                        root.setTop(pixelCanvas2);
                    }
                    catch(Exception exception){}
                }
        );





        HBox xRangeBox= new HBox( xRangeLabel, aField, xRangeLabel2, bField);
        HBox yRangeBox = new HBox( yRangeLabel, cField, yRangeLabel2, dField);
        HBox cValBox = new HBox(cValLabel, cReField, cValLabel2, cImField);


        menuBox.getChildren().add(new Label("Please enter your number. Note that some values will have empty Julia Sets, and some values may be lost in rounding"));
        menuBox.getChildren().add(xRangeBox);
        menuBox.getChildren().add(yRangeBox);
        menuBox.getChildren().add(cValBox);
        menuBox.getChildren().add(generateButton);
        root.setBottom(menuBox);
        Scene scene = new Scene(root, frameLength,frameHeight*1.25);

        stage.setScene(scene);

        stage.setTitle("Graphing Julia Sets");
        stage.show();

    }

}
