package no.hiof.larseknu.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Superhero> apexx = new ArrayList<>();
        apexx.add(new Superhero("Bangalore", "Anita Williams", 35));
        apexx.add(new Superhero("Lifeline", "Ajay Che", 24));
        apexx.add(new Superhero("Gibraltar", "Makao Gibralter", 30));
        apexx.add(new Superhero("Caustic", "Alexander Nox", 48));
        apexx.add(new Superhero("Bloodhound", "Unknown", -1));
        apexx.add(new Superhero("Mirage", "Elliott Witt", 30));
        apexx.add(new Superhero("Octane", "Octavio Silva", 24));
        apexx.add(new Superhero("Pathfinder", "MRVN", -1));
        apexx.add(new Superhero("Wraith", "Redacted", -1));


    }

}

