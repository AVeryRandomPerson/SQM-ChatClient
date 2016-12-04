package clientSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Client {
    private Socket clientSocket;
    private BufferedReader inRead;
    private PrintWriter outWrite;
    private String username;
    private int userPopulation = 0;

    public Client() throws IOException {
        try {
            clientSocket = new Socket("localhost", 9000);
            System.out.println("Connected to server");
        }
        catch (IOException e) {
            System.err.println("error initialising server");
        }
        inRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outWrite = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    /* No Need Validation. For now.
    public String loginValidate(String username, String password){
        String command = "IDEN " + username + " " + password;
        sendOverConnection(command);
        String response = "";
        try {
            response = inRead.readLine();
        } catch (IOException e) {
            System.out.println("ERROR receiving response from server");
            e.printStackTrace();
        }
        return response;
    }*/

    public void sendMessageToUser(String message, String username){
        String command = "MESG " + username + " " + message;
        sendOverConnection(command);
    }

    public String getServerMessage(){
        try {
            return inRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberOfUser(){
        return userPopulation;
    }

    public String getPMuser(String message){
        return message.split(":")[0].substring(8);
    }

    public boolean isChatMessage(String message){
        return message.substring(0,2).equals("PM");
    }
    public String getChatMessage(String message){
        return message.split(":")[1];
    }

    public boolean isUserListMessage(String message){
        return message.split(", ")[0].length() != message.length();
    }
    public ObservableList<String> getUserList(String message){
        userPopulation = (message.substring(3).split(", ").length);
        return FXCollections.observableArrayList(message.substring(3).split(", "));
    }

    public void requestUserList(){
        String command = "LIST";
        sendOverConnection(command);
    }

    public boolean ready() throws IOException {
        return inRead.ready();
    }

    public void messageForConnection(String command){
        sendOverConnection(command);
    }
    private synchronized void sendOverConnection(String command){
        outWrite.println(command);
    }

    public boolean validResponse(String response){
        return response.substring(0,2).equals("OK");
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
