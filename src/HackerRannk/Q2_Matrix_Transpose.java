import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Array2D {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int arr[][] =  {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        
        int m = 3;
        int n = 4;
        for (int i= 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}