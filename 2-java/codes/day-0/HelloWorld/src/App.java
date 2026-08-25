import java.io.PrintStream;

import oracle.api.Messenger;

public class App {
    public static void main(String[] args) throws Exception {
        PrintStream outputStream = System.out;

        Messenger messenger = new Messenger();
        String message = messenger.getMessage("Joydip");
        outputStream.println(message);
        outputStream.close();
    }
}
