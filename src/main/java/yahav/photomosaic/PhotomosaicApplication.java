package yahav.photomosaic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PhotomosaicApplication extends Application {
    @FXML
    ImageView photomosaicImage;

    @FXML
    TextField filepathField;

    @FXML
    Button openButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/PhotomosaicUI.fxml"));

        Scene scene = new Scene(root, 800, 800);

        primaryStage.setTitle("Photomosaic Creator");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void openButton(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        ImagePixels imagePixels = new ImagePixels(selectedFile); //imports imagePixels to create the mosaic
        String resultName = imagePixels.createImage(); //based on given filepath, imagePixels creates new photomosaic img
        FileInputStream inputStream = new FileInputStream(resultName);
        Image image = new Image(inputStream);
        photomosaicImage.setImage(image);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
