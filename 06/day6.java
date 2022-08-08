import java.util.*;
import java.io.*;

public class day6 {

    public static long growth(ArrayList<Byte> data, Vector<long[]> child){
      long cnt=0;
      for (int i=0; i<data.size(); i++){
        byte tmp = data.get(i);
        tmp--;
        if (data.get(i)>0) data.set(i, tmp);
        else{
          data.set(i, (byte)6);
          cnt++;
        }
      }
      for (int i=0; i<child.size(); i++){
        if(child.get(i)[0] == 0){
          cnt += child.get(i)[1];
          child.get(i)[0] = 6;
        }
        else child.get(i)[0]--;
      }
      return cnt;
    }
    //external funct to calculate fish growth

    public static void main (String[] args) {

      try{
        FileInputStream file = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(file);
        int[] temp = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();  
        ArrayList<Byte> data = new ArrayList<Byte>();
        for (int i=0; i<temp.length; i++){
          data.add((byte)temp[i]);
        }
        scanner.close();
        // Dumping input into an array //

        Vector <long[]> child = new Vector<long[]>();

        for (int i=0; i<256; i++){
          long g = growth(data, child);
          long[] born = {8, g};
          child.add(born);
        }
        long heritage = 0;
        for(long[] i : child){
          heritage+=i[1];
        }
        long res = data.size() + heritage;
        //main funct
        System.out.println(res);
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

