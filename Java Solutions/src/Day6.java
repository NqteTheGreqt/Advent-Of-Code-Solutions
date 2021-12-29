import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {

    public static int part1(ArrayList<Integer> fish) {
        //running 80 days
        for (int i = 1; i <= 80; i ++) {
            int eightCounter = 0;
            //checking every fish in the list of fish
            for (int j = 0; j < fish.size(); j ++) {
                //if the fish is ready to reproduce, add 1 to the counter and set that fish back to 6
                if (fish.get(j) == 0) {
                    eightCounter ++;
                    fish.set(j, 6);
                }
                //if the fish is not ready, subtract 1 from its internal timer
                else {
                    fish.set(j, fish.get(j) - 1);
                }
            }
            //adding new fish as necessary
            for (int k = 1; k <= eightCounter; k ++) {
                fish.add(8);
            } 
        }
        return fish.size();
    }
    public static void main(String[] args) throws Exception {
        //getting input
        Scanner scan = new Scanner(new File("Day6Text.txt"));
        String input = scan.next();
        String [] inputArray = input.split(",");
        ArrayList<Integer> fish = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i ++) {
            fish.add(Integer.parseInt(inputArray [i]));
        }
        System.out.println(part1(fish));
        scan.close();
    }
}
