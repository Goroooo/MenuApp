package service;

import model.Student;

import java.util.Objects;
import java.util.Scanner;

public class StudentService {

    public static final String URL = "Students.txt";

    public static void menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isActiveMenu = true;

        while (isActiveMenu) {
            System.out.println("-------- Menu --------");
            System.out.println("1. Create Student");
            System.out.println("2. Print All Students");
            System.out.println("3. Print All PHD Students");
            System.out.println("4. Print Eldest Students");
            System.out.println("5. Print All Excellent Students");
            System.out.println("6. Exit");

            int inputNumber = scanner.nextInt();
            switch (inputNumber) {
                case 1:
                    create();
                    break;
                case 2:
                    printAllStudents();
                    break;
                case 3:
                    printAllPHDStudents();
                    break;
                case 4:
                    printEldestStudents();
                    break;
                case 5:
                    printExcellentStudents();
                    break;
                case 6:
                    isActiveMenu = false;
                    break;
                default:
                    System.out.println("Enter a number 1 - 6 You have entered: " + inputNumber);
            }
        }
    }

    public static void create() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = s.next();
        System.out.println("Enter surname: ");
        String surname = s.next();
        System.out.println("Enter year: ");
        int year = s.nextInt();
        System.out.println("Enter mark: ");
        double mark = s.nextDouble();
        System.out.println("Enter is PHD: Yes/No");
        boolean isPhd = s.next().charAt(0) == 'y';
        Student student = new Student(name, surname, year, mark, isPhd);
        ReadAndWrite.write(URL, student.toString());
    }

    public static void printAllStudents() throws Exception {
        String[] infoStudents = ReadAndWrite.read(URL);
        Student[] students = new Student[infoStudents.length];
        for (int i = 0; i < infoStudents.length; i++) {
            String[] fields = infoStudents[i].split(",");
            Student student = new Student(
                    fields[0],
                    fields[1],
                    Integer.parseInt(fields[2]),
                    Double.parseDouble(fields[3]),
                    Boolean.parseBoolean(fields[4]));
            students[i] = student;
        }
        for (Student s : students) {
            s.printInfo();
        }
    }

    public static void printAllPHDStudents() throws Exception {
        String[] infoStudents = ReadAndWrite.read(URL);
        Student[] students = new Student[infoStudents.length];
        for (int i = 0; i < infoStudents.length; i++) {
            String[] fields = infoStudents[i].split(",");
            Student student = new Student(
                    fields[0],
                    fields[1],
                    Integer.parseInt(fields[2]),
                    Double.parseDouble(fields[3]),
                    Boolean.parseBoolean(fields[4]));
            students[i] = student;
        }
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].isPhd()) {
                count++;
            }
            if (count != 0) {
                students[i].printInfo();
            }
        }
        if (count == 0) {
            System.out.println("No PHD Students");
        }
    }

    public static void printEldestStudents() throws Exception {
        String[] infoStudents = ReadAndWrite.read(URL);
        Student[] students = new Student[infoStudents.length];
        for (int i = 0; i < infoStudents.length; i++) {
            String[] fields = infoStudents[i].split(",");
            Student student = new Student(
                    fields[0],
                    fields[1],
                    Integer.parseInt(fields[2]),
                    Double.parseDouble(fields[3]),
                    Boolean.parseBoolean(fields[4]));
            students[i] = student;
        }
        Student max = students[0];
        for (int i = 0; i < students.length; i++) {
            if (students[i].getYear() < max.getYear()) {
                max = students[i];
            }
        }
        max.printInfo();
    }

    public static void printExcellentStudents() throws Exception {
        String[] infoStudents = ReadAndWrite.read(URL);
        Student[] students = new Student[infoStudents.length];
        for (int i = 0; i < infoStudents.length; i++) {
            String[] fields = infoStudents[i].split(",");
            Student student = new Student(
                    fields[0],
                    fields[1],
                    Integer.parseInt(fields[2]),
                    Double.parseDouble(fields[3]),
                    Boolean.parseBoolean(fields[4]));
            students[i] = student;
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i].getMark() == 100) {
                students[i].printInfo();
            }
        }
    }

//    public static void printAllPHDStudents() throws Exception {
//        String[] infoStudents = ReadAndWrite.read(URL);
//        Student[] students = new Student[infoStudents.length];
//        for (int i = 0; i < infoStudents.length; i++) {
//            String[] fields = infoStudents[i].split(",");
//            Student student = new Student(
//                    fields[0],
//                    fields[1],
//                    Integer.parseInt(fields[2]),
//                    Double.parseDouble(fields[3]),
//                    Boolean.parseBoolean(fields[4]));
//            students[i] = student;
//        }
//        int count = 0;
//        Student[] phdStudents = new Student[students.length];
//        for (int i = 0; i < students.length; i++) {
//            if (students[i].isPhd()) {
//                phdStudents[i] = students[i];
//                count++;
//            }
//        }
//        if (count != 0) {
//            for (int i = 0; i < phdStudents.length; i++) {
//                phdStudents[i].printInfo();
//            }
//        } else {
//            System.out.println("No PHD Students");
//        }
//    }
}
