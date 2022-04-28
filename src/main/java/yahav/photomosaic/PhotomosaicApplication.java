package yahav.photomosaic;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class PhotomosaicApplication extends Application {
    @FXML
    ImageView photomosaicImage;

    @FXML
    TextField filepathField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/PhotomosaicUI.fxml"));

        Scene scene = new Scene(root, 800, 800);

        primaryStage.setTitle("Photomosaic Creator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createPhotomosaic() throws IOException {
        String fileName = filepathField.getText();
        ImagePixels imagePixels = new ImagePixels(fileName);
        String resultName = imagePixels.createImage();
        FileInputStream inputStream = new FileInputStream(resultName);
        Image image = new Image(inputStream);
        photomosaicImage.setImage(image);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
