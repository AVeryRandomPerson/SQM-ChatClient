package clientSource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import clientSource.Client;
import clientSource.LoginController;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginController.fxml"));
        Parent parent = loader.load();
        LoginController controller = loader.getController();
        controller.setClient(new Client());
        Scene scene = new Scene(parent);
        
        stage.setTitle("Login Window");
        stage.setScene(scene);
        stage.show();
    }

     
}
