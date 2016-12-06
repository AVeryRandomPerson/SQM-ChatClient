package clientSource;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController{
    private static Client chatClient;
	
	
    @FXML
    private VBox loginInterface;
        
    @FXML
    private Label serverStatusLabel;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private TextField usernameTextField;

    
    @FXML
    private void enterChatWindow(ActionEvent ae){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainChatWindow.fxml"));
        String usernameProposed = usernameTextField.getText();
    	String response = chatClient.verifyUser(usernameProposed);
    	System.out.println(response);
    	if(chatClient.isReceivedValid(response)){
    		try {
            	Parent parent = loader.load();
                MainChatWindowController controller = loader.getController();
                controller.setUsernameLabel(usernameProposed);
                Scene chatWindowScene = new Scene(parent);
                Stage chatWindowStage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                chatClient.setUsername(usernameProposed);
                
                chatWindowStage.setScene(chatWindowScene);
                chatWindowStage.show();        	
            } catch (IOException e) {
                System.out.println("There was a problem loading the main chat window. FXML issue.");
                e.printStackTrace();
            }
    	}
    }
    	
    @FXML
    private void updateLoginButton(){
    	if(usernameTextField.getLength() > 10) {
    		String usableText = usernameTextField.getText().substring(0, 9);
    		usernameTextField.clear();
    		usernameTextField.setText(usableText);
    		usernameTextField.positionCaret(9);
    	}
    	if(usernameTextField.getText().contains("?")) loginButton.setDisable(true);
    	else if(loginButton.isDisabled()) loginButton.setDisable(false);
    	
    }
    
    @FXML
    private void textFieldEnterChatWindow(){
    	if(!loginButton.isDisabled()) loginButton.fire();
    }
    
    public static Client getClient(){
    	return chatClient;
    }
    public static void setClient(Client c){
    	chatClient = c;
    }
    	
    }

