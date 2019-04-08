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

        // Skriver en lambda for sortering ved hjelp av navn basert på Comparator-interfacet
        apexx.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        // Skriver ut alle heltene i listen
        System.out.println("*****ALL*****");
        //printConditionally(apexx, s -> true);
        performConditionally(apexx, s -> true, System.out::println);

        // Skriver ut alle heltene som starter med B (viser printen med "vanlig" lambda)
        System.out.println("\n*****STARTS WITH B******");
        //printConditionally(apexx, s -> s.getName().startsWith("B"));
        performConditionally(apexx, s -> s.getName().startsWith("B"), s -> System.out.println(s));

        // Øker alderen til alle helter over 29 år med 1
        performConditionally(apexx, s -> s.getAge() > 29, s -> s.setAge(s.getAge()+1));

        // Sorterer basert på en helt sin alder
        //apexx.sort(Comparator.comparingInt(s -> s.getAge()));
        apexx.sort(Comparator.comparingInt(Superhero::getAge));

        System.out.println("\n******Over 29********");
        //printConditionally(apexx, s -> s.getAge() > 30);
        performConditionally(apexx, s -> s.getAge() > 29, System.out::println);
    }

    public static void printConditionally(List<Superhero> superheroes, Condition condition) {
        // Går gjennom listen med superhelter
        for (Superhero superhero : superheroes) {
            // Gjør en eller annen form for filtrering ved hjelp av condition sin testmetode
            if (condition.test(superhero))
                System.out.println(superhero);
        }
    }

    public static void performConditionally(List<Superhero> superheroes, Predicate<Superhero> condition, Consumer<Superhero> consumer) {
        // Går gjennom listen med superhelter
        for (Superhero superhero : superheroes) {
            // Gjør en eller annen form for filtrering ved hjelp av condition sin testmetode
            if (condition.test(superhero))
                // Utfører en eller annen definert handling på superheltobjektet
                consumer.accept(superhero);
        }
    }
}

interface Condition {
    boolean test(Superhero s);
}
