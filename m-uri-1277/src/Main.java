import java.util.Scanner;
//
//  Short Attendance
//
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while(inp.hasNextInt()){
            int n = inp.nextInt();
            for(int i = 0; i < n; i++){
                int absent = 0, present = 0, allPresent = 0, lastAbsent = 0;
                int numOfStudents = inp.nextInt();
                String[] characters = new String[numOfStudents];
                String[] presence = new String[numOfStudents];
                double[] percentages = new double[numOfStudents];

                for(int j = 0; j < numOfStudents; j++){
                    characters[j] = inp.next();
                }
                for(int j = 0; j < numOfStudents; j++){
                    presence[j] = inp.next();
                    for(int k = 0; k < presence[j].length(); k++){
                        if(presence[j].charAt(k) == 'P'){
                            present++;
                        }else if(presence[j].charAt(k) == 'A'){
                            absent++;
                        }
                    }
                    double tPercentage = present * 100.0 / (present + absent);
                    percentages[j] = tPercentage;
                    if(tPercentage < 75){
                        lastAbsent = j;
                    }else{
                        allPresent++;
                    }
                    present = 0;
                    absent = 0;
                }

                String space = " ";
                for(int k = 0; k < numOfStudents; k++){
                    if(k == percentages.length - 1 || lastAbsent == k){
                        space = "\n";
                    }
                    if (allPresent == numOfStudents) {
                        System.out.println();
                    }else if (percentages[k] < 75){
                        System.out.print(characters[k] + space);
                    }
                }
            }

        }
    }
}
