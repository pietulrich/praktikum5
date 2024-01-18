package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.businessBuergeraemter.Buergeramt;

public class ConcreteTxtWriterProduct extends WriterProduct{
	private BufferedWriter aus;
	
	public ConcreteTxtWriterProduct() throws IOException {
		aus = new BufferedWriter(new FileWriter("Buergeraetmter.txt", true));
	}
	
	public void fuegeInDateiHinzu(Object object) throws IOException {
		String aus1 = "Daten des Bürgeramtes";
		String aus2 = "\nName des Bürgeramtes: " +  ((Buergeramt) object).getName();
		String aus3 = "\nÖffnungszeiten des Bürgeramtes: " + ((Buergeramt) object).getGeoeffnetVon() + " - " + ((Buergeramt) object).getGeoeffnetBis();
		String aus4 = "\nStraße und Hausnummer des Bürgeramtes: " +  ((Buergeramt) object).getStrasseHNr();
		String aus5 = "\nDienstleistung des Bürgeramtes: " +  ((Buergeramt) object).getDienstleistungenAlsString(' ');
		aus.write(aus1);
		aus.write(aus2);
		aus.write(aus3);
		aus.write(aus4);
		aus.write(aus5);
	}
	public void schliesseDatei() throws IOException{
		aus.close();
	}
}
