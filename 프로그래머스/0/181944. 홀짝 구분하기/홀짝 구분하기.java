import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder result = new StringBuilder();
        result.append(n);
        if(n % 2 == 0){
            result.append(" is even");
        }else{
            result.append(" is odd");
        }
        
        System.out.println(result.toString());
    }
}