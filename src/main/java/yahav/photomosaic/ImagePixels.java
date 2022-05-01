package yahav.photomosaic;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ImagePixels {

    public List<Color> squarePixelColors;
    public List<Color> allImageColors;
    final int SQUARES = 10;
    public int width;
    public int height;
    private Image image;

    public ImagePixels(File fileName) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(fileName);
        image = new Image(input);
        width = (int) image.getWidth();
        height = (int) image.getHeight();
        squarePixelColors = getQuadrantColors(); //list of every box's average color of the input image
        allImageColors = getSourceImageColors(); //list of average color of every source image
    }

    private List<Color> getQuadrantColors() throws FileNotFoundException {
        List<Color> squareColors = new ArrayList<>();
        final int quadrantSize = SQUARES * SQUARES;
        double redPixels = 0;
        double greenPixels = 0;
        double bluePixels = 0;
        Color quadrantColorTotal;
        PixelReader pixelReader = image.getPixelReader();
        // divide the x and y pixels into 50 x 50 quadrants and go through each quadrant individually
        for (int squareX = 0; squareX+SQUARES < width; squareX += SQUARES) {
            for (int squareY = 0; squareY+SQUARES < height; squareY += SQUARES) {
                // Store the RGB individually of each pixel in the quadrant to
                // get the average of the 50x50 of this quadrant
                for (int x = squareX; x < squareX + SQUARES; x++) {
                    for (int y = squareY; y < squareY + SQUARES; y++) {
                        //loop through all pixels in this quadrant
                        Color color = pixelReader.getColor(x, y);
                        redPixels += color.getRed();
                        greenPixels += color.getGreen();
                        bluePixels += color.getBlue();
                    }
                }
                // average the colors in the quadrant list
                // add that average color to your squareColors list
                quadrantColorTotal = Color.color(redPixels / quadrantSize, greenPixels / quadrantSize,
                        bluePixels / quadrantSize);
                squareColors.add(quadrantColorTotal);

                // reset pixel color counter to 0
                redPixels = 0;
                greenPixels = 0;
                bluePixels = 0;
            }
        }
        return squareColors;
    }

    private List<Color> getSourceImageColors() {
        List<Color> sourceImageColors = new ArrayList<>();
        File[] file = new File("src/main/resources/flower").listFiles();
        //Image[] fileImgs;
        //fileImgs = new Image[file.length];
        Image fileImage;
        for (int i = 0; i < file.length; i++) {
            String stringURI = file[i].toURI().toString();
            fileImage = new Image(stringURI); //converts filename to image
            PixelReader pixelReader = fileImage.getPixelReader();
            //fileImgs[i] = fileImage; //adds each image to fileImgs list
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
            colorTotal = Color.color(redPixels / numPixels, greenPixels / numPixels, bluePixels / numPixels);
            sourceImageColors.add(colorTotal);
        }

        return sourceImageColors;
    }

    private double colorDistance(Color firstColor, Color secondColor) {
        double difference = Math.sqrt(Math.pow(secondColor.getRed() - firstColor.getRed(), 2) +
                Math.pow(secondColor.getGreen() - firstColor.getGreen(), 2) +
                Math.pow(secondColor.getBlue() - firstColor.getBlue(), 2));
        return difference;
    }

    private List<File> closestColorDifference() throws IOException {
        List<File> closestFiles = new ArrayList<>();
        double min = Double.MAX_VALUE;
        File[] file = new File("src/main/resources/flower").listFiles();
        File closestFile = file[0];
        for (int i = 0; i < squarePixelColors.size(); i++) { //every color in the input image list
            Color compare = squarePixelColors.get(i); //get the color of each box
            for (int j = 0; j < allImageColors.size(); j++) { //every color of the source image list
                double distance = colorDistance(compare, allImageColors.get(j)); //finds distance using formula between each box
                if (distance < min) { //if distance between the two images is smaller than minimum
                    min = distance; //min becomes the distance
                    closestFile = file[j]; //returns the closest matching image from source images
                    // to the current input image box as a file
                }
            }
            closestFiles.add(closestFile);
            min = Double.MAX_VALUE;
        }
        return closestFiles;
    }

    public String createImage() throws IOException {
        List<File> imageList = closestColorDifference();
        BufferedImage result = new BufferedImage(
                width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = result.getGraphics();
        int index = 0;
        for(int x= 0; x + SQUARES < width; x += SQUARES){
            for(int y= 0; y + SQUARES < height; y += SQUARES){
                BufferedImage bi = ImageIO.read(imageList.get(index));
                //g.drawImage(bi, x, y, null);
                g.drawImage(bi, x,y,width/SQUARES, height/SQUARES, null);
                index++;
            }
        }
        String pathName = "result.png";
        ImageIO.write(result,"png",new File(pathName));
        return pathName;
    }
}
