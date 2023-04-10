import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static final String HOST = "netology.homework";
    public static final int PORT = 8085;

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Hello!"); System.out.println("- Hello!");
            System.out.println(in.readLine());
            out.println("Andrey"); System.out.println("- Andrey");
            System.out.println(in.readLine());
            out.println("No"); System.out.println("- No");
            System.out.println(in.readLine());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
