import java.util.*;
import java.io.*;

public class day4 {

  public static boolean rowParse (int i, int j, int r, int c, int[] calls, Vector<int[][]> data){
    for (int x=0; x<5; x++){
      if (data.get(j)[r][x]==-1){
        continue;
      }
      else return false;
    }
    return true;
  }

  public static boolean colParse (int i, int j, int r, int c, int[] calls, Vector<int[][]> data){
  
    for (int x=0; x<5; x++){
      if ((data.get(j)[x][c])==-1){
        continue;
      }
      else return false;
    }
    return true;
  }

  public static int Bingo (int[] calls, Vector<int[][]> data){
    for (int i=0; i<calls.length; i++){
      for(int j=0; j<data.size(); j++){
        for(int r=0; r<5; r++){
          for(int c=0; c<5; c++){
            if (data.get(j)[r][c]==calls[i]){ 
              data.get(j)[r][c]=-1;
              int res=0;
              if(rowParse(i, j, r, c, calls, data) || colParse(i, j, r, c, calls, data)){
                for(int a=0; a<5; a++){
                  for(int b=0; b<5; b++){
                    if(data.get(j)[a][b]>=0){
                      res+=data.get(j)[a][b];
                    }
                    else continue;
                  }
                }
                return res*calls[i];
              }
            }
          }
        }
      }
    }
    return 0;
  }
  public static void main (String[] args) {

    try{
      FileInputStream file = new FileInputStream("input.txt");
      Scanner scanner = new Scanner(file);
      String temp = scanner.nextLine();
      String dump[] = temp.split(",");
      int calls[] = new int[dump.length];
      for (int i=0; i<dump.length; i++){
        calls[i]=Integer.valueOf(dump[i]);
      }
// parsing number calls
      scanner.nextLine(); //avoids empty line

      Vector<int[][]> data = new Vector<int[][]>();
      while (scanner.hasNextLine()){
          int split[] = new int [5];
          int grid[][] = new int[5][5];
          for (int i=0; i<5; i++){
              String NoSpc = scanner.nextLine();
              if (NoSpc.charAt(0)==' ') NoSpc = NoSpc.replaceFirst(" ", "");
              String line = NoSpc.replaceAll("\\s+", " "); //why would they insert double spaces T_T
              split = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray(); //creates int[] from str
              grid[i]=split;
          }
          data.addElement(grid);
          if(scanner.hasNextLine()) scanner.nextLine();
          else break;
      }
      scanner.close();
      // Dumping input into a readable vector
      // This vector consists on a vector of 2D arrays
      // 5 arrays of 5 string each for the 5 nums

      int result = Bingo(calls, data);
      if(result != 0) System.out.println(result);
      else System.out.println("Error");
      //main program from external funct, result, and sanity return.

      //////////////////////////////////////////////
      // for (int i=0; i<data.size(); i++){
      // for (int x=0; x<5; x++){
      // for (int z=0; z<5; z++){
      //   System.out.print(data.get(i)[x][z]+" ");
      // }
      //   System.out.println();
      // }
      //   System.out.println();
      // }
      ////////////////////////////////////////////// sanity check, printing all grids within the vector

    } catch(IOException e){
      e.printStackTrace();
    }
  } 
}

