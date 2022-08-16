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
    Socket accept = null;

    public void initialize() {
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                txtData.appendText("Server started\n");
                accept = serverSocket.accept();
                txtData.appendText("Client connected\n");
                while (true) {
                    InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String read = bufferedReader.readLine();
                    txtData.appendText(read + "\n");

                    PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
                    printWriter.println("success\n");
                    printWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void close(MouseEvent mouseEvent) throws IOException {

    }
}
