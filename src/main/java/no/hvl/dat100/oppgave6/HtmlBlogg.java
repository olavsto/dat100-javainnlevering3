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
	
	@Override
	public String toString() {
		String html = HTMLPREFIX;
        int i = 0;
        while(super.getSamling()[i] != null) {
            Innlegg innl = super.getSamling()[i];
            html += innl.toHTML() + HR;

            i++;
        }

        html += HTMLPOSTFIX;

        return html;
		
	}






}
