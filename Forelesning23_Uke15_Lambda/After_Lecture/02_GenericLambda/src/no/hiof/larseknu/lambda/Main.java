package no.hiof.larseknu.lambda;

public class Main {

    public static void main(String[] args) {
        // Undersøker om et tall er delbart på et annet, sier at paramterne skal være av typen Integer/int
	    GenericTest<Integer> isFactor = (a, b) -> (a % b) == 0;

        System.out.println( (isFactor.test(10, 5) ? "5 is a factor of 10" : "5 is not a factor of 10") );

        // Benytter string sin contains metode, fremfor egendefinert lambda (må ta samme paramter/return-type
        GenericTest<String> stringContains = String::contains;

        System.out.println( stringContains.test("Uranus", "Ur") ? "It does" : "It does not" );

        //Slår sammen to stringer ved hjelp av Lambda, spesifiser paramtere/return-typer
        GeneritTestReturn<String, String> mergeStrings = (a, b) -> a + " " + b;

        System.out.println(mergeStrings.test("How you", "doin'?"));
    }
}

interface GenericTest<T> {
    boolean test(T a, T b);
}

interface GeneritTestReturn<T, R> {
    R test(T a, T b);
}
