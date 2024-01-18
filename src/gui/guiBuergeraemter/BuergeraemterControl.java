package gui.guiBuergeraemter;

import java.io.IOException;

import business.businessBuergeraemter.BuergeraemterModel;
import business.businessBuergeraemter.Buergeramt;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BuergeraemterControl implements Observer{
	private BuergeraemterView view;
	private BuergeraemterModel model;
	
	
	public BuergeraemterControl(Stage primaryStage) {
		model = BuergeraemterModel.getInstance();
		view = new BuergeraemterView(this, primaryStage, model);
		model.addObserver(this);
		
		
	}
	
    
    void nehmeBuergeramtAuf(String txtName, String txtGeoeffnetVon, String txtGeoeffnetBis, String txtStrasseHNr, String txtDienstleistungen){
    	try{
    		model.addBuergeramt(new Buergeramt(
    			txtName, 
   	            Float.parseFloat(txtGeoeffnetVon),
   	            Float.parseFloat(txtGeoeffnetBis),
    		    txtStrasseHNr,
    		    txtDienstleistungen.split(";")));
    		
    		//this.view.zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
    		model.notifyObservers();
       	}
       	catch(Exception exc){
       		this.view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    void schreibeBuergeramterInDatei(String typ) {
    	try {
    		if("csv".equals(typ)) {
    			for (Buergeramt b : model.getBuergeramt()) {
    				model.schreibeBuergerInCsvDatei(b);
				}
    			
    			view.zeigeInformationsfensterAn("HALLO");
    		}
    		else {
    			//view.zeigeInformationsfensterAn("Noch nicht implementiert!");
    			//throw new IOException();
    			for(Buergeramt b : model.getBuergeramt()) {
    			model.schreibeBuergerInTxtDatei(b);
    			}
    			view.zeigeInformationsfensterAn("HALLO");
    		}
    		
    	} catch(IOException exc) {
    		view.zeigeFehlermeldungsfensterAn("IOException beim Speichern");
    	}
    	catch(Exception exc) {
    		view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
    	}
    }


	@Override
	public void update() {
		view.zeigeBuergeraemterAn();
		
	}
}
