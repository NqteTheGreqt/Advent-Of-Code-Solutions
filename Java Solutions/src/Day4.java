import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {

    public static int part1(int [] numbers, ArrayList<Integer [] []> cards) {
        int lastCalled = 0;
        Integer [] [] winner = null;

        //updating each card, checking if there is a winner, and exiting the loop if there is
        for (int i = 0; i < numbers.length; i ++) {
            cards = updateCards(numbers [i], cards);
            winner = findWinner(cards);
            if (winner != null) {
                lastCalled = numbers [i];
                break;
            }
        }

        return lastCalled * sumOfCard(winner);
    }

    public static int sumOfCard(Integer [] [] card) {
        int sum = 0;
        //calculating the sum of the winning card
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 5; j ++) {
                if (card [i] [j] != -1) {
                    sum += card [i] [j];
                }
            }
        }
        return sum;
    }

    public static Integer [] [] findWinner(ArrayList<Integer [] []> cards) {
        //checking if any card is a winner
        for (int k = 0; k < cards.size(); k ++) {
            //checking if the card is a horizontal winner
            for (int i = 0; i < 5; i ++) {
                boolean horizontalWinner = true;
                for (int j = 0; j < 5; j ++) {
                    if (cards.get(k) [i] [j] != -1) {
                        horizontalWinner = false;
                    }
                }
                if (horizontalWinner) { 
                    return cards.get(k);
                }
            }

            //checking if the card is a vertical winner
            for (int i = 0; i < 5; i ++) {
                boolean verticalWinner = true;
                for (int j = 0; j < 5; j ++) {
                    if (cards.get(k) [j] [i] != -1) {
                        verticalWinner = false;
                    }
                }
                if (verticalWinner) {
                    return cards.get(k);
                }
            }

        }
        //returning null if no card is a winner 
        return null;
    }
    
    public static ArrayList<Integer [] []> findWinners(ArrayList<Integer [] []> cards) {
        ArrayList<Integer [] []> winners = new ArrayList<>();
        //checking if any card is a winner
        for (int k = 0; k < cards.size(); k ++) {
            //checking if the card is a horizontal winner
            for (int i = 0; i < 5; i ++) {
                boolean horizontalWinner = true;
                for (int j = 0; j < 5; j ++) {
                    if (cards.get(k) [i] [j] != -1) {
                        horizontalWinner = false;
                    }
                }
                if (horizontalWinner) { 
                    winners.add(cards.get(k));
                }
            }

            //checking if the card is a vertical winner
            for (int i = 0; i < 5; i ++) {
                boolean verticalWinner = true;
                for (int j = 0; j < 5; j ++) {
                    if (cards.get(k) [j] [i] != -1) {
                        verticalWinner = false;
                    }
                }
                if (verticalWinner) {
                    winners.add(cards.get(k));
                }
            }

        }
        //returning the list of winners 
        return winners;
    }

    public static ArrayList<Integer [] []> updateCards(int number, ArrayList<Integer [] []> cards) {
        //changing value of array at given position to -1 if it equals the number
        for (int i = 0; i < cards.size(); i ++) {
            for (int j = 0; j < 5; j ++) {
                for (int k = 0; k < 5; k ++) {
                    if (cards.get(i) [j] [k] == number) {
                        cards.get(i) [j] [k] = -1;
                    }
                }
            }
        }
        return cards;
    }
    
    public static int part2(int [] numbers, ArrayList<Integer [] []> cards) {
        int lastCalled = 0;
        ArrayList<Integer [] []> winners = null;

        //updating each card, removing winners, and exiting the loop when the cards list is empty
        for (int i = 0; i < numbers.length; i ++) {
            cards = updateCards(numbers [i], cards);
            winners = findWinners(cards);
            for (int j = 0; j < winners.size(); j ++) {
                cards.remove(winners.get(j));
            }
            
            if (cards.isEmpty()) {
                lastCalled = numbers [i];
                break;
            }
        }
        return lastCalled * sumOfCard(winners.get(0));
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        String [] numbersAsStr = input.split(",");
        int [] numbers = new int [numbersAsStr.length];
        ArrayList<Integer [] []> cards = new ArrayList<>();

        //getting called numbers
        for (int i = 0; i < numbers.length; i ++) {
            numbers [i] = Integer.parseInt(numbersAsStr[i]);
        }

        //getting cards
        while (scan.hasNextInt()) {
            Integer [] [] card = new Integer [5] [5];
            for (int i = 0; i < 5; i ++) {
                for (int j = 0; j < 5; j ++) {
                    card [i] [j] = scan.nextInt();
                }
            }
            cards.add(card);
        }

        System.out.println(part1(numbers, cards));
        System.out.println(part2(numbers, cards));
        scan.close();
    } 
}
