import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    
    public static int part1(ArrayList<Integer> arr) {
        int counter = 0;
        for (int i = 1; i < arr.size(); i ++) {
            if (arr.get(i) > arr.get(i - 1)) {
                counter ++;
            }
        }
        return counter;
    }

    public static int part2(ArrayList<Integer> arr) {
        int counter = 0;
        for (int i = 0; i < arr.size() - 3; i ++) {
            if (arr.get(i) < arr.get(i + 3)) {
                counter ++;
            }
        }
        return counter;
    }
    
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String input = scan.next();
            if (input.equals("done")) {
                break;
            }
            else {
                numbers.add(Integer.parseInt(input));
            }
        }

        System.out.println(part1(numbers));
        System.out.println(part2(numbers));
        scan.close();
    }
}
