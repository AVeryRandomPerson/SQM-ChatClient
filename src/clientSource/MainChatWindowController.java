package clientSource;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainChatWindowController{
    private static Client chatClient = LoginController.getClient();
	
	@FXML
    private HBox mainChatPane;
    
    @FXML
    private VBox helperPane;
    
    @FXML
    private ScrollPane chatHistoryPane;    
    
    @FXML
    private ScrollPane inputMessagePane;
    
    @FXML
    private Label usernameHelpLabel;
    
    @FXML
    private Label usernameLabel;
    
    @FXML
    private ListView<String> usersList;
    
    @FXML
    private ListView<TextField> chatHistoryTextArea;
    
    @FXML
    private TextField messageTextField;

    @FXML
    private Button sendButton;
    
    @FXML
    private void sendMessage(ActionEvent ae){
    	String message = messageTextField.getText();
    	String response = chatClient.sendMessageToUser(message, chatClient.getUsername());
    	messageTextField.clear();
    	System.out.println(response);
    }
    
    public void setUsernameLabel(String username){
    	usernameLabel.setText(username);
    }
    
    
    
    
}
