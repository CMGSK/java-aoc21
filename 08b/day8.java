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
    int cnt=0;
    for (int i=0; i<data.size(); i++){
        String output="";
        String[] parse = data.get(i)[0].split(" ");
        String[] puzzle = data.get(i)[1].split(" ");
        for (String x : puzzle){
            switch (x.length()){
                case 2:
                    output += "1";
                    break;
                case 3:
                    output += "7";
                    break;
                case 4:
                    output += "4";
                    break;
                case 5:
                    Arrays.sort(parse, Comparator.comparingInt(String::length));
                    cnt=0;
                    for (int j=0; j<3; j++){
                        for (int k=0; k<5; k++){
                            if (x.charAt(k)==parse[1].charAt(j)){
                                cnt++;
                            }
                        }
                    }
                    if (cnt==3){
                        output += "3";
                        break;
                    }
                    cnt=0;
                    StringBuilder sb = new StringBuilder(parse[2]);
                    for (int j=0; j<4; j++){
                        for (int k=0; k<2; k++){
                            if(parse[2].charAt(j)==parse[0].charAt(k)){
                                sb.deleteCharAt(sb.indexOf(Character.toString(parse[0].charAt(k))));
                            }
                        }
                    }
                    String diff = sb.toString();
                    for(int j=0; j<2; j++){
                        for(int k=0; k<5; k++){
                            if (x.charAt(k)==diff.charAt(j)){
                                cnt++;
                            }
                        }
                    }
                    if (cnt==2){
                        output += "5";
                        break;
                    }
                    else output += "2";
                    break;
                case 6:
                    Arrays.sort(parse, Comparator.comparingInt(String::length));
                    cnt=0;
                    for (int j=0; j<4; j++){
                        for (int k=0; k<6; k++){
                            if (x.charAt(k)==parse[2].charAt(j)){
                                cnt++;
                            }
                        }
                    }
                    if (cnt==4){
                        output += "9";
                        break;
                    }
                    cnt=0;
                    for (int j=0; j<3; j++){
                        for (int k=0; k<6; k++){
                            if (x.charAt(k)==parse[1].charAt(j)){
                                cnt++;
                            }
                        }
                    }
                    if (cnt==3){
                        output += "0";
                        break;
                    }
                    else output += "6";
                    break;
                case 7:
                    output += "8";
                    break;
                default:
            }
        }
        res += Integer.valueOf(output);
    }
    System.out.println(res);
    //main program and result

} catch (Exception e){
    e.printStackTrace();
}
}
}