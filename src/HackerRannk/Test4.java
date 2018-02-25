import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test4 {

    public static void main(String[] args) {
        
        long i,fact=1;  
        long number=25;//It is the number to calculate factorial    
        for(i=1;i<=number;i++){    
            fact=fact*i;    
        }

        long i2,fact2=1;  
        long number2=3;//It is the number to calculate factorial    
        for(i2=1;i2<=number2;i2++){    
            fact2=fact2*i;    
        }    
        long dd = fact % 1000000007;
        System.out.println("Factorial of "+number+" is: "+fact);    
        System.out.println("Factorial of "+number2+" is: "+fact2);   
        System.out.println((dd * fact2)%1000000007); 
    }  
}