/**
 *
 * Main.java
 * @version 1.5
 * created 31/05/2022
 * last modified 02/06/2022
 * @author tjmcauley
 * Copyrighted
 */

import java.util.Scanner;

/**
 *
 * Class to run the two player game "Last Biscuit"
 */
public class Main {

    /**
     *
     * Main method to run the game
     *
     * @param args arguments
     */
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
        final String SKIP_USED = "Sorry you've used your skip";
        final String CHOICE_ONE = "one";
        final String CHOICE_TWO = "two";
        final String CHOICE_BOTH = "both";
        final String CHOICE_SKIP = "skip";

        final int BARREL_1_QUANTITY = 6;
        final int BARREL_2_QUANTITY = 8;
        final int EMPTY_BARRELS = 0;
        final int PLAYER_1 = 1;
        final int PLAYER_2 = 2;

        //Default values of barrels and player
        int barrel1 = BARREL_1_QUANTITY;
        int barrel2 = BARREL_2_QUANTITY;

        boolean player1SkipUsed = false;
        boolean player2SkipUsed = false;

        boolean isPlayer1 = true;

        //Scanner that will read both player's inputs
        Scanner userIn = new Scanner(System.in);

        System.out.println(REMAINING_BARREL_1 + barrel1);
        System.out.println(REMAINING_BARREL_2 + barrel2);

        while (barrel1 + barrel2 != EMPTY_BARRELS) {
            if (isPlayer1) {
                System.out.println(PLAYER_TURN + PLAYER_1);
            } else {
                System.out.println(PLAYER_TURN + PLAYER_2);
            }

            boolean validInput = false;
            do {
                String barrelSelect;
                do {
                    System.out.println(BARREL_CHOICE);
                    barrelSelect = userIn.nextLine();
                } while (!barrelSelect.equals(CHOICE_ONE) && !barrelSelect.equals(CHOICE_TWO)
                        && !barrelSelect.equals(CHOICE_BOTH) && !barrelSelect.equals(CHOICE_SKIP));

                if (barrelSelect.equals(CHOICE_SKIP) && (isPlayer1 && player1SkipUsed)
                        || barrelSelect.equals(CHOICE_SKIP) && (!isPlayer1 && player2SkipUsed)) {
                    System.out.println(SKIP_USED);
                } else if (barrelSelect.equals(CHOICE_SKIP) && isPlayer1) {
                    validInput = true;
                    player1SkipUsed = true;
                } else if (barrelSelect.equals(CHOICE_SKIP) && !isPlayer1) {
                    validInput = true;
                    player2SkipUsed = true;
                } else {
                    System.out.println(BISCUIT_QUANTITY);
                    while (!userIn.hasNextInt()) {
                        System.out.println(INTEGER_ERROR);
                        userIn.next();
                    }
                    int biscuitSelect = userIn.nextInt();

                    switch (barrelSelect) {
                        case (CHOICE_ONE):
                            if (biscuitSelect <= barrel1 && biscuitSelect > EMPTY_BARRELS) {
                                barrel1 -= biscuitSelect;
                                validInput = true;
                            } else {
                                System.out.println(ILLEGAL_NUMBER);
                            }
                            break;
                        case (CHOICE_TWO):
                            if (biscuitSelect <= barrel2 && biscuitSelect > EMPTY_BARRELS) {
                                barrel2 -= biscuitSelect;
                                validInput = true;
                            } else {
                                System.out.println(ILLEGAL_NUMBER);
                            }
                            break;
                        case (CHOICE_BOTH):
                            if (biscuitSelect <= barrel1 && biscuitSelect <= barrel2 && biscuitSelect > EMPTY_BARRELS) {
                                barrel1 -= biscuitSelect;
                                barrel2 -= biscuitSelect;
                                validInput = true;
                            } else {
                                System.out.println(ILLEGAL_NUMBER);
                            }
                            break;
                        default:
                            validInput = false;
                    }
                    userIn.nextLine();
                }
            } while (!validInput);

            System.out.println(REMAINING_BARREL_1 + barrel1);
            System.out.println(REMAINING_BARREL_2 + barrel2);

            isPlayer1 = !isPlayer1;
        }

        if (isPlayer1) {
            System.out.println(PLAYER_2_WINNER);
        } else {
            System.out.println(PLAYER_1_WINNER);
        }
    }
}
