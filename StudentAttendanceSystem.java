/*
Group Members
GAHDSE231F-013 :- Thilina Shalom
GAHDSE231F-028 :- Yuwani Karunarathne
GAHDSE231F-032 :- Hashitha Bandara
*/

import java.util.LinkedList;
import java.util.Scanner;

public class StudentAttendanceSystem {

    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Student");
            System.out.println("2. New Attendance");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Attendance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(studentList, scanner);
                    break;
                case 2:
                    markAttendance(studentList, scanner);
                    break;
                case 3:
                    deleteStudent(studentList, scanner);
                    break;
                case 4:
                    displayAttendance(studentList);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent(LinkedList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        studentList.add(new Student(id, name, "Absent"));
        System.out.println("Student added successfully.");
    }

    private static void markAttendance(LinkedList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.print("Enter attendance status (Present/Absent): ");
                String status = scanner.next();
                student.setStatus(status);
                System.out.println("Attendance marked successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent(LinkedList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        studentList.removeIf(student -> student.getId() == id);

        System.out.println("Student deleted successfully.");
    }

    private static void displayAttendance(LinkedList<Student> studentList) {
        System.out.println("\nStudent Attendance:");
        for (Student student : studentList) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Status: " + student.getStatus());
        }
    }

    private static class Student {
        private int id;
        private String name;
        private String status;

        public Student(int id, String name, String status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}


