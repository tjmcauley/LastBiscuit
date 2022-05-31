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
        final String SKIP_USED = "Sorry you've used your skip";

        final int BARREL_1_QUANTITY = 6;
        final int BARREL_2_QUANTITY = 8;

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

        while (barrel1 + barrel2 != 0) {
            if (isPlayer1) {
                System.out.println(PLAYER_TURN + 1);
            } else {
                System.out.println(PLAYER_TURN + 2);
            }

            boolean validInput = false;
            do {
                String barrelSelect;
                do {
                    System.out.println(BARREL_CHOICE);
                    barrelSelect = userIn.nextLine();
                } while (!barrelSelect.equals("one") && !barrelSelect.equals("two") && !barrelSelect.equals("both") && !barrelSelect.equals("skip"));

                if (barrelSelect.equals("skip") && (isPlayer1 && player1SkipUsed) || (!isPlayer1 && player2SkipUsed)) {
                    System.out.println(SKIP_USED);
                } else if (barrelSelect.equals("skip") && isPlayer1) {
                    validInput = true;
                    player1SkipUsed = true;
                } else if (barrelSelect.equals("skip") && !isPlayer1) {
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
                        case ("one"):
                            if (biscuitSelect <= barrel1 && biscuitSelect > 0) {
                                barrel1 -= biscuitSelect;
                                validInput = true;
                            } else {
                                System.out.println(ILLEGAL_NUMBER);
                            }
                            break;
                        case ("two"):
                            if (biscuitSelect <= barrel2 && biscuitSelect > 0) {
                                barrel2 -= biscuitSelect;
                                validInput = true;
                            } else {
                                System.out.println(ILLEGAL_NUMBER);
                            }
                            break;
                        case ("both"):
                            if (biscuitSelect <= barrel1 && biscuitSelect <= barrel2 && biscuitSelect > 0) {
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
