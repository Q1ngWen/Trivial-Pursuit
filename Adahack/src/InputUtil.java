import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    private InputUtil(){}

    public static int readIntFromUser() {
        do{
            if(sc.hasNextInt()){
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            }

            System.out.print("Please enter an integer: ");

            sc.nextLine();
        }
        while(true);
    }

    public static char readCharFromUser()
    {
        // At least once and until valid input is received:
        do
        {
            // Wait for a new line of text to be entered.
            if(sc.hasNextLine())
            {
                // Obtain the user input.
                String input = sc.nextLine();

                // If a single char was entered, return it.
                if(input.length() == 1)
                    return input.charAt(0);
            }

            // Invalid input length, print an error and repeat.
            System.out.print("Please enter a single character: ");
        }
        while(true);
    }

    public static String readStringFromUser()
    {
        return sc.nextLine();
    }
}
