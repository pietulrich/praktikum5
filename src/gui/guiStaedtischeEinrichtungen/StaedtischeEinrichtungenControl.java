package gui.guiStaedtischeEinrichtungen;

import business.businessBuergeraemter.BuergeraemterModel;
import business.businessSporthallen.SporthallenModel;
import gui.guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer{
	private StaedtischeEinrichtungenView view;
	private BuergeraemterModel bModel;
	private SporthallenModel shModel;

	public StaedtischeEinrichtungenControl(Stage fensterStaedtischeEinrichtungen) {
		bModel = BuergeraemterModel.getInstance();
		shModel = SporthallenModel.getInstance();
		view = new StaedtischeEinrichtungenView(this, fensterStaedtischeEinrichtungen, bModel, shModel);
		bModel.addObserver(this);		
		shModel.addObserver(this);
	}

	@Override
	public void update() {
		view.zeigeBuergeraemterAn();
		view.zeigeSporthallenAn();
		
	}
	

}
