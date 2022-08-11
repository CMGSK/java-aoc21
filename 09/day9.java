import java.util.*;
import java.io.*;

public class day9{
public static void main (String[] args) {

    try{
    FileInputStream file = new FileInputStream("input.txt");
    Scanner scanner = new Scanner(file);
    Vector<int[]> data = new Vector<int[]>();
    while(scanner.hasNextLine()){
        String[] temp = scanner.nextLine().split("");
        data.add(Arrays.stream(temp).mapToInt(Integer::parseInt).toArray());          
    }
    scanner.close();
    // Dumping input into a vector of int arrays //

    int res=0;
    for (int i=0; i<data.size(); i++){
        for (int j=0; j<data.get(i).length; j++){
            int target = data.get(i)[j];
            if (i==0 && j==0){
                if (target < data.get(i+1)[j] &&
                    target < data.get(i)[j+1]){
                        res+=target+1;
                        continue;
                    }
                continue;
            }
            if (i==data.size()-1 && j==0){
                if (target < data.get(i-1)[j] &&
                    target < data.get(i)[j+1]){
                        res+=target+1;
                        continue;
                    }
                continue;
            }
            if (i==0 && j==data.get(i).length-1){
                if (target < data.get(i+1)[j] &&
                    target < data.get(i)[j-1]){
                        res+=target+1;
                        continue;
                    }
                continue;
            }
            if (i==data.size()-1 && j==data.get(i).length-1){
                if (target < data.get(i-1)[j] &&
                    target < data.get(i)[j-1]){
                        res+=target+1;
                        continue;
                    }
                continue;
            }
            if (i==0){
                if (target < data.get(i)[j+1] &&
                    target < data.get(i+1)[j] &&
                    target < data.get(i)[j-1]) res+=target+1;
            }
            else if (i==data.size()-1){
                if (target < data.get(i)[j+1] &&
                    target < data.get(i-1)[j] &&
                    target < data.get(i)[j-1]) res+=target+1;
            }
            else if (j==0){
                if (target < data.get(i)[j+1] &&
                    target < data.get(i-1)[j] &&
                    target < data.get(i+1)[j]) res+=target+1;
            }
            else if (j==data.get(i).length-1){
                if (target < data.get(i)[j-1] &&
                    target < data.get(i-1)[j] &&
                    target < data.get(i+1)[j]) res+=target+1;
            }
            else{
                if (target < data.get(i)[j-1] &&
                    target < data.get(i-1)[j] &&
                    target < data.get(i+1)[j] &&
                    target < data.get(i)[j+1]) res+=target+1;
            }
        }
    }
    System.out.println(res);


} catch (Exception e){
    e.printStackTrace();
}
}
}

