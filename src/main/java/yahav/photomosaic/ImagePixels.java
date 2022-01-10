package yahav.photomosaic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;

import java.io.FileInputStream;
import java.io.IOException;

public class ImagePixels{
    Image image;
    int width = (int)image.getWidth();
    int height = (int)image.getHeight();
    public ImagePixels() throws IOException {
        FileInputStream input = new FileInputStream("src/main/resources/google.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView();
        PixelReader pixelReader = image.getPixelReader();
    }


    public int[] getImagePixels(Image image, int width, int height) {
        PixelReader pixelReader = image.getPixelReader();
        int[] pixels = new int[width*height];
        for(int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixelReader.getPixels(row,col,width,height, PixelFormat.getIntArgbInstance(),pixels,0,width);
            }
        }
        return pixels;
    }
}
