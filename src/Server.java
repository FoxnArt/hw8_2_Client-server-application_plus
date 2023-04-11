import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8085;

    public static void main(String[] args) throws IOException {
        System.out.println("Запускаем сервер на порту: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            try (Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                System.out.println("- " + in.readLine());
                out.println("Server: Write your name?");
                System.out.println("Server: Write your name?");
                String username = in.readLine();
                System.out.println("- " + username);
                out.println("Server: Are you child? (yes/no)");
                System.out.println("Server: Are you child? (yes/no)");
                String answer = in.readLine();
                System.out.println("- " + answer);
                if (answer.equals("Yes")) {
                    out.printf("Server: Welcome to the kids area, %s! Let's play!", username);
                    System.out.printf("Server: Welcome to the kids area, %s! Let's play!", username);
                } else if (answer.equals("No")) {
                    out.printf("Server: Welcome to the adult zone, %s! Have a good rest, or a good working day!", username);
                    System.out.printf("Server: Welcome to the adult zone, %s! Have a good rest, or a good working day!", username);
                } else {
                    out.printf("Server: %s, answer is not correct", username);
                    System.out.printf("Server: %s, answer is not correct", username);
                }
            }
        }
    }
}
