package yahav.photomosaic;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;

//public class PhotoMosaicController {

//    public PhotoMosaicController() throws IOException {
//        ImageFile imageFile = new ImageFile();
//        //         Obtain PixelReader
//        PixelReader pixelReader = image.getPixelReader();
//        int width = (int)image.getWidth();
//        int height = (int)image.getHeight();
//        int squares = 50;
//        int xInc = width/squares;
//        int yInc = height/squares;
//        Image[] croppedImages;
//
//        // Create WritableImage
//        WritableImage wImage = new WritableImage(
//                (int) image.getWidth(),
//                (int) image.getHeight());
//        PixelWriter pixelWriter = wImage.getPixelWriter();
//    }

//        public double getPixelRGBAvg(Image image){
//            PixelReader pixelReader = image.getPixelReader();
//            int width = (int)image.getWidth();
//            int height = (int)image.getHeight();
//            int squares = 50;
//            int xInc = width/squares;
//            int yInc = height/squares;
//            // Create WritableImage
//            WritableImage wImage = new WritableImage(
//                    (int) image.getWidth(),
//                    (int) image.getHeight());
//            PixelWriter pixelWriter = wImage.getPixelWriter();
//        double redPixels = 0;
//        double greenPixels = 0;
//        double bluePixels = 0;
//        double numPixels = 0;
//        for(int x = 0; x < width; x+= xInc){
//            for(int y = 0; y < height; y+= yInc){
//                Color color = pixelReader.getColor(x,y);
//                System.out.print("section " + x + ", ");
//                System.out.println(y);
//                redPixels += (color.getRed());
//                greenPixels += (color.getGreen());
//                bluePixels += (color.getBlue());
//                numPixels++;
//                double red = (redPixels);
//                double green = (greenPixels);
//                double blue = (bluePixels);
//                color = Color.color(red/numPixels, green/numPixels, blue/numPixels);
//                pixelWriter.setColor(x,y,color);
//            }
//        }
//        return (redPixels/numPixels, greenPixels/numPixels, bluePixels/numPixels);
//    }
//
//    public double getSrcImgAvg{
//        File[] file = new File("src/main/resources/flower").listFiles();
//        croppedImages = new Image[file.length];
////        for(File img : file)
//        for(int i=0; i< croppedImages.length; i++){
//        Image fileImage = new Image(file[i].toURI().toString()); //converts filename to image
//        ImageView fileImageView = new ImageView(); //set image in file to imageview
//        fileImageView.setImage(fileImage);
//        croppedImages[i] = fileImage; //adds each image to croppedImages list
//        System.out.println(fileImage);
//        int w = (int)croppedImages[i].getWidth();
//        int h = (int)croppedImages[i].getHeight();
//        int incImageX = w/squares;
//        int incImageY = h/squares;
//        for(int x = 0; x < w; x+= incImageX) {
//        for (int y = 0; y < h; y += incImageY) {
//        Color srcImgClr = pixelReader.getColor(x, y);
//        double red = ((srcImgClr.getRed()));
//        double green = ((srcImgClr.getGreen()));
//        double blue = ((srcImgClr.getBlue()));
//        System.out.println("R: " + red);
//        System.out.println("G:" + green);
//        System.out.println("B: " + blue);
//        }
//        }
//        }
//
//        }
//}
//    }
