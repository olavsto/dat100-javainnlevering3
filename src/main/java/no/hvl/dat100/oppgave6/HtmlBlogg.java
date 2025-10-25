package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;
import no.hvl.dat100.oppgave2.*;

import javax.lang.model.element.UnknownElementException;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";

    private static final String HR = "\t\t<hr>\n";

    private static final int HOEYDE = 600;
    private static final int BREDDE = 800;
	
	@Override
	public String toString() {
		String html = HTMLPREFIX;
        int i = 0;
        while(super.getSamling()[i] != null) {
            Innlegg innl = super.getSamling()[i];
            String bruker = innl.getBruker();
            String dato = innl.getDato();
            int likes = innl.getLikes();
            html += h2(bruker+"@"+dato +" ["+likes+"]");

            switch(innl.getClass().getSimpleName()){
                case "Bilde":
                    html += p(((Bilde)innl).getTekst());
                    html += iframe(((Bilde)innl).getUrl());
                    break;
                case "Tekst":
                    html += p(((Tekst)innl).getTekst());
                    break;
                    default:
                        throw new UnknownElementException(null,"Unknown class: "+ innl.getClass());
            }
            html += HR;
            i++;
        }

        html += HTMLPOSTFIX;

        return html;
		
	}

    private String h2(String s) {
        return "\t\t<h2>"+s+"</h2>\n";
    }

    private String p(String s) {
        return "\t\t<p>"+s+"</p>\n";
    }

    private String iframe(String s) {
        return "\t\t<iframe src=\""+s+"\" height="+HOEYDE+" width="+BREDDE+"></iframe>\n";
    }


}
