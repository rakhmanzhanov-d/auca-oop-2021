package p03;

import p02.Student;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 0, 2, 4};
        MyArrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        double[] a2 = {5.4, 1.7, 4.3, 3.2, 4};
        MyArrays.sort(a2);
        System.out.println(Arrays.toString(a2));


        BigRational[] a3 = {
                BigRational.parse("7/123345"),
                BigRational.parse("7/1"),
                BigRational.parse("7/123"),
        };
        MyArrays.sort(a3);
        System.out.println(Arrays.toString(a3));


        Student[] students = {
                new Student("StudentA", 3.2, 2003),
                new Student("StudentB", 3.7, 1999),
                new Student("StudentC", 2.4, 2000),
        };

        MyArrays.sort(students, new StudentComparatorByGPA());
        System.out.println(Arrays.toString(students));
        System.out.println("--------------------------------------");

        MyArrays.sort(students, new StudentCompareByName());
        System.out.println(Arrays.toString(students));
        System.out.println("--------------------------------------");

        // method reference
        MyArrays.sort(students, (o1, o2) -> {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return Integer.compare(s1.getBirthYear(), s2.getBirthYear());
        });
        System.out.println(Arrays.toString(students));
        System.out.println("--------------------------------------");
    }
}

class StudentComparatorByGPA implements MyComparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return Double.compare(s1.getGPA(), s2.getGPA());
    }
}

class StudentCompareByName implements MyComparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getName().compareTo(s2.getName());
    }
}

// You can use lambda expression or this class to compare two integer values
class StudentCompareByBirthYear implements MyComparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return Integer.compare(s1.getBirthYear(), s2.getBirthYear());
    }
}
