package yahav.photomosaic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Image Read Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        ImagePixels imagePixels = new ImagePixels("src/main/resources/sourceimages/colorfulimage.jpeg");
        imagePixels.closestColorDifference();
//        List<Color> list = imagePixels.getSourceImageColors();
//        System.out.println(list);
//        System.out.println(list.size()); //should be just red
//        List<Color> colorList = imagePixels.squarePixelColors;
//        System.out.println(colorList);
//        List files = imagePixels.closestColorDifference();
//        System.out.println(files);
        //look at rocket application for application and fxml for when running, it opens a square
    }
}
