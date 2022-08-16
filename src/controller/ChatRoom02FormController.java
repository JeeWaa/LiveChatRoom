package controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatRoom02FormController {
    public JFXTextArea txtChat;
    public JFXTextField txtMessage;
    Socket socket = null;

    public void initialize() {
        new Thread(()->{
            try {
                socket = new Socket("localhost",8000);
                System.out.println("Client started");

                while (true) {
                    InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String read = bufferedReader.readLine();
                    System.out.println(read);
                    txtChat.appendText(read + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void send(MouseEvent mouseEvent) throws IOException {
        String message = txtMessage.getText();

        txtChat.appendText("Me : " + message + "\n");
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Kamal : " + message + "\n");
        printWriter.flush();
    }
}
