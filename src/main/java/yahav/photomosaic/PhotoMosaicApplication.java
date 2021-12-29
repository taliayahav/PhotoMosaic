package yahav.photomosaic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhotoMosaicApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource( "/photo_mosaic.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent, 500, 500);

        stage.setTitle("photo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

