package prviPaket;

import java.util.GregorianCalendar;

public class Valuta {
	
	private String naziv;
	private String skraceniNaziv;
	private GregorianCalendar datum;
	private double[] kurs = new double[3];
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		this.datum = datum;
	}
	public double[] getKurs() {
		return kurs;
	}
	public void setKurs(double[] kurs) {
		this.kurs = kurs;
	}
	
	
	
}
