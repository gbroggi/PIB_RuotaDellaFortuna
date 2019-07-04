package PIB_RuotaDellaFortuna.Domain;

import java.util.HashMap;

public class Match {

    private final int MAX_CONCURRENT_IN_MATCH= 3;
    private  final int MAX_PLAYABLE_MANCHE= 5;

    HashMap<Integer,Player> playersInGame;
    HashMap<Integer,User> observator;
    AdminUser AdminOfTheMatch;

}
