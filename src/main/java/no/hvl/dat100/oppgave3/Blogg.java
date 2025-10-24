package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;

    private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
        nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
        nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
        /*
        int antallInnlegg = 0;
        for(Innlegg i : innleggstabell)
        {
            if(i == null)
            {
                antallInnlegg++;
            }
        }
        return antallInnlegg;
        */
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) != -1);
	}

	public boolean ledigPlass() {

        return (nesteledig < innleggtabell.length);
	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg) && ledigPlass())
		{
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
	}
	
	public String toString() {
		String s = getAntall() + "\n";
        for(int i =0; i<nesteledig;i++)
        {
            s += innleggtabell[i].toString();
        }
        return  s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length*2];
        for(int i = 0; i < innleggtabell.length; i++)
            {
            nyTabell[i] = innleggtabell[i];
            }
        innleggtabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

        if(!finnes(innlegg))
        {
            if(!ledigPlass())
            {
                utvid();
            }
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
		
	}
	
	public boolean slett(Innlegg innlegg) {

        int pos = finnInnlegg(innlegg);
        boolean ok = pos >= 0;

        if(ok){
            innleggtabell[pos] = innleggtabell[nesteledig-1];
            innleggtabell[nesteledig-1] = null;
            nesteledig--;
        }
        return ok;
	}
	
	public int[] search(String keyword) {

        int[] ider = new int[nesteledig];
        int idteller = 0;

        for(int i = 0; i < nesteledig; i++)
        {
            if(innleggtabell[i].toString().contains(keyword))
            {
                ider[idteller] = i;
                idteller++;
            }
        }
        int[] endeligIder = new int[idteller];

        for(int i = 0; i < idteller; i++)
        {
            endeligIder[i] = ider[i];
        }
        return endeligIder;
	}
}