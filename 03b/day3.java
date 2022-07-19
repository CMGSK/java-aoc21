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
       
        String common="";
        for(int j=0; j<12; j++){
            int res0=0;
            for(int i=0; i<data.size(); i++){
                String line=data.get(i);
                if (line.charAt(j)=='0') res0++;
            }
            if (res0>(data.size()/2)) common+="0";
            else common+="1";
        }
        String least="";
        for(int i=0; i<common.length(); i++){
            if(common.charAt(i)=='0') least+="1";
            else least+="0";
        }

        //main program

        // System.out.println(data.size()+" "+data2.size());
        System.out.println("rates"+data.get(0)+" "+data2.get(0));
        // sanity check

        System.out.println("comm/uncom"+common+" "+least);
        System.out.println(Integer.parseInt(data.get(0), 2) * Integer.parseInt(data2.get(0), 2));
        //result



        // main program

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

