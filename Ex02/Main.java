package Ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 8.5),
                new Student("Bob", 23, 6.0),
                new Student("Colm", 21, 7.5),
                new Student("Nvai", 22, 9.0),
                new Student("Eve", 24, 5.5),
                new Student("Boat", 25, 8.0),
                new Student("Grace", 22, 7.0),
                new Student("Heidi", 23, 8.8),
                new Student("Joly", 23, 6.5),
                new Student("Tim", 22, 7.2)
        );

       List<Student> filter = students.stream()
               .filter(grade -> grade.getGrade() >7)
               .sorted(Comparator.comparing(Student::getName)) //sắp tên
               .collect(Collectors.toList()); //gộp vào 1 list student

        //in ra
        System.out.println("Danh sách sinh viên có điểm lớn hơn 7.0 sắp theo tên:");
        filter.forEach(studentList -> studentList.display());
    }
}