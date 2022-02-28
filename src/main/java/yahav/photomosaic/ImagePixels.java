package yahav.photomosaic;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ImagePixels{

    public List<Color> squarePixelColors;
    public List<Color> allImgClrs;

    ArrayList<Rectangle2D> squareInput = new ArrayList<>(); //array of input squares to compare to source images
    public ImagePixels() throws FileNotFoundException {
        squarePixelColors = getAvgClrs();
        //allImgClrs = getSrcImgAvgColors();
    }

    public List<Color> getAvgClrs() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src/main/resources/google.png");
        Image image = new Image(input);
        List<Color> squareColors = new ArrayList<>();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        int squares = 50;
        int xInc = width / squares;
        int yInc = height / squares;
        Color pixelColorsTotal;
        double redPixels = 0;
        double greenPixels = 0;
        double bluePixels = 0;
        double numPixels = 0;
        PixelReader pixelReader = image.getPixelReader();
        for (int squareX = 0; squareX < width; squareX += xInc) {
            for (int squareY = 0; squareY < height; squareY += yInc) { //should loop through all pixels in each quadrant
                for (int x = 0; x < squareX-50; x++) {
                    //this is always starting at 0,0
                    // but need to start at next quadrant
                    for (int y = 0; y < squareY-50; y++) {
                        Color color = pixelReader.getColor(x, y);
                        redPixels += color.getRed();
                        greenPixels += color.getGreen();
                        bluePixels += color.getBlue();
                        numPixels++;
                    }
                }
                pixelColorsTotal=Color.color(redPixels / numPixels, greenPixels / numPixels, bluePixels / numPixels);
                squareColors.add(pixelColorsTotal);
            }
        }
        return squareColors;
    }

    public List<Color> getSrcImgAvgColors() {
        List<Color> srcImgClrs = new ArrayList<>();
        File[] file = new File("src/main/resources/flower").listFiles();
        //File[] file = new File("src/main/resources/sourceimages").listFiles(); //find better way to access files
        Image[] fileImgs;
        fileImgs = new Image[file.length];
        for (int i = 0; i < fileImgs.length; i++) {
            String stringURI = file[i].toURI().toString();
            Image fileImage = new Image(stringURI); //converts filename to image
            PixelReader pixelReader = fileImage.getPixelReader();
            fileImgs[i] = fileImage; //adds each image to fileImgs list
            Color colorTotal;
            double redPixels = 0;
            double greenPixels = 0;
            double bluePixels = 0;
            double numPixels = 0;
            int height = (int) fileImage.getHeight();
            int width = (int) fileImage.getWidth();
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        Color color = pixelReader.getColor(x, y);
                        redPixels += color.getRed();
                        greenPixels += color.getGreen();
                        bluePixels += color.getBlue();
                        numPixels++;
                    }
                }
            colorTotal= Color.color(redPixels / numPixels, greenPixels / numPixels, bluePixels / numPixels);
            srcImgClrs.add(colorTotal);
        }
        return srcImgClrs;
    }
    public double colorDistance(Color firstColor, Color secondColor){
        double difference = Math.sqrt(Math.pow(secondColor.getRed()-firstColor.getRed(), 2) +
                Math.pow(secondColor.getGreen()-firstColor.getGreen(),2) +
       Math.pow(secondColor.getBlue()-firstColor.getBlue(),2));
        return difference;
    }
    public void closestColorDiff(){
        double min = 1.0;
        for(int i =0; i < squarePixelColors.size(); i++){ //every color in the input image list
            Color compare = squarePixelColors.get(i); //get the color of each box
            for (int j = 0; j < allImgClrs.size(); j++){ //every color of the source image list
                double distance = colorDistance(compare, allImgClrs.get(j)); //finds distance using formula between each box
                if(distance < min){ //if distance between the two images is smaller than minimum
                    min = distance; //min becomes the distance
                    //squarePixelColors.get(i) = allImgClrs.get(j);
                }
            }
        }
    }
}
