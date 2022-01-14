package yahav.photomosaic;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagePixels{

    ArrayList<Rectangle2D> squareInput = new ArrayList<>(); //array of input squares to compare to source images
    public ImagePixels() throws IOException {
        FileInputStream input = new FileInputStream("src/main/resources/google.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView();
    }


    public List<Color> getImagePixels(Image image) {
        List<Color> pixelColors = new ArrayList<>();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        int squares = 50;
        int xInc = width / squares;
        int yInc = height / squares;
        double redPixels = 0;
        double greenPixels = 0;
        double bluePixels = 0;
        double numPixels = 0;
        PixelReader pixelReader = image.getPixelReader();
        for (int squareX = 0; squareX < height; squareX += xInc) {
            for (int squareY = 0; squareY < width; squareY += yInc) {
                for (int x = 0; x < squareX; x++) {
                    for (int y = 0; y < squareY; y++) {
                        Color color = pixelReader.getColor(x, y);
                        redPixels += color.getRed();
                        greenPixels += color.getGreen();
                        bluePixels += color.getBlue();
                        numPixels++;
                        Color.color(redPixels / numPixels, greenPixels / numPixels, bluePixels / numPixels);
                        pixelColors.add(color);
                    }
                }
            }
        }
        return pixelColors;
    }

    public Color[] getSrcImgsPixels() {
        File[] file = new File("src/main/resources/flower").listFiles();
        Image[] fileImgs;
        fileImgs = new Image[file.length];
        Color[] allImgClrs;
        allImgClrs = new Color[fileImgs.length];
        for (int i = 0; i < fileImgs.length; i++) {
            Image fileImage = new Image(file[i].toURI().toString()); //converts filename to image
            ImageView fileImageView = new ImageView(); //set image in file to imageview
            fileImageView.setImage(fileImage);
            PixelReader pixelReader = fileImage.getPixelReader();
            fileImgs[i] = fileImage; //adds each image to fileImgs list
            double redPixels = 0;
            double greenPixels = 0;
            double bluePixels = 0;
            double numPixels = 0;
            for (int j = 0; j < fileImgs.length; j++) {
                for (int x = 0; x < fileImage.getHeight(); x++) {
                    for (int y = 0; y < fileImage.getWidth(); y++) {
                        Color color = pixelReader.getColor(x, y);
                        redPixels += color.getRed();
                        greenPixels += color.getGreen();
                        bluePixels += color.getBlue();
                        numPixels++;
                    }
                }
            }
        }
        return allImgClrs;
    }
}
