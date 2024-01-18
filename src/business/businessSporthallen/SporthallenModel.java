package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import business.businessBuergeraemter.BuergeraemterModel;
import business.businessBuergeraemter.Buergeramt;
import ownUtil.Observable;
import ownUtil.Observer;
import writers.ConcreteCsvWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class SporthallenModel implements Observable{
	
	Vector<Observer> observers = new Vector<Observer>();
	
	private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
	
	private static SporthallenModel instance;
	
	public static SporthallenModel getInstance() {
		if(instance == null) {
			instance = new SporthallenModel();
		}
		return instance;
	}
	public ArrayList<Sporthalle> getSporthalle() {
		return sporthallen;
	}
	public void addSporthalle(Sporthalle sporthalle) {
		sporthallen.add(sporthalle);
	}
	
	public void leseSporthallenAusCsvDatei() throws IOException{
		BufferedReader ein = new BufferedReader(
				new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while(zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Sporthalle(zeile[0], Integer.parseInt(zeile[1]), zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.sporthallen = ergebnis;
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
