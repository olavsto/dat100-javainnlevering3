package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
        Path filsti = Paths.get(mappe, filnavn);
		Scanner leser = null;
        Blogg b = null;
        try {
            leser = new Scanner(filsti.toFile());
            int antallInnlegg = leser.nextInt();
            b = new Blogg(antallInnlegg);

            while (leser.hasNextLine()) {
                String linje = leser.nextLine();
                if(linje.equals(TEKST)){
                    Tekst t = new Tekst(leser.nextInt(),leser.nextLine(),leser.nextLine(),leser.nextLine());
                    b.leggTil(t);
                } else if(linje.equals(BILDE)){
                    Bilde p = new Bilde(leser.nextInt(),leser.nextLine(),leser.nextLine(),leser.nextLine(),leser.nextLine());
                    b.leggTil(p);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(leser != null) {
                leser.close();
            }
        }
        return b;
	}
}
