import java.util.Scanner;

public class Day3 {

    public static void part1() {
        Scanner scan = new Scanner(System.in);
        int [] zeroFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int [] oneFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String gammaRate = "";
        String epsilonRate = "";

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
