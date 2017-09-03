import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Array2D {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int arr[][] =  {{1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};
        
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = 0;
                for (int k = i; k < i+3; k++) {
                    for (int m = j; m < j+3; m++) {
                        if ((k == i+1 && m == j) || (k == i+1 && m == j+2)) {
                            System.out.printf("%3s","");
                        } else {
                            sum += arr[k][m];
                            System.out.printf("%3d",arr[k][m]);
                        }
                    }
                    System.out.print("\n");
                }
                if (max < sum) max = sum;
                System.out.print("\n");
            }
            System.out.print("\n----------\n");
        }
        
        System.out.printf("Max sum: %d \n" ,max);
    }
}