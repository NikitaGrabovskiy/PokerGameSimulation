package game.strategies;

import game.GameConstants;
import game.GameVariables;
import player.Player;

public class PreFlopRoundStrategy {

    public static void preFlopRoundDecision(Player player){
        int bet;
        if(player.getNumber() == GameVariables.playerWhoPutSmallBlind){
            bet = GameConstants.minimalBet;
        } else if(player.getNumber() == GameVariables.playerWhoPutBigBlind){
            bet =0;
        } else {
            bet = 2* GameConstants.minimalBet;
        }
        player.raise(bet);
    }
}
