package clientSource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import clientSource.MainChatWindowController;

public class MainChatWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainChatWindow.fxml"));
        Parent parent = loader.load();
        MainChatWindowController controller = loader.getController();

        Scene scene = new Scene(parent);
        
        stage.setTitle("Chat Window");
        stage.setScene(scene);
        stage.show();
    }

     
}
