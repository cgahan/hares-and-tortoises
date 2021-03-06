/**
 * This class handles the Carrot Square on the game board.
 * ======================================================
 * The Rules with the Carrot Square are :
 * -- Nothing happens immediately when you land on the square
 * -- On the next turn you may >> Stay where you are and earn 10 carrots
 *                             >> Stay where you are and discard 10 carrots or
 *                             >> Take your turn as normal.
 * ===========================================================================
 * -- Once you are on a Carrot Square you may miss as many turns as you like whilst:
 * >> Collecting 10 carrots every time you stay or..
 * >> Discarding 10 carrots every time you stay.
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
 */

public class CarrotSquare extends Square {
    @Override
    public String toString() {
        return "Carrot";
    }

    @Override
    public void onTurnStart(Player player) {
        GameController.println("You are on a Carrot Square");

        boolean invalidInput = true;
        while (invalidInput) {
            GameController.println("==========Enter your choice===========");
            GameController.println("1) Stay where you are and gain 10 carrots?");
            if (player.getCarrots() >= 10) {
                GameController.println("2) Stay where you are and discard 10 carrots?");
            }
            if (!player.noValidMoves()) {
                GameController.println("3) Or take your turn as normal?");
            }
            int num;
            num = GameController.getPosInt("> ");//returns next int by user
            switch (num) {
                case 1:
                    invalidInput = false;
                    GameController.println("You have chosen to stay and gained 10 carrots!\n");
                    player.addCarrots(10);
                    player.endTurn();
                    break;
                case 2:
                    if(player.getCarrots() >= 10) {
                        invalidInput = false;
                        GameController.println("You have chosen to stay and discarded 10 carrots!\n");
                        player.takeCarrots(10);
                        player.endTurn();
                    }
                    break;
                case 3:
                    if (!player.noValidMoves()) {
                        invalidInput = false;
                        GameController.println("You have chosen to take your turn as normal!\n");
                    }
                    break;
                default:
                    invalidInput = true;
                    GameController.printlnErr("***** Invalid Option... Try Again *****\n");
            }
        }
    }

}
