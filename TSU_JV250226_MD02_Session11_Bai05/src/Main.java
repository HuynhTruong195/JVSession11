
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Event> events = new ArrayList<>();

    public void addEvent(String name, LocalDateTime startDate, LocalDateTime endDate) {
        Event event = new Event(name, startDate, endDate);
        events.add(event);
    }

    public void displayEvents() {
        System.out.println("Danh sách sự kiện:");
        for (Event event : events) {
            System.out.println(event);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main eventManager = new Main();

        while (true) {

            String name = Validator.getString(scanner,"Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            LocalDateTime startDate = Validator.getDateTime(scanner,"Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");
            LocalDateTime endDate = Validator.getDateTime(scanner,"Nhập thời gian kết thúc (dd-MM-yyyy HH:mm): ");

            eventManager.addEvent(name, startDate, endDate);
        }
        eventManager.displayEvents();
        scanner.close();
    }
}