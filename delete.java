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

len = s.length();
if(len>=4){
      for(int j=0;j<len-3;j++){
          if(s.charAt(j)==s.charAt(j+1)&&s.charAt(j+2)==s.charAt(j+3)){
              StringBuilder sb = new StringBuilder(s);
              sb.deleteCharAt(j+3);
              s=sb.toString();
              }
           }
}


if(len>=3){
    for(int j=0;j<len-2;j++){
        if(s.charAt(j)==s.charAt(j+1)&&s.charAt(j+1)==s.charAt(j+2)){
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(j+2);
            s=sb.toString();
            }
   }
}

for (int i = ratings.length - 1; i >= 0; i--) {
    if (ratings[i] > ratings[(i + 1)%ratings.length]) {
        right2left[i] = right2left[(i + 1)%ratings.length] + 1;
    }
}