package yahav.photomosaic;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
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
//
//public class PhotoMosaicApplication extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        ImagePixels imagePixels = new ImagePixels("src/main/resources/sourceimages/red-car.jpeg");
//        List<Image> files = imagePixels.closestColorDifference();
//        //StackPane root = new StackPane();
//        List<ImageView> individualImageViews = new ArrayList<>();
//        int index = 0;
//        System.out.println("width: " + imagePixels.width);
//        System.out.println("height: " + imagePixels.height);
//        Group root = new Group();
//        Scene scene = new Scene(root);
//        HBox box = new HBox();
//        for(int x= 0; x + imagePixels.SQUARES < imagePixels.width; x += imagePixels.SQUARES){
//            for(int y= 0; y + imagePixels.SQUARES < imagePixels.height; y += imagePixels.SQUARES){
//                System.out.println("x = " + x + "y = " + y);
//                System.out.println(files.get(index).toString());
//                Image individualImage = files.get(index);
//                individualImageViews.add(new ImageView());
//                //individualImageView = new ImageView();
//                individualImageViews.get(index).setImage(individualImage);
//                individualImageViews.get(index).setFitHeight(50);
//                individualImageViews.get(index).setFitWidth(50);
////                individualImageViews.get(index).setX(x);
////                individualImageViews.get(index).setY(y);
//                //box.getChildren().add(individualImageViews.get(index));
//;                //root.getChildren().add(individualImageView);
//            }
//        }
//        for (ImageView individualImageview : individualImageViews)
//        {
//            System.out.println("In for loop");
//            box.getChildren().add(individualImageview);
//        }
//        System.out.println("Out of for loop");
//        root.getChildren().add(box);
//        primaryStage.setTitle("ImageView");
//        primaryStage.setWidth(600);
//        primaryStage.setHeight(600);
//        primaryStage.setScene(scene);
////        primaryStage.sizeToScene();
//        System.out.println("Before show");
//        primaryStage.show();
//        System.out.println("After show");
//        //FileInputStream input = new FileInputStream("src/main/resources/google.png");
//        //Image image = new Image(input);
//        //ImageView imageView = new ImageView();
////        individualImageView.setFitHeight(300);
////        individualImageView.setFitWidth(300);
//        //individualImageView.setImage(image);
//
//
//
//        // Display image on screen
//        //individualImageView.setImage(image);
////        Scene scene = new Scene(root, 300, 300);
////        primaryStage.setTitle("Image Read Test");
////        primaryStage.setScene(scene);
////        primaryStage.show();
//    }



//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

