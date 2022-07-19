import java.util.*;
import java.io.*;

public class day2 {
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
        
        int dist=0;
        int aim=0;
        int depth=0;
        for (int i=0; i<data.size(); i++){
            String line = data.get(i);
            String inst[] = line.split(" ", 2);
            switch (inst[0]){
                case "forward":
                    dist=dist+Integer.valueOf(inst[1]);
                    depth+=Integer.valueOf(inst[1])*aim;
                    break;
                case "up":
                    aim=aim-Integer.valueOf(inst[1]);
                    break;
                case "down":
                    aim=aim+Integer.valueOf(inst[1]);
                    break;
            }
        }
        // main program

        System.out.println(depth*dist);
        //result

        // for (String x : data){
        //   System.out.println(x);
        // }
        // sanity check, printing the vector //

      } catch(IOException e){
        e.printStackTrace();
      }
    } 
}

