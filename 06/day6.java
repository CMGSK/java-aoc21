import java.util.*;
import java.io.*;


public class day6 {

    public static int growth(ArrayList<Integer> data){
      int cnt=0;
      for (int i=0; i<data.size(); i++){
        if(data.get(i)>0) data.set(i, data.get(i)-1);
        else {
          data.set(i, 6);
          cnt++;
        }
      }
      return cnt;
    }
    //external funct to calculate fish growth

    //main program
    public static void main (String[] args) {

      try{
        FileInputStream file = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(file);
        int[] temp = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();  
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i=0; i<temp.length; i++){
          data.add(temp[i]);
        }
        scanner.close();
        // Dumping input into an array //


        for (int i=0; i<800; i++){
          int g = growth(data);
          for (int j=0; j<g; j++){
            data.add(8);
          }
        }
        //main funct

        System.out.println(data.size());
        //result

        // for (int x : data){
        // System.out.println(x);
        // }
        //sanity check printing array

    } catch (Exception e){
      e.printStackTrace();
    }
}
}

