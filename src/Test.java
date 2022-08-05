import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (sc.hasNextLine()) {
            n++;
            sc.nextLine();
        }
        n /= 2;
        for (int i = 0; i < n; i++) {
            System.out.printf("YES");
        }
    }
}
