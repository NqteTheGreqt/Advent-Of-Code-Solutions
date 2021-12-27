import java.util.Scanner;

public class Day2 {

    public static void part1() {

        Scanner scan = new Scanner(System.in);
        int hPosition = 0;
        int depth = 0;

        //getting input and calculating at the same time
        while (true) {
            String direction = scan.next();
            if (direction.equals("done")) {
                break;
            }
            else {
                int magnitude = scan.nextInt();
                //if the command is "forward", add the corresponding number to the horizontal position
                if (direction.equals("forward")) {
                    hPosition += magnitude;
                }
                //if the command is "down", add the corresponding number to the depth
                else if (direction.equals("down")) {
                    depth += magnitude;
                }
                //if the command is "up", subtract the corresponding number from the depth
                else {
                    depth -= magnitude;
                }
            }
        }
        scan.close();
        System.out.println(hPosition * depth);
    }

    public static void part2() {
        Scanner scan = new Scanner(System.in);
        int hPosition = 0;
        int depth = 0;
        int aim = 0;

        //getting input and calculating at the same time
        while (true) {
            String direction = scan.next();
            if (direction.equals("done")) {
                break;
            }
            else {
                int magnitude = scan.nextInt();
                /*if the command is "forward", add the corresponding number to the horizontal position
                and add the corresponding number multiplied by the aim to the depth*/ 
                if (direction.equals("forward")) {
                    hPosition += magnitude;
                    depth += aim * magnitude;
                }
                //if the command is "down", add the corresponding number to the depth
                else if (direction.equals("down")) {
                    aim += magnitude;
                }
                //if the command is "up", subtract the corresponding number from the depth
                else {
                    aim -= magnitude;
                }
            }
        }
        scan.close();
        System.out.println(hPosition * depth);
    }
    public static void main(String[] args) throws Exception {
        part1();
        part2();
    }
}
