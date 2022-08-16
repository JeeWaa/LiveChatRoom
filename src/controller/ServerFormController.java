package controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFormController {
    public JFXTextArea txtData;
    Socket socket = null;

    public void initialize() {
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(2000);
                System.out.println("Server started");
                socket = serverSocket.accept();
                System.out.println("Client connected");

                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String read = bufferedReader.readLine();
                System.out.println(read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void close(MouseEvent mouseEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtData.getText());
        printWriter.flush();
    }
}
