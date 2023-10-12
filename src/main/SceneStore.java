package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneStore {
    private Scene startScene;
    private Scene appScene;

    SceneStore() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Begin.fxml"));
            startScene = new Scene(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/mainApp.fxml"));
            appScene = new Scene(root);
            String css = this.getClass().getResource("/styleFile/mainApp.css").toExternalForm();
            appScene.getStylesheets().add(css);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Scene getStartScene() {
        return startScene;
    }

    public Scene getAppScene() {
        return appScene;
    }

}