// Written by ibrahimeth
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.util.Scanner;

public class mail_Sender {
    static String serverAddress = "smtp.gmail.com";
    static int serverPort = 465 ; //SSL Socket Port No
    public static void sendCommand(SSLSocket socket, String Command){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(Command + "\r\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readSocket(SSLSocket socket){
        try {
            String response  = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((response!= null)) {
                response = reader.readLine();
                System.out.println(response);
                try {
                    if (Integer.parseInt(response.split(" ")[0]) > 0 ){
                        break;

                    }
                }catch (Exception e){
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        try {
            Scanner scanner = new Scanner(System.in);
            String answer;
            SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) socketFactory.createSocket(serverAddress, serverPort);
            /// we settings input and output.

            sendCommand(socket, "EHLO localhost");
            readSocket(socket);

            sendCommand(socket, "AUTH LOGIN");
            readSocket(socket);

            sendCommand(socket, "<YOUR-ENCODED-EMAIL-WITH-Base64>");
            readSocket(socket);

            sendCommand(socket, "<YOUR-ENCODED-PASSWORD-WITH-Base64>");
            readSocket(socket);

            sendCommand(socket, "MAIL FROM: <YOUR EMAIL>");
            readSocket(socket);

            System.out.print("Enter your destination mail :");
            sendCommand(socket, "rcpt to: <" + scanner.nextLine() + ">");
            readSocket(socket);

            sendCommand(socket, "DATA");
            readSocket(socket);

            System.out.print("Enter your mail Subject :");
            answer = scanner.nextLine();
            sendCommand(socket, "Subject: " + answer);

            System.out.print("Enter your mail body :");
            answer = scanner.nextLine();
            sendCommand(socket, answer);

            sendCommand(socket, ".");
            readSocket(socket);

            sendCommand(socket, "QUIT");
            readSocket(socket);
            readSocket(socket);


            System.out.println("Your message is gone");
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}