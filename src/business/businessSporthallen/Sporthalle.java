package business.businessSporthallen;

public class Sporthalle {
    private String name;
    private int quardatmeter;
    private String bodenbelag;
    
    
	public Sporthalle(String name, int quardatmeter, String bodenbelag) {
		this.name = name;
		this.quardatmeter = quardatmeter;
		this.bodenbelag = bodenbelag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuardatmeter() {
		return quardatmeter;
	}
	public void setQuardatmeter(int quardatmeter) {
		this.quardatmeter = quardatmeter;
	}
	public String getBodenbelag() {
		return bodenbelag;
	}
	public void setBodenbelag(String bodenbelag) {
		this.bodenbelag = bodenbelag;
	}
   
	public String gibSporthalleZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getQuardatmeter() + trenner
  		    + this.getBodenbelag() + trenner;
  	}

}
