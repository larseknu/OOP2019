package no.hiof.larseknu.dyrehage;

import java.time.LocalDate;

public class HonningGrevling extends Dyr {
    public static final int ANTALL_SLANGER_DREPT_FOR_AVLIVNING = 10;
    private int antallSlangerDrept;

    public HonningGrevling(String navn) {
        super(navn);
    }

    public HonningGrevling(String navn, LocalDate fodselsdag) {
        super(navn, fodselsdag);
        this.antallSlangerDrept = 0;
    }

    public int getAntallSlangerDrept() {
        return antallSlangerDrept;
    }

    public void setAntallSlangerDrept(int antallSlangerDrept) {
        this.antallSlangerDrept = antallSlangerDrept;
    }

    public void drepteEnSlangeTil() {
        if (antallSlangerDrept < ANTALL_SLANGER_DREPT_FOR_AVLIVNING)
            antallSlangerDrept++;
        else
            System.out.println(super.getNavn() + " må desverre avlives.");
    }
}
