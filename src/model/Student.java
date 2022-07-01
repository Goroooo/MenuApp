package model;

public class Student {

    private String name;
    private String surname;
    private int year;
    private double mark;
    private boolean isPhd;

    public Student(String name, String surname, int year, double mark, boolean isPhd) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mark = mark;
        this.isPhd = isPhd;
    }

    @Override
    public String toString() {
        return name + "," + surname + "," + year + "," + mark + "," + isPhd + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public boolean isPhd() {
        return isPhd;
    }

    public void setPhd(boolean phd) {
        isPhd = phd;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Year: " + year);
        System.out.println("Mark: " + mark);
        System.out.println("Is PHD: " + (isPhd ? "Yes" : "No"));
        System.out.println("-------------");
    }
}
