package Ex03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String sender;
    private String content;
    private LocalDateTime times;

    public Message(String sender, String content, LocalDateTime times) {
        this.content = content;
        this.sender = sender;
        this.times = times;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }

    public void display() {
        System.out.println("Lịch sử chat:");
        System.out.println(times.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                + sender + " : " + content);
    }
}
