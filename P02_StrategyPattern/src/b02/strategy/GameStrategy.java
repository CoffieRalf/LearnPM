package b02.strategy;

import b02.game.Game;
import b02.game.Move;

public interface GameStrategy {
    // Naechsten Zug berechnen
    Move nextMove(Game g);
}
