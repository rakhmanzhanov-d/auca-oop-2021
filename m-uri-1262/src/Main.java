import java.util.Scanner;

//
// Multiple reading
//
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String process;
        int readPerCycle;

        while (inp.hasNext()) {
            process = inp.next();
            readPerCycle = inp.nextInt();
            int allRead = 0;
            int writeNumber = 0;
            int lastReadNumber = 0;

            for (int i = 0; i < process.length(); i++) {
                if (process.charAt(i) == 'W') {
                    writeNumber++;
                } else if (process.charAt(i) == 'R') {
                    lastReadNumber++;
                    if(lastReadNumber == readPerCycle){
                        lastReadNumber = 0;
                        allRead++;
                    }else if(lastReadNumber > 0 && i < process.length() - 1 && process.charAt(i + 1) == 'W'){
                        lastReadNumber = 0;
                        allRead++;
                    }else if(lastReadNumber > 0 && i == process.length() - 1){
                        allRead++;
                    }

                }
            }
            System.out.println(writeNumber + allRead);
        }
    }
}
