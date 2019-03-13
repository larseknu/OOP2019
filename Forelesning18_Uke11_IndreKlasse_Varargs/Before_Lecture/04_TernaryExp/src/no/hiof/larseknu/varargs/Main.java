package no.hiof.larseknu.varargs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Film> filmer = new ArrayList<>();
        filmer.add(new Film("Iron Man", LocalDate.of(2009, 1, 1)));
        filmer.add(new Film("Iron Man 2", LocalDate.of(2011, 1, 1)));
        filmer.add(new Film("Iron Man 3", LocalDate.of(2012, 1, 1)));
        filmer.add(new Film("Iron Man 4"));



    }
}

