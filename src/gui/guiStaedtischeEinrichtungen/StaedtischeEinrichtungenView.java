package gui.guiStaedtischeEinrichtungen;

import java.io.IOException;

import business.businessBuergeraemter.BuergeraemterModel;
import business.businessBuergeraemter.Buergeramt;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import gui.guiBuergeraemter.BuergeraemterControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	// Hier ergaenzen
    private StaedtischeEinrichtungenControl control;
    private BuergeraemterModel baModel;
    private SporthallenModel spModel;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraemter     
 		= new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraemter  = new TextArea();
    	private Button btnAnzeigeBuergeraemter = new Button("Anzeige");
    	
    	private Label lblAnzeigeSporthallen
 		= new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthallen = new TextArea();
    	private Button btnAnzeigeSporthallen = new Button("Anzeige");
    	
    	
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl control, Stage primaryStage, BuergeraemterModel baModel, SporthallenModel spModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen "+"Einrichtungen");
    		primaryStage.show();
    		// Hier ergaenzen
    		
    		this.baModel = baModel;
    		this.spModel = spModel;
    		this.control = control;
    		
			this.initKomponentenBuergeraemter();
			this.initListenerBuergeraemter();
			
			this.initKomponentenSporthallen();
			this.initListenerSporthallen();
    	}

    	
    	private void initKomponentenSporthallen(){
    		// Label
	 		Font font = new Font("Arial", 20);
	 		lblAnzeigeSporthallen.setLayoutX(10);
	 		lblAnzeigeSporthallen.setLayoutY(40);
	 		lblAnzeigeSporthallen.setFont(font);
	 		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
	       	pane.getChildren().add(lblAnzeigeSporthallen);    
        	


// Textbereich	
	       	txtAnzeigeSporthallen.setEditable(false);
	       	txtAnzeigeSporthallen.setLayoutX(10);
	       	txtAnzeigeSporthallen.setLayoutY(90);
	       	txtAnzeigeSporthallen.setPrefWidth(220);
	       	txtAnzeigeSporthallen.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeigeSporthallen);        	
        	// Button
       		btnAnzeigeSporthallen.setLayoutX(10);
       		btnAnzeigeSporthallen.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSporthallen); 
   }
    	
    	private void initKomponentenBuergeraemter(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeBuergeraemter.setLayoutX(310);
    		lblAnzeigeBuergeraemter.setLayoutY(40);
    		lblAnzeigeBuergeraemter.setFont(font);
    		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBuergeraemter);    
        	


// Textbereich	
        	txtAnzeigeBuergeraemter.setEditable(false);
     		txtAnzeigeBuergeraemter.setLayoutX(310);
    		txtAnzeigeBuergeraemter.setLayoutY(90);
     		txtAnzeigeBuergeraemter.setPrefWidth(220);
    		txtAnzeigeBuergeraemter.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeBuergeraemter);        	
        	// Button
          	btnAnzeigeBuergeraemter.setLayoutX(310);
        	btnAnzeigeBuergeraemter.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBuergeraemter); 
   }
    	
    	
   private void initListenerBuergeraemter() {
	    btnAnzeigeBuergeraemter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
    }
   private void initListenerSporthallen() {
	   btnAnzeigeSporthallen.setOnAction(
			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeSporthallenAn();
	        	} 
  	    });
   }
    void zeigeBuergeraemterAn(){
    		/*if(model.getBuergeramt() != null){
    			txtAnzeigeBuergeraemter.setText(
    					model.getBuergeramt()
 				.gibBuergeramtZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}*/
    	if(baModel.getBuergeramt().size() > 0){
			StringBuffer text = new StringBuffer();
			for(Buergeramt bg : baModel.getBuergeramt()) {
				text.append(bg.gibBuergeramtZurueck(' ')+"\n");			
			}
			this.txtAnzeigeBuergeraemter.setText(text.toString());
		}
		else{
			zeigeInformationsfensterAn( 
				"Bisher wurde kein Baergeramt aufgenommen!");
		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }

	public void zeigeSporthallenAn() {
		try {
			spModel.leseSporthallenAusCsvDatei();
		} catch (IOException e) {
			// TODO Auto-generated catch b	lock
			e.printStackTrace();
		}
    	if(spModel.getSporthalle().size() > 0){
			StringBuffer text = new StringBuffer();
			for(Sporthalle sp : spModel.getSporthalle()) {
				text.append(sp.gibSporthalleZurueck(' ')+"\n");			
			}
			this.txtAnzeigeSporthallen.setText(text.toString());
		}
		else{
			zeigeInformationsfensterAn( 
				"Bisher wurde kein Sporthalle aufgenommen!");
		}
		
	}	
    
}