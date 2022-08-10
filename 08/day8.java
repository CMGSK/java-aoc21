import java.util.*;
import java.io.*;

public class day8 {
public static void main (String[] args) {

    try{
    FileInputStream file = new FileInputStream("input.txt");
    Scanner scanner = new Scanner(file);
    Vector<String[]> data = new Vector<String[]>();
    while (scanner.hasNextLine()){
        data.addElement(scanner.nextLine().split(" \\| "));
    }
    scanner.close();
    // Dumping input into a readable vector //

    int res=0;
    for (int i=0; i<data.size(); i++){
        String[] output = data.get(i)[1].split(" ");
        for (String x : output){
            switch (x.length()){
                case 2:
                    res++;
                    break;
                case 3:
                    res++;
                    break;
                case 4:
                    res++;
                    break;
                case 7:
                    res++;
                    break;
                default:
            }
        }
    }
    System.out.println(res);
    //main program and result

} catch (Exception e){
    e.printStackTrace();
}
}
}