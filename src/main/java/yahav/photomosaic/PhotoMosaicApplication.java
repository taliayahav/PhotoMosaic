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
import java.util.ArrayList;

public class PhotoMosaicApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileInputStream input = new FileInputStream("src/main/resources/google.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        imageView.setImage(image);

//         Obtain PixelReader
        PixelReader pixelReader = image.getPixelReader();
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        int squares = 50;
        int xInc = width/squares;
        int yInc = height/squares;
        Image[] croppedImages;

        // Create WritableImage
        WritableImage wImage = new WritableImage(
                (int) image.getWidth(),
                (int) image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();

            //        ArrayList<Rectangle2D> rectangles = new ArrayList<Rectangle2D>();
        double redPixels = 0;
        double greenPixels = 0;
        double bluePixels = 0;
        double numPixels = 0;
        for(int x = 0; x < width; x+= xInc){
            for(int y = 0; y < height; y+= yInc){
//                Rectangle2D rect = new Rectangle2D(x,y,xInc, yInc);
//                rectangles.add(rect);
                Color color = pixelReader.getColor(x,y);
                System.out.print("section " + x + ", ");
                System.out.println(y);
                redPixels += (color.getRed());
                greenPixels += (color.getGreen());
                bluePixels += (color.getBlue());
                numPixels++;
                double red = ((redPixels/numPixels));
                double green = ((greenPixels/numPixels));
                double blue = ((bluePixels/numPixels));
            }
        }
            //Should each square go into an arrayList?

//        File[] file = new File("src/main/resources/flower").listFiles();
//        croppedImages = new Image[file.length];
////        for(File img : file)
//        for(int i=0; i< croppedImages.length; i++){
//            Image fileImage = new Image(file[i].toURI().toString()); //converts filename to image
//            ImageView fileImageView = new ImageView(); //set image in file to imageview
//            fileImageView.setImage(fileImage);
//            croppedImages[i] = fileImage; //adds each image to croppedImages list
//            System.out.println(fileImage);
//            int w = (int)croppedImages[i].getWidth();
//            int h = (int)croppedImages[i].getHeight();
//            int incImageX = w/squares;
//            int incImageY = h/squares;
//            for(int x = 0; x < w; x+= incImageX) {
//                for (int y = 0; y < h; y += incImageY) {
//                    Color srcImgClr = pixelReader.getColor(x, y);
//                    double red = ((srcImgClr.getRed()));
//                    double green = ((srcImgClr.getGreen()));
//                    double blue = ((srcImgClr.getBlue()));
//                    System.out.println("R: " + red);
//                    System.out.println("G:" + green);
//                    System.out.println("B: " + blue);
//                }
//            }
//        }
        //How do I trim each photo?
        //Should each photo also go into a list to swap with the other list?

        // Display image on screen
        imageView.setImage(wImage);
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Image Read Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}

