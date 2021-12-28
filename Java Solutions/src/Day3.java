import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    public static void part1() {
        Scanner scan = new Scanner(System.in);
        int [] zeroFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int [] oneFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String gammaRate = "";
        String epsilonRate = "";

        //getting input and calculating frequencies of 0s and 1s
        while (true) {
            String binary = scan.next();
            if (binary.equals("done")) {
                break;
            }
            else {
                for (int i = 0; i < 12; i ++) {
                    if (binary.charAt(i) == '0') {
                        zeroFrequency [i] += 1;
                    }
                    else {
                        oneFrequency [i] += 1;
                    }
                }
            }
        }

        //calculating gamma and epsilon rates
        for (int i = 0; i < 12; i ++) {
            if (zeroFrequency [i] > oneFrequency [i]) {
                gammaRate += "0";
                epsilonRate += "1";
            }
            else {
                gammaRate += "1";
                epsilonRate += "0";
            }
        }

        System.out.println(toDecimal(gammaRate, 1) * toDecimal(epsilonRate, 1));
        scan.close();
    }

    public static void part2() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> binaryList = new ArrayList<String>();

        //getting input
        while (true) {
            String binary = scan.next();
            if (binary.equals("done")) {
                break;
            }
            else {
                binaryList.add(binary);
            }
        }

        ArrayList<String> o2Rating = new ArrayList<>(binaryList);
        ArrayList<String> co2Rating = new ArrayList<>(binaryList);

        //calculating oxygen generator rating
        for (int i = 0; i < 12; i ++) {
            int [] frequencies = getFrequencies(o2Rating, i);
            
            if (o2Rating.size() == 1) {
                break;
            }
            else if (frequencies [0] > frequencies [1]) {
                o2Rating = eliminate(o2Rating, '1', i);
            }
            else {
                o2Rating = eliminate(o2Rating, '0', i);
            }
        }

        //calculating CO2 scrubber rating
        for (int i = 0; i < 12; i ++) {
            int [] frequencies = getFrequencies(co2Rating, i);
            if (co2Rating.size() == 1) {
                break;
            }
            else if (frequencies [0] > frequencies [1]) {
                co2Rating = eliminate(co2Rating, '0', i);
            }
            else {
                co2Rating = eliminate(co2Rating, '1', i);
            }
        }

        System.out.println(toDecimal(o2Rating.get(0), 1) * toDecimal(co2Rating.get(0), 1));
        scan.close();
    }

    public static int [] getFrequencies(ArrayList<String> binaryList, int index) {
        int [] frequencies = {0, 0};
        for (int i = 0; i < binaryList.size(); i ++) {
            if (binaryList.get(i).charAt(index) == '0') {
                frequencies [0] ++;
            }
            else {
                frequencies [1] ++;
            }
        }
        return frequencies;
    }

    public static ArrayList<String> eliminate(ArrayList<String> binaryList, char bit, int index) {
        ArrayList<String> newList = new ArrayList<>(binaryList);
        for (int i = 0; i < binaryList.size(); i ++) {
            if (binaryList.get(i).charAt(index) == bit) {
                newList.remove(binaryList.get(i));
            }
        }
        return newList;
    }

    public static int toDecimal(String binary, int multiplier) {
        if (binary.length() == 0) {
            return 0;
        }
        else {
            return multiplier * Integer.parseInt(Character.toString(binary.charAt(binary.length() - 1)))
            + toDecimal(binary.substring(0, binary.length() - 1), multiplier * 2);
        }
    }

    public static void main(String[] args) throws Exception {
        part1();
    }   
}
