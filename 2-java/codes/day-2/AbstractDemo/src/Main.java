import java.util.Scanner;

import static java.lang.System.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(in);
        out.println("Read data from \n1. database\n2. file");
        out.print("enter choice[1/2]:");
        int choice = scanner.nextInt();

        DataReader reader = switch (choice) {
            case 1 -> {
                yield new OracleDbDataReader();
            }
            case 2 -> {
                yield new TextDataReader();
            }
            default -> {
                yield null;
            }
        };
        printData(reader);

        scanner.close();
    }

    static void printData(DataReader reader) {
        if (reader != null)
            out.println(reader.getData());
        else
            out.println("NA");
    }
}