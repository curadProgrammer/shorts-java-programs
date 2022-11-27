import com.sun.source.tree.ParameterizedTypeTree;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======PASSWORD VALIDATOR=====");
        System.out.print("Enter Password: ");
        String passwordInput = scanner.nextLine();

        // must contain one number
        // must contain one lowercase character
        // must contain one special symbol
        // must contain one uppercase character

        while(!isValid(passwordInput)){
            System.out.println("Error: Invalid Password");
            System.out.print("Enter Password: ");
            passwordInput = scanner.nextLine();
        }

        System.out.println("Valid Password: " + passwordInput);
    }

    public static boolean isValid(String password){
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&-+=()<>~`])(?=\\S+$).{8,20}$");
        Matcher m = p.matcher(password);
        if(m.find()) return true;
        return false;
    }
}
