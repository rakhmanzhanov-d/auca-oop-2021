import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()) {
            String word = inp.nextLine();
            String finalWord = "";
            String startBold = "<b>";
            String endBold = "</b>";
            String startItalic = "<i>";
            String endItalic = "</i>";
            int cntBold = 0;
            int cntItalic = 0;

            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == '*' && cntBold == 0){
                    cntBold++;
                    finalWord = word.substring(0, i) + startBold + word.substring(i+1);
                    word = finalWord;
                }else if(word.charAt(i) == '*' && cntBold == 1){
                    cntBold--;
                    finalWord = word.substring(0, i) + endBold + word.substring(i+1);
                    word = finalWord;
                }else if(word.charAt(i) == '_' && cntItalic == 0){
                    cntItalic++;
                    finalWord = word.substring(0, i) + startItalic + word.substring(i+1);
                    word = finalWord;
                }else if(word.charAt(i) == '_' && cntItalic == 1){
                    cntItalic--;
                    finalWord = word.substring(0, i) + endItalic + word.substring(i+1);
                    word = finalWord;
                }
            }
            System.out.println(word);
        }
    }
}

