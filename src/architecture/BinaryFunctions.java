package architecture;

import java.util.ArrayList;

public class BinaryFunctions {
   
    public static int[]toArray(String c, int s, int f) {
        int code[] = new int[f - s + 1];
        for (int i = s; i <= f; i++) {
            code[i - s] = Character.getNumericValue(c.charAt(i));

        }
        return code;
    }
    
     public static void printNumber(int[] x) {
        //Prints array of numbers, like the full number
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }
    public static int binaryToDecU(int[] x){
        int num = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) {
                num += Math.pow(2, x.length - i - 1);
            }
        }
        return num;
    }
    public static int binaryToDec(int[] x) {
        //Changes binary to decimal
        boolean isNegative = false;
        int y[] = new int[x.length];
        for (int i = 0; i < y.length; i++){
            y[i] = x[i];
        }
        if (y[0] == 1){
            isNegative = true;
            for (int i = y.length - 1; i >= 0; i--){
                if (y[i] == 1){
                    for (int j = i - 1; j >= 0; j--){
                        if (y[j] == 1) y[j] = 0;
                        else if (y[j] == 0) y[j] = 1;
                    }
                    break;
                }
            }
        }
        
        int num = 0;
        for (int i = 0; i < y.length; i++) {
            if (y[i] == 1) {
                num += Math.pow(2, y.length - i - 1);
            }
        }
        if (isNegative == true) return -num;
        return num;
    }

    public static int[] decToBinary(int x, int n) {
        //Changes decimal to binary
        boolean isNegative = false;
        if (x < 0){ 
            isNegative = true;
            x = -x;
            
        }
        int array[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (x / Math.pow(2, i) >= 1) {
                array[n - 1 - i] = (int) (x / (Math.pow(2, i)));
                x -= Math.pow(2, i);

            }
        }
        if (isNegative == true){
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == 1){
                    for (int j = i - 1; j >= 0; j--){
                        if (array[j] == 1) array[j] = 0;
                        else if (array[j] == 0) array[j] = 1;
                    }
                    break;
            }
        }
        
    }
        return array;
    }
    
    
    
            
    public static int[] db(int x){

        int array[] = new int[32];
        for (int i = 0; i <= 31; i++) {
            if(x==0){
                array[31-i]=0;
                continue;
            }
            
            if (x%2>0)
                array[31-i]=1;
            else array[31-i]=0;
            x/=2;
            }

        return array;
    }
        


    public static int[] incrementBinary(int[] x, int n){
//        //Adds a number (int) to a binary number, then returns a different array 
//        //incremented with that amount
        int array[] = new int[x.length];
        int temp = BinaryFunctions.binaryToDec(x);
        temp += n;
        array = BinaryFunctions.decToBinary(temp, array.length);
        return array;
    }
    public static int[] getBits(int[] x, int start, int finish){
        int array[] = new int[finish - start + 1];
        for (int i = start; i <= finish; i++){
            array[i - start] = x[i];
        }
        return array;
    }

    
}

