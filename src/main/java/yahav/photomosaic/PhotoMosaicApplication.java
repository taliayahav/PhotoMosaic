package yahav.photomosaic;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class PhotoMosaicApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileInputStream input = new FileInputStream("/Users/taliayahav/PhotoMosaic/src/main/resources/google.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView();
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
//        imageView.setImage(wImage);

//        ArrayList<Rectangle2D> rectangles = new ArrayList<Rectangle2D>();
        for(int x = 0; x < width; x+= xInc)
            for(int y = 0; y < height; y+= yInc){
                Rectangle2D rect = new Rectangle2D(x,y,xInc, yInc);
//                rectangles.add(rect);
                Color color = pixelReader.getColor(x,y);
                System.out.print("section " + x + ", ");
                System.out.println(y);
                double red = ((color.getRed()*255));
                double green = ((color.getGreen()*255));
                double blue = ((color.getBlue()*255));
//                System.out.println(avgColor);
//                for (Rectangle2D rectangle :rectangles) {
//                    System.out.println(color.getBlue()*255);
//                }
                color = Color.color(red, green, blue);
                pixelWriter.setColor(x,y,color);
            }
        //Should each square go into an arrayList?

        File[] file = new File("/Users/taliayahav/PhotoMosaic/src/main/resources/flower").listFiles();
        croppedImages = new Image[file.length];
        for(File img : file){
            Image fileImage = new Image(img.toURI().toString());
            ImageView fileImageView = new ImageView();
            fileImageView.setImage(fileImage);
            for(int x = 0; x < width; x+= xInc)
                for(int y = 0; y < height; y+= yInc){
                    Color srcImgClr = pixelReader.getColor(x,y);
                    double red = ((srcImgClr.getRed()*255));
                    double green = ((srcImgClr.getGreen()*255));
                    double blue = ((srcImgClr.getBlue()*255));
                    System.out.println("R: " + red);
                    System.out.println("G:" + green);
                    System.out.println("B: " + blue);
                }
//            for(int i= 0; i < croppedImages.length; i++){
//                //Image fileName = img[i];
//                //croppedImages[i] = fileName;
//            }
        }
        //How do I trim each photo?
        //Should each photo also go into a list to swap with the other list?

        // Display image on screen
        imageView.setImage(wImage);
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Image Read Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}

