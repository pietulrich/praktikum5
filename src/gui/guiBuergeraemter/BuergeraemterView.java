package gui.guiBuergeraemter;

import business.businessBuergeraemter.BuergeraemterModel;
import business.businessBuergeraemter.Buergeramt;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class BuergeraemterView {
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblGeoeffnetVon   		= new Label("Geöffnet von:");
    private Label lblGeoeffnetBis  	 		= new Label("Geöffnet bis:");
    private Label lblStrasseHNr   			= new Label("Straße und Hausnummer:");
    private Label lblDienstleistungen  		= new Label("Dienstleistungen:");
    private TextField txtName 	 			= new TextField();
    private TextField txtGeoeffnetVon		= new TextField();
    private TextField txtGeoeffnetBis		= new TextField();
    private TextField txtStrasseHNr			= new TextField();
    private TextField txtDienstleistungen	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");
    private MenuItem mnItmTxtExport 		= new MenuItem("txt-Export");
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Buergeramt
   
    private BuergeraemterControl control;
    private BuergeraemterModel model;
    
    public BuergeraemterView(BuergeraemterControl control, Stage primaryStage, BuergeraemterModel model){
    	this.control = control;
    	this.model = model;
    	
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Bürgerämtern");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblGeoeffnetVon.setLayoutX(20);
    	lblGeoeffnetVon.setLayoutY(130);
    	lblGeoeffnetBis.setLayoutX(20);
    	lblGeoeffnetBis.setLayoutY(170);
    	lblStrasseHNr.setLayoutX(20);
    	lblStrasseHNr.setLayoutY(210);
    	lblDienstleistungen.setLayoutX(20);
    	lblDienstleistungen.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblGeoeffnetVon, lblGeoeffnetBis,
       		lblStrasseHNr, lblDienstleistungen);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtGeoeffnetVon.setLayoutX(170);
    	txtGeoeffnetVon.setLayoutY(130);
    	txtGeoeffnetVon.setPrefWidth(200);
    	txtGeoeffnetBis.setLayoutX(170);
    	txtGeoeffnetBis.setLayoutY(170);
    	txtGeoeffnetBis.setPrefWidth(200);
      	txtStrasseHNr.setLayoutX(170);
    	txtStrasseHNr.setLayoutY(210);
    	txtStrasseHNr.setPrefWidth(200);
    	txtDienstleistungen.setLayoutX(170);
    	txtDienstleistungen.setLayoutY(250);
    	txtDienstleistungen.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtGeoeffnetVon, txtGeoeffnetBis,
     		txtStrasseHNr, txtDienstleistungen);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
   	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvExport);
  	    this.mnDatei.getItems().add(mnItmTxtExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	control.nehmeBuergeramtAuf(txtName.getText(), txtGeoeffnetVon.getText(), txtGeoeffnetBis.getText(), txtStrasseHNr.getText(), txtDienstleistungen.getText());
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeBuergeraemterAn();
	        } 
   	    });
	    
	    mnItmCsvExport.setOnAction(e ->
	    		schreibeBuergeraemterInDatei("csv"));
	    
	    mnItmTxtExport.setOnAction(e ->
	    		schreibeBuergeraemterInDatei("txt"));
    }
   
   private void schreibeBuergeraemterInDatei(String typ) {
	   control.schreibeBuergeramterInDatei(typ);
   }
/*    
    private void nehmeBuergeramtAuf(){
    	try{
    		this.buergeramt = new Buergeramt(
    			txtName.getText(), 
   	            Float.parseFloat(txtGeoeffnetVon.getText()),
   	            Float.parseFloat(txtGeoeffnetBis.getText()),
    		    txtStrasseHNr.getText(),
    		    txtDienstleistungen.getText().split(";"));
    		zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   */

   
    void zeigeBuergeraemterAn(){
    	/*if(model.getBuergeramt() != null){
    		txtAnzeige.setText(
    			model.getBuergeramt().gibBuergeramtZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
    	}
    	*/
    	if(model.getBuergeramt().size() > 0){
			StringBuffer text = new StringBuffer();
			for(Buergeramt bg : model.getBuergeramt()) {
				text.append(bg.gibBuergeramtZurueck(' ')+"\n");			
			}
			this.txtAnzeige.setText(text.toString());
		}
		else{
			zeigeInformationsfensterAn( 
				"Bisher wurde kein Baergeramt aufgenommen!");
		}
    }	

    void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
}
