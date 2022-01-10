package yahav.photomosaic;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

public class PhotoMosaicApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileInputStream input = new FileInputStream("src/main/resources/google.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setImage(image);
        PixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbInstance();



        //PixelReader pixelReader = image.getPixelReader();
        int squares = 50;
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        int xInc = height/squares;
        int yInc =
        width/squares;
        // Create WritableImage
        WritableImage wImage = new WritableImage(
                (int) image.getWidth(),
                (int) image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();
        PixelReader pixelReader = image.getPixelReader();
        int[][] boxes = new int[width][height];
        int [] pixels = new int[width*height*3];
        double redPixels = 0;
        double greenPixels = 0;
        double bluePixels = 0;
        double numPixels = 0;
//        for(int x = 0; x <)
//        pixelReader.getPixels(squareX,squareY,xInc,yInc, (WritablePixelFormat<IntBuffer>) pixelFormat,pixels,0,width);
        
//        for(int squareX = 0; squareX < height; squareX+= xInc) {
//            for (int squareY = 0; squareY < width; squareY += yInc) {
//                pixelReader.getPixels(squareX,squareY,xInc,yInc, (WritablePixelFormat<IntBuffer>) pixelFormat,pixels,0,width*3);
//            }
//        }
//            for(int x = 0; x < width; x++) {
//                for(int y = 0; y <width; y++){
//                    Color color = pixelReader.getColor(x, y);
//                    redPixels += color.getRed();
//                    greenPixels += color.getGreen();
//                    bluePixels += color.getBlue();
//                    numPixels++;
//                    double red = (redPixels);
//                    double green = (greenPixels);
//                    double blue = (bluePixels);
//                    color = Color.color(red / numPixels, green / numPixels, blue / numPixels);
//                    pixelWriter.setColor(x, y, color);
//                }
//            }


            //my code separates the image to squares but doesn't add what's in each individual
            //need to add each pixel within each square

            //x,y = boxes of an image
            //return? so can be used for pixelwriter

//        Image[] croppedImages;
//        File[] file = new File("src/main/resources/flower").listFiles();
//        croppedImages = new Image[file.length];
//        for(File img : file)
//        for(int i=0; i< croppedImages.length; i++) {
//            Image fileImage = new Image(file[i].toURI().toString()); //converts filename to image
//            ImageView fileImageView = new ImageView(); //set image in file to imageview
//            fileImageView.setImage(fileImage);
//            croppedImages[i] = fileImage; //adds each image to croppedImages list
//            System.out.println(fileImage);
//            int w = (int) croppedImages[i].getWidth();
//            int h = (int) croppedImages[i].getHeight();
//            int incImageX = w / squares;
//            int incImageY = h / squares;
//            for (int x = 0; x < w; x += incImageX) {
//                for (int y = 0; y < h; y += incImageY) {
//                    Color color = pixelReader.getColor(x, y);
//                    System.out.print("section " + x + ", ");
//                    System.out.println(y);
//                    redPixels += (color.getRed());
//                    greenPixels += (color.getGreen());
//                    bluePixels += (color.getBlue());
//                    numPixels++;
//                    double red = (redPixels);
//                    double green = (greenPixels);
//                    double blue = (bluePixels);
//                    color = Color.color(red / numPixels, green / numPixels, blue / numPixels);
//                }
//            }
//        }
            //how to crop these images?

        // Display image on screen
        imageView.setImage(wImage);
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Image Read Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}

