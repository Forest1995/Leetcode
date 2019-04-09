import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int nextinteger = sc.nextInt();
                map.put(nextinteger, j);
            }

            int cur = n;
            for (int x = 0; x < n; x++) {
                if (map.containsKey(cur)&&map.get(cur) <= x) {
                    while (map.containsKey(cur)&&map.get(cur) <= x) {
                        System.out.print(cur);
                        cur--;
                        if(map.containsKey(cur)&&map.get(cur) <= x)
                            System.out.print(" ");
                    }
                    System.out.print("\n") ;
                }
                else{
                    System.out.println(" ");
                }
            }
        }
    }
}