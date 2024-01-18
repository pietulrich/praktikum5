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
		String aus1 = "Daten des B�rgeramtes";
		String aus2 = "\nName des B�rgeramtes: " +  ((Buergeramt) object).getName();
		String aus3 = "\n�ffnungszeiten des B�rgeramtes: " + ((Buergeramt) object).getGeoeffnetVon() + " - " + ((Buergeramt) object).getGeoeffnetBis();
		String aus4 = "\nStra�e und Hausnummer des B�rgeramtes: " +  ((Buergeramt) object).getStrasseHNr();
		String aus5 = "\nDienstleistung des B�rgeramtes: " +  ((Buergeramt) object).getDienstleistungenAlsString(' ');
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
