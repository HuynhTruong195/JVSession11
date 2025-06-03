package Ex03;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Message> messager = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Nhập tên người gửi (hoặc 'exit' để thoát):");
        String senderName = scan.nextLine();
        System.out.println("Nhập nội dung tin nhắn: ");
        String content = scan.nextLine();
        //lưu tin nhắn vào list
        messager.add(new Message(senderName, content, LocalDateTime.now()));

        System.out.println("Nhập 'history' để xem lịch sử, ''filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày");
        String chose = scan.nextLine();
        switch (chose) {
            case "history":
                messager.forEach(display -> display.display());
                break;
            case "filter":
                System.out.println("Nhập tên người cần lọc tin nhắn");
                String filterName = scan.nextLine();
                //tạo 1 list mới chứa danh sách cần lọc
                List<Message> filter = messager.stream().filter(sender -> sender.getSender()
                        .equalsIgnoreCase(filterName)).toList();
                System.out.printf("Tin nhắn từ %s",filterName);
                filter.forEach(getDisplay -> getDisplay.display());
                break;
            case "date":
                System.out.println("Nhập ngày muốn lọc (dd/MM/yyyy):");
                String date = scan.nextLine();
                LocalDateTime searchDate = LocalDateTime.parse(date, formatter);
                //tjao list chứa danh sách lọc được
                List<Message> filterDate = messager.stream()
                        .filter(getDate -> getDate.getTimes().toLocalDate()
                                .equals(searchDate)).toList();
                filterDate.forEach(getDisplay -> getDisplay.display());
                System.out.printf("Tin Nhắn Trong Ngày %s",searchDate);
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Vui lòng nhập 1 trong 3 (history / filter / date)");
        }
    }
}
