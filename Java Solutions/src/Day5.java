import java.util.Scanner;

public class Day5 {

    public static void part1() {
        Scanner scan = new Scanner(System.in);
        int [] [] grid = new int [1000] [1000];
        int counter = 0;
        int x1, y1, x2, y2;

        //getting input and running calculations at the same time
        while (true) {
            String input1 = scan.next();
            if (input1.equals("done")) {
                break;
            }
            scan.next();
            String input2 = scan.next();

            String [] point1asStr = input1.split(",");
            String [] point2asStr = input2.split(",");

            x1 = Integer.parseInt(point1asStr [0]);
            y1 = Integer.parseInt(point1asStr [1]);
            x2 = Integer.parseInt(point2asStr [0]);
            y2 = Integer.parseInt(point2asStr [1]);
            
            //if the line is vertical, "draw" it on the grid and check for overlaps
            if (x1 == x2) {
                if (y1 < y2) {
                    for (int i = y1; i <= y2; i ++) {
                        if (grid [x1] [i] == 1) {
                            counter ++;
                        } 
                        grid [x1] [i] ++;
                    }
                }
                else {
                    for (int i = y2; i <= y1; i ++) {
                        if (grid [x1] [i] == 1) {
                            counter ++;
                        }
                        grid [x1] [i] ++;
                    }
                }
            }
            //if the line is horizontal, "draw" it on the grid and check for overlaps
            else if (y1 == y2) {
                if (x1 < x2) {
                    for (int i = x1; i <= x2; i ++) {
                        if (grid [i] [y1] == 1) {
                            counter ++;
                        } 
                        grid [i] [y1] ++;
                    }
                }
                else {
                    for (int i = x2; i <= x1; i ++) {
                        if (grid [i] [y1] == 1) {
                            counter ++;
                        }
                        grid [i] [y1] ++;
                    }
                }
            }
        }

        System.out.println(counter);
        scan.close();
    }

    public static void part2() {
        Scanner scan = new Scanner(System.in);
        int [] [] grid = new int [1000] [1000];
        int counter = 0;
        int x1, y1, x2, y2;

        //getting input and running calculations at the same time
        while (true) {
            String input1 = scan.next();
            if (input1.equals("done")) {
                break;
            }
            scan.next();
            String input2 = scan.next();

            String [] point1asStr = input1.split(",");
            String [] point2asStr = input2.split(",");

            x1 = Integer.parseInt(point1asStr [0]);
            y1 = Integer.parseInt(point1asStr [1]);
            x2 = Integer.parseInt(point2asStr [0]);
            y2 = Integer.parseInt(point2asStr [1]);
            
            //if the line is vertical, "draw" it on the grid and check for overlaps
            if (x1 == x2) {
                if (y1 < y2) {
                    for (int i = y1; i <= y2; i ++) {
                        if (grid [x1] [i] == 1) {
                            counter ++;
                        } 
                        grid [x1] [i] ++;
                    }
                }
                else {
                    for (int i = y2; i <= y1; i ++) {
                        if (grid [x1] [i] == 1) {
                            counter ++;
                        }
                        grid [x1] [i] ++;
                    }
                }
            }
            //if the line is horizontal, "draw" it on the grid and check for overlaps
            else if (y1 == y2) {
                if (x1 < x2) {
                    for (int i = x1; i <= x2; i ++) {
                        if (grid [i] [y1] == 1) {
                            counter ++;
                        } 
                        grid [i] [y1] ++;
                    }
                }
                else {
                    for (int i = x2; i <= x1; i ++) {
                        if (grid [i] [y1] == 1) {
                            counter ++;
                        }
                        grid [i] [y1] ++;
                    }
                }
            }
            //if the line is diagonal, "draw" it on the grid and check for overlaps
            else {
                if (x1 < x2 && y1 < y2) {
                    for (int i = 0; i <= x2 - x1; i ++) {
                        if (grid [x1 + i] [y1 + i] == 1) {
                            counter ++;
                        }
                        grid [x1 + i] [y1 + i] ++;
                    }
                }
                else if (x2 < x1 && y2 < y1) {
                    for (int i = 0; i <= x1 - x2; i ++) {
                        if (grid [x2 + i] [y2 + i] == 1) {
                            counter ++;
                        }
                        grid [x2 + i] [y2 + i] ++;
                    }
                }
                else if (x1 < x2 && y2 < y1) {
                    for (int i = 0; i <= x2 - x1; i ++) {
                        if (grid [x1 + i] [y1 - i] == 1) {
                            counter ++;
                        }
                        grid [x1 + i] [y1 - i] ++;
                    }
                }
                else if (x2 < x1 && y1 < y2){
                    for (int i = 0; i <= x1 - x2; i ++) {
                        if (grid [x2 + i] [y2 - i] == 1) {
                            counter ++;
                        }
                        grid [x2 + i] [y2 - i] ++;
                    }
                }
            }
        }

        System.out.println(counter);
        scan.close();
    }

    public static void main(String[] args) throws Exception {
        part1();
        part2();
    }  
}
