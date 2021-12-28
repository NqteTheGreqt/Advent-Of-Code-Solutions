import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Day5 {

    public static void part1() {
        Scanner scan = new Scanner(System.in);
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        ArrayList<Integer []> points = new ArrayList<>();
        int counter = 0;

        while (true) {
            String input1 = scan.next();
            scan.next();
            String input2 = scan.next();
            if (input1.equals("done")) {
                break;
            }
            String [] point1asStr = input1.split(",");
            String [] point2asStr = input2.split(",");

            int [] point1 = new int [2];
            int [] point2 = new int [2];
            
            for (int i = 0; i < 2; i ++) {
                point1 [i] = Integer.parseInt(point1asStr [i]);
                point2 [i] = Integer.parseInt(point2asStr [i]);
            }

            x1 = point1 [0];
            x2 = point2 [0];
            y1 = point1 [1];
            y2 = point2 [1];

            if (x1 == x2) {
                if (y1 < y2) {
                    for (int i = y1; i <= y2; i ++) {
                        points.add(new Integer [] {x1, i});
                    }
                }
                else {
                    for (int i = y2; i <= y1; i ++) {
                        points.add(new Integer [] {x1, i});
                    }
                }
            }
            else if (y1 == y2) {
                if (x1 < x2) {
                    for (int i = x1; i <= x2; i ++) {
                        points.add(new Integer [] {i, y1});
                    }
                }
                else {
                    for (int i = x2; i <= x1; i ++) {
                        points.add(new Integer [] {i, y1});
                    }
                }
            }
        }

        for (int i = 0; i < points.size(); i ++) {
            for (int j = i + 1; j < points.size(); j ++) {
                //System.out.println("First: " + Arrays.toString(points.get(i)) 
                //+ ", Second: " + Arrays.toString(points.get(j)));
                //System.out.println("Equal: " + (points.get(i) [0] == points.get(j) [0] && 
                //points.get(i) [1] == points.get(j) [1]));
                if (points.get(i) [0] == points.get(j) [0] && points.get(i) [1] == points.get(j) [1]) {
                    counter ++;
                    break;
                }
            }
        }

        System.out.println(counter);

        scan.close();
    }

    public static void part2() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer [] []> lines = new ArrayList<>();
        int counter = 0;

        while (true) {
            String input1 = scan.next();
            scan.next();
            String input2 = scan.next();
            if (input1.equals("done")) {
                break;
            }

            String [] point1asStr = input1.split(",");
            String [] point2asStr = input2.split(",");

            Integer [] point1 = new Integer [2];
            Integer [] point2 = new Integer [2];
            
            for (int i = 0; i < 2; i ++) {
                point1 [i] = Integer.parseInt(point1asStr [i]);
                point2 [i] = Integer.parseInt(point2asStr [i]);
            }

            lines.add(new Integer [] [] {point1, point2});

        }

        for (int i = 0; i < lines.size(); i ++) {
            for (int j = i + 1; j < lines.size(); j ++) {
                if (lines.get(i) [0] [0] <= lines.get(j) [0] [0] && lines.get(j) [0] [0] <= lines.get(i) [1] [0] &&
                lines.get(i) [0] [1] <= lines.get(j) [0] [1] && lines.get(i) [0] [1] <= lines.get(j) [1] [1]);
            }
        }

        System.out.println(counter);

        scan.close();
    }

    public static void main(String[] args) throws Exception { 
       
    }  
}
