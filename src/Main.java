import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        //Messages that will print throughout the game
        final String BISCUIT_QUANTITY = "How many biscuits are you taking? ";
        final String INTEGER_ERROR = "Please input an integer: ";
        final String BARREL_CHOICE = "Choose a barrel: barrel (one),"
                + " barrel2 (two) "
                + "or both (both), "
                + "or skip turn (skip)? ";
        final String ILLEGAL_NUMBER = "Sorry, that's not a legal number"
                + " of biscuits for that/those barrel(s)\n";
        final String REMAINING_BARREL_1 = "Biscuits Left - Barrel 1: ";
        final String REMAINING_BARREL_2 = "Biscuits Left - Barrel 2: ";
        final String PLAYER_TURN = "Player Turn: ";
        final String PLAYER_1_WINNER = "Winner is player 1";
        final String PLAYER_2_WINNER = "Winner is player 2";

        final int BARREL_1_QUANTITY = 6;
        final int BARREL_2_QUANTITY = 8;
        final int INITIAL_PLAYER = 1;

        //Default values of barrels and player
        int barrel1 = BARREL_1_QUANTITY;
        int barrel2 = BARREL_2_QUANTITY;
        int player = INITIAL_PLAYER;

        //Scanner that will read both player's inputs
        Scanner userIn = new Scanner(System.in);
        String barrelSelect;
        int biscuitSelect;
        boolean isBarrel1 = false;
        boolean isBarrel2 = false;

        while (barrel1 + barrel2 != 0) {
            System.out.println(REMAINING_BARREL_1 + barrel1);
            System.out.println(REMAINING_BARREL_2 + barrel2);
            System.out.println(PLAYER_TURN + player);

            if (player == 1) {
                do {
                    System.out.println(BARREL_CHOICE);
                    barrelSelect = userIn.nextLine();
                    if (barrelSelect.equals("one")) {
                        isBarrel1 = true;
                        isBarrel2 = false;
                    } else if (barrelSelect.equals("two")) {
                        isBarrel1 = false;
                        isBarrel2 = true;
                    } else if (barrelSelect.equals("both")) {
                        isBarrel1 = true;
                        isBarrel2 = true;
                    }
                } while (!barrelSelect.equals("one") && !barrelSelect.equals("two") && !barrelSelect.equals("both"));

                System.out.println(BISCUIT_QUANTITY);
                biscuitSelect = userIn.nextInt();
                if (isBarrel1 && !isBarrel2) {
                    barrel1 -= biscuitSelect;
                } else if (!isBarrel1 && isBarrel2) {
                    barrel2 -= biscuitSelect;
                } else if (isBarrel1 && isBarrel2) {
                    barrel1 -= biscuitSelect;
                    barrel2 -= biscuitSelect;
                }
                if (barrel1 + barrel2 == 0) {
                    System.out.println(PLAYER_1_WINNER);
                } else {
                    player ++;
                    userIn.nextLine();
                }
            }

            else if (player == 2) {
                do {
                    System.out.println(BARREL_CHOICE);
                    barrelSelect = userIn.nextLine();
                    if (barrelSelect.equals("one")) {
                        isBarrel1 = true;
                        isBarrel2 = false;
                    } else if (barrelSelect.equals("two")) {
                        isBarrel1 = false;
                        isBarrel2 = true;
                    } else if (barrelSelect.equals("both")) {
                        isBarrel1 = true;
                        isBarrel2 = true;
                    }
                } while (!barrelSelect.equals("one") && !barrelSelect.equals("two") && !barrelSelect.equals("both"));

                System.out.println(BISCUIT_QUANTITY);
                biscuitSelect = userIn.nextInt();
                if (isBarrel1 && !isBarrel2) {
                    barrel1 -= biscuitSelect;
                } else if (!isBarrel1 && isBarrel2) {
                    barrel2 -= biscuitSelect;
                } else if (isBarrel1 && isBarrel2) {
                    barrel1 -= biscuitSelect;
                    barrel2 -= biscuitSelect;
                }
                if (barrel1 + barrel2 == 0) {
                    System.out.println(PLAYER_2_WINNER);
                } else {
                    player --;
                    userIn.nextLine();
                }
            }
        }
    }
}
