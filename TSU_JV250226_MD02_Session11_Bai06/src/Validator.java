
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Validator {
    public static String getString(Scanner scanner , String suggest) {
        do {
            System.out.println(suggest);
            String input = scanner.nextLine();
            if(Objects.equals(input, "")){
                System.out.println("Can not enter empty string");
            }else {
                return input;
            }
        }while(true) ;
    }

    public static LocalDateTime getDateTime(Scanner scanner , String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        do {
            System.out.println(suggest);
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input,formatter);
            }catch (Exception e) {
                System.out.println("Enter not valid date");
            }
        }while (true);
    }
    public static LocalDateTime getDate(Scanner scanner , String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        do {
            System.out.println(suggest);
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input+ " 00:00",formatter);
            }catch (Exception e) {
                System.out.println("Enter not valid date");
            }
        }while (true);
    }
}