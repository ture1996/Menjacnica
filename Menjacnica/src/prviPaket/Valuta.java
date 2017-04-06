package prviPaket;

import java.util.Arrays;
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
		if(naziv==null||naziv.equals(null))
			throw new RuntimeException("Niste uneli naziv!");
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		if(skraceniNaziv==null||skraceniNaziv.equals(null))
			throw new RuntimeException("Niste uneli skraceni naziv!");
		if(skraceniNaziv.length()!=3)
			throw new RuntimeException("Skraceni naziv mora sadrzati 3 slova!");
		this.skraceniNaziv = skraceniNaziv;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(int dan, int mesec, int godina) {
		if(dan<=0||mesec<=0||godina<=0)
			throw new RuntimeException("Dan, mesec ili godina ne smeju biti manji ili jednaki 0!");
		GregorianCalendar pomocni = new GregorianCalendar(godina, mesec-1, dan);
		if(pomocni.after(new GregorianCalendar()))
			throw new RuntimeException("Ne mozete uneti kurs za dan koji ce tek doci!");
		this.datum=pomocni;
	}
	
	public double[] getKurs() {
		return kurs;
	}
	public void setKurs(double kupovni, double srednji, double prodajni) {
		if(kupovni<=0||srednji<=0||prodajni<=0)
			throw new RuntimeException("Kurs ne sme biti manji ili jednak 0!");
		if(kupovni>=srednji||srednji>=prodajni)
			throw new RuntimeException("Kupovni kurs ne sme biti veci ili jednak niti srednjem niti prodajnom kursu, a prodajni ne sme biti manji ili jednak niti srednjem niti kupovnom kursu!");
		this.kurs[0]=kupovni;
		this.kurs[1]=srednji;
		this.kurs[2]=prodajni;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + Arrays.hashCode(kurs);
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valuta v = (Valuta) obj;
		if(getNaziv().equals(v.getNaziv())&&getSkraceniNaziv().equals(v.getSkraceniNaziv())&&getDatum().equals(v.getDatum()))
			return true;
		return false;
	}
	
	public String toString() {
		double[] kurs2 = getKurs();
		return "Naziv: " + getNaziv() + "\t Oznaka: " + getSkraceniNaziv() + "\t Datum kursa: "+ getDatum().get(GregorianCalendar.DAY_OF_MONTH) +
		"." + (getDatum().get(GregorianCalendar.MONTH)+1) + "." + getDatum().get(GregorianCalendar.YEAR) + "\t Kupovni:" + kurs2[0] + "\t Srednji: "+ kurs2[1] + "\t Prodajni: " + kurs2[2];
	}
	
	
}
