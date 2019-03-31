import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(m);
        System.out.println(n);
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}


String userName = myObj.nextLine(); 






