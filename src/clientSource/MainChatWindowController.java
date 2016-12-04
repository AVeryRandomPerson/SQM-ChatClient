package clientSource;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainChatWindowController{
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
    private TextArea chatHistoryTextArea;
    
    @FXML
    private TextField messageTextField;

    @FXML
    private Button sendButton;
}
