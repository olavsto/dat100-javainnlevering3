package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		boolean success;
        PrintWriter skriver = null;
        try {
            Path filsti = Paths.get(mappe, filnavn);
            skriver = new PrintWriter(filsti.toString());
            skriver.println(samling.toString());
            success = true;
        } catch (FileNotFoundException e) {
            success = false;
        } finally {
            if(skriver != null){
                skriver.close();
            }
        }

        return success;
	}
}
