import java.util.*;
import java.io.*;

public class day3 {
    public static void main (String[] args) {

      try{
        FileInputStream file = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(file);
        Vector<String> data = new Vector<String>();
        while (scanner.hasNextLine()){
          data.addElement(scanner.nextLine());
        }
        scanner.close();
        // Dumping input into a readable vector //
       
        String gamma="";
        for(int j=0; j<12; j++){
            int res0=0;
            for(int i=0; i<data.size(); i++){
                String line=data.get(i);
                if (line.charAt(j)=='0') res0++;
            }
            if (res0>(data.size()/2)) gamma+="0";
            else gamma+="1";
        }
        String epsilon="";
        for(int i=0; i<gamma.length(); i++){
            if(gamma.charAt(i)=='0') epsilon+="1";
            else epsilon+="0";
        }
        // main program

        System.out.println(Integer.parseInt(gamma, 2)*Integer.parseInt(epsilon, 2));
        //result
        //parseInt doc: https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#parseInt%28java.lang.String,%20int%29

        // for (String x : data){
        //   System.out.println(x);
        // }
        // sanity check, printing the vector //

      } catch(IOException e){
        e.printStackTrace();
      }
    } 
}

