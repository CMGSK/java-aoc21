import java.util.*;
import java.io.*;

public class day5 {
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

        byte[][] map = new byte[1000][1000];
        // Arrays.fill(map, (byte)0);
        for (int i=0; i<1000; i++){
          for (int j=0; j<1000; j++){
            map[i][j]=0;
          }
        }
        // creates the coordinates map and fills it with zeros //


        for (int i=0; i<data.size(); i++){
          String temp = data.get(i).replaceAll(" ", "");
          String [] line = temp.split("->");
          String [] firstcoor = line[0].split(",");
          String [] secondcoor = line[1].split(",");
          int x1 = Integer.valueOf(firstcoor[0]);
          int y1 = Integer.valueOf(firstcoor[1]);
          int x2 = Integer.valueOf(secondcoor[0]);
          int y2 = Integer.valueOf(secondcoor[1]);
          // getting all the X and Y coordinates //
          // where Y=rows and X=columns //

          if (y1==y2){
            for (int j = Math.min(x1, x2); j<=Math.max(x1, x2); j++){
              map[j][y1]++;
            }
          } 
          else if (x1==x2){
            for (int j = Math.min(y1, y2); j<=Math.max(y1, y2); j++){
              map[x1][j]++;
            }
          }
          else{
            int cnt=0;
            if ((x1>x2 && y1>y2) || (x2>x1 && y2>y1)){
              for (int j = Math.min (x1, x2); j<=Math.max(x1, x2); j++){
                map[j][Math.min(y1, y2) + cnt]++;
                cnt++;
              }
            }
            else{
              for (int j = Math.min (x1, x2); j<=Math.max(x1, x2); j++){
                map[j][Math.max(y1, y2) - cnt]++;
                cnt++;
              }
            }
          }
        }
        int count=0;
        for (int i=0; i<1000; i++){
          for (int j=0; j<1000; j++){
            if (map[i][j]>1) count++;
          }
        }
        System.out.println(count);

    } catch (Exception e){
      e.printStackTrace();
    }
}
}