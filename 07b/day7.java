import java.util.*;
import java.io.*;

public class day7 {
public static void main (String[] args) {

    try{
    FileInputStream file = new FileInputStream("input.txt");
    Scanner scanner = new Scanner(file);
    String [] temp = scanner.nextLine().split(",");
    scanner.close();
    int[] data = new int[temp.length];
    for (int i=0; i<temp.length; i++) data[i] = Integer.valueOf(temp[i]);
    // Dumping input into a readable array //

    Arrays.sort(data);
    int max = data[data.length-1];
    int min = data[0];
    int minfuel=0;
    for(int i=min; i<max; i++){
        int fuel=0;
        for (int x : data){
            fuel += ((Math.abs(x-i)*((Math.abs(x-i)+1)))/2); // 1+2+3+n... formula = n*(n+1) / 2
        }
        if (fuel < minfuel || minfuel==0) minfuel=fuel;
    }

    System.out.println(minfuel);

    // for (int x : data) System.out.println(x);
    //sanity check

    } catch (Exception e){
        e.printStackTrace();
    }
}
}