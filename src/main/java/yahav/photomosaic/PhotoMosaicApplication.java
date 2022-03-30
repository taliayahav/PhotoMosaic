package yahav.photomosaic;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class PhotoMosaicApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImagePixels imagePixels = new ImagePixels("/Users/taliayahav/PhotoMosaic/src/main/resources/sourceimages/redPicture.JPG");
        List<Image> files = imagePixels.closestColorDifference();
        StackPane root = new StackPane();
        int index = 0;
        for(int x= 0; x + imagePixels.SQUARES < imagePixels.width; x += imagePixels.SQUARES){
            for(int y= 0; y + imagePixels.SQUARES < imagePixels.height; y += imagePixels.SQUARES){
                Image individualImage = files.get(index);
                //FileInputStream matchingImages = new FileInputStream(file.getAbsoluteFile());
                //Image individualImage = new Image(matchingImages);
                ImageView individualImageView = new ImageView();
                individualImageView.setImage(individualImage);
                individualImageView.setFitHeight(50);
                individualImageView.setFitWidth(50);
                individualImageView.setX(x);
                individualImageView.setY(y);
                root.getChildren().add(individualImageView);
            }
            x = 0;
        }
        FileInputStream input = new FileInputStream("src/main/resources/google.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setImage(image);



        // Display image on screen
        imageView.setImage(image);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Image Read Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}

