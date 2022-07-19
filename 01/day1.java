import java.util.*;
import java.io.*;

public class day1 {
    public static void main (String[] args) {

      try{
        FileInputStream file = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(file);
        Vector<Integer> data = new Vector<Integer>();
        while (scanner.hasNextLine()){
          int temp = Integer.valueOf(scanner.nextLine());
          data.addElement(temp);
        }
        scanner.close();
        // Dumping input into a readable vector //
        
        int res=0;
        for (int i=1; i<data.size(); i++){
          if(data.get(i) > data.get(i-1)) res++;
        }
        //main program

        System.out.println(res);
        // result

        // for (int x : data){
        //   System.out.println(x);
        // }
        // sanity check, printing the vector //

      } catch(IOException e){
        e.printStackTrace();
      }
    } 
}

