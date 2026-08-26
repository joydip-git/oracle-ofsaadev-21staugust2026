import com.demo.Messenger;

public class App {
    public static void main(String[] args) throws Exception {
        Messenger messenger = new Messenger();
        String message = messenger.welcome("Joydip");
        System.out.println(message);
    }
}
