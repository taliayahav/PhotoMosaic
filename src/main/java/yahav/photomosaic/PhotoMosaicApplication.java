package yahav.photomosaic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.nio.IntBuffer;

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
        byte[] buffer = new byte[width * height * 4];
        //PixelFormat<IntBuffer> pixelFormat = PixelFormat.getByteBgraInstance();
        //int[] pixels = new int[Grid.SIZE]


        // Create WritableImage
//        WritableImage wImage = new WritableImage(
//                (int) image.getWidth(),
//                (int) image.getHeight());
//        PixelWriter pixelWriter = wImage.getPixelWriter();
//        imageView.setImage(wImage);
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++){
                Rectangle2D rect = new Rectangle2D(x,y,50, 50);
                System.out.println(rect);
                Color color = pixelReader.getColor(x,y);
                System.out.println("R = "+(color.getRed() * 255));
                System.out.println("G = "+(color.getGreen()* 255));
                System.out.println("B = "+(color.getBlue()*255));
//                color = color.brighter();
//                pixelWriter.setColor(x, y,color);
            }

        // Display image on screen
        imageView.setImage(image);
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

