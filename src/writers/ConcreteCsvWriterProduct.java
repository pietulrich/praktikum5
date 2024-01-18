package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.businessBuergeraemter.Buergeramt;

public class ConcreteCsvWriterProduct extends WriterProduct{
	private BufferedWriter aus;
	
	public ConcreteCsvWriterProduct() throws IOException {
		aus = new BufferedWriter(new FileWriter("Buergeraetmter.csv", true));
	}
	
	public void fuegeInDateiHinzu(Object object) throws IOException {
		aus.write(((Buergeramt) object).gibBuergeramtZurueck(';'));
	}
	public void schliesseDatei() throws IOException{
		aus.close();
	}
}
