package p02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("StudentA", 3.2, 2003),
                new Student("StudentB", 3.7, 1999),
                new Student("StudentC", 2.4, 2000),
        };

        Arrays.sort(students, new StudentComparatorByGPA());
        System.out.println(Arrays.toString(students));
        System.out.println("--------------------------------------");

        Arrays.sort(students, new StudentCompareByName());
        System.out.println(Arrays.toString(students));
        System.out.println("--------------------------------------");

        // method reference
        Arrays.sort(students, Comparator.comparingInt(Student::getBirthYear));
        System.out.println(Arrays.toString(students));
        System.out.println("--------------------------------------");
    }
}

class StudentComparatorByGPA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getGPA(), o2.getGPA());
    }
}

class StudentCompareByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

// You can use lambda expression or this class to compare two integer values
class StudentCompareByBirthYear implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
    }
}

