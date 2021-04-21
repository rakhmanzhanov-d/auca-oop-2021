import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, m, i, j, num;
        while ((n = inp.nextInt()) != 0 && (m = inp.nextInt()) != 0) {
            int cnt = 0;
            int res = 4;

            int[] people = new int[n];
            int[] problem = new int[m];

            for (i = 0; i < n; i++) {
                people[i] = 0;
            }
            for (j = 0; j < m; j++) {
                problem[j] = 0;
            }

            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    num = inp.nextInt();
                    people[i] += num;
                    problem[j] += num;
                }
            }

            for (i = 0; i < n; i++) {
                if (people[i] == m) {
                    cnt++;
                    break;
                }
            }

            for (i = 0; i < n; i++) {
                if (people[i] == 0) {
                    cnt++;
                    break;
                }
            }

            for (i = 0; i < m; i++) {
                if (problem[i] == 0) {
                    cnt++;
                    break;
                }
            }

            for (i = 0; i < m; i++) {
                if (problem[i] == n) {
                    cnt++;
                    break;
                }
            }


            System.out.println(res - cnt);
        }
    }
}
