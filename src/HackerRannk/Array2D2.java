import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Array2D2 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int arr[][] =  {{1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};
        
        int maxHourglass = getHourglass(arr,1,1);
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int hourses = getHourglass(arr,i,j);
                if (maxHourglass < hourses)
                    maxHourglass = hourses;
            }
        }
        
        System.out.printf("Max sum: %d \n" ,maxHourglass);
    }
    public static int getHourglass(int[][] arr, int i, int j) {
        return arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
    }
}