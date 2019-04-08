package no.hiof.larseknu.lambda;

public class Main {

    public static void main(String[] args) {
        // Lambda uttrykk for å få et tilfeldig tall mellom 0 og 99
        SimpleMath randomNumberAnon = () -> (int) (Math.random() * 100);

        // Tilsvarende med en anonym indre klasse
        SimpleMath randomNumber = new SimpleMath() {
            @Override
            public int doMath() {
                return (int) (Math.random() * 100);
            }
        };

        // Skriver ut resultatene av kjøringene
        System.out.println("Random Lambda: " + randomNumber.doMath());
        System.out.println("Random Lambda: " + randomNumber.doMath());
        System.out.println("Random Anon: " + randomNumber.doMath());
        System.out.println("Random Anon: " + randomNumber.doMath());

        // Lambda for å generere et tilfeldig tall fra 0 opp til n
        MediocreMath randomToMax = n -> (int) (Math.random() * n);

        System.out.println("RandomToMax: " + randomToMax.doMath(40));
        System.out.println("RandomToMax: " + randomToMax.doMath(10));
        System.out.println("RandomToMax: " + randomToMax.doMath(1000));


        // Lamba for å sjekke om et tall er større enn et annet
        MediumMath lessThan = (n, m) -> n < m;

        System.out.println("5 less than 6? " + lessThan.doMath(5, 6));

        AdvancedMath isPartOfFibonacciSequence = n -> {
            int x1 = 5*n*n + 4;
            int x2 = 5*n*n - 4;

            int s1 = (int) Math.sqrt(x1);
            int s2 = (int) Math.sqrt(x2);

            return (Math.pow(s1, 2) == x1 || Math.pow(s2, 2) == x2);
        };

        // Går gjennom fibonacci tallene under 1000
        int fibbonaci = 0;
        int i = 0;
        int j = 1;
        while (fibbonaci < 1000) {
            System.out.println(fibbonaci + " - " + isPartOfFibonacciSequence.doMath(fibbonaci));
            fibbonaci = i + j;
            j = i;
            i = fibbonaci;
        }

        // Sjekker at 987 er en del av fibonacci-rekken
        System.out.println(isPartOfFibonacciSequence.doMath(987));
        // Sjekker at 420 ikke er en del av fibonacci-rekken
        System.out.println(isPartOfFibonacciSequence.doMath(420));
    }
}

// Interfacene vi benytter i klassen over, vi har disse her for lesbarhetens skyld,
// men de burde helst vært skilt ut i egne interface-filer
interface SimpleMath {
    int doMath();
}

interface MediocreMath {
    int doMath(int number);
}

interface MediumMath {
    boolean doMath(int number1, int number2);
}

interface AdvancedMath {
    boolean doMath(int number);
}
