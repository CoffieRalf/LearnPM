package b02.game;

import b02.strategy.GameStrategy;

public interface Player {
    // Spielstrategie setzen
    void setStrategy(GameStrategy s);

    // Naechsten Zug berechnen (Delegation an Strategie!)
    Move nextMove(Game g);

    // Zeichen fuer den Spieler liefern
    char getSymbol();
}
