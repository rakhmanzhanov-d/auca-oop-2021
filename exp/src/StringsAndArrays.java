import java.util.Scanner;

// read line
// change lowercase letters to uppercase
// change uppercase letters to lowercase

public class StringsAndArrays {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

//        // s is a reference
//        String s = inp.nextLine();
//        char[] values = s.toCharArray();
//
//        for(int i = 0; i < values.length; i++){
//            if(Character.isUpperCase(values[i])){
//                values[i] = Character.toLowerCase(values[i]);
//            }else if(Character.isLowerCase(values[i])){
//                values[i] = Character.toUpperCase(values[i]);
//            }
//        }
//        System.out.println(values);
        int ch1 = '0';
        int ch2 = '1';

        System.out.println("The ASCII value of a is: "+ch1);
        System.out.println("The ASCII value of b is: "+(ch2 + 2));
    }
}
