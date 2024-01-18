package business.businessBuergeraemter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import writers.ConcreteCsvWriterCreator;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class BuergeraemterModel implements Observable{
	
	Vector<Observer> observers = new Vector<Observer>();
	
	//private Buergeramt buergeramt;
	private ArrayList<Buergeramt> buegeraemter = new ArrayList<>();
	
	private static BuergeraemterModel instance;
	
	public static BuergeraemterModel getInstance() {
		if(instance == null) {
			instance = new BuergeraemterModel();
		}
		return instance;
	}
	
	private BuergeraemterModel() {
		
	}
	
	public ArrayList<Buergeramt> getBuergeramt() {
		return buegeraemter;
	}


	//public void setBuergeramt(Buergeramt buergeramt) {
	//	this.buergeramt = buergeramt;
	//}
	public void addBuergeramt(Buergeramt buergeramt) {
		buegeraemter.add(buergeramt);
	}


	public void schreibeBuergerInCsvDatei(Buergeramt buergeramt) throws IOException{
		WriterCreator writerCreator = new ConcreteCsvWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		for (Buergeramt buergeramt2 : buegeraemter) {
			writer.fuegeInDateiHinzu(buergeramt2);
		}
		
		writer.schliesseDatei();
		
		//BufferedWriter aus = new BufferedWriter(
		//		new FileWriter("Buergeraetmter.csv", true));
		//aus.write(buergeramt.gibBuergeramtZurueck(';'));
		//aus.close();
		
	}


	public void schreibeBuergerInTxtDatei(Buergeramt buergeramt2) throws IOException {
		WriterCreator writerCreator = new ConcreteTxtWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		for (Buergeramt buergeramt3 : buegeraemter) {
			writer.fuegeInDateiHinzu(buergeramt3);
		}
		writer.schliesseDatei();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
		
	}

}
