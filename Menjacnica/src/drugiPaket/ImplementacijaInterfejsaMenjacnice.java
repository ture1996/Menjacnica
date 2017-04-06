package drugiPaket;

import java.util.LinkedList;

import prviPaket.Valuta;

public class ImplementacijaInterfejsaMenjacnice implements InterfejsMenjacnice {
	
	private LinkedList<Valuta> valute = new LinkedList<Valuta>();
	
	public void daLiJeNull(Valuta v){
		if(v==null)
			throw new RuntimeException("Parametar ne moze biti null!");
	}
	
	public void dodaj(Valuta v) {
		daLiJeNull(v);
		if(valute.contains(v))
			throw new RuntimeException("Vec postoji kurs date valute za ovaj datum!");
		valute.add(v);
	}

	public void obrisi(Valuta v) {
		daLiJeNull(v);
		if(!valute.contains(v))
			throw new RuntimeException("Ne postoji kurs date valute za ovaj datum!");
		valute.remove(v);
	}

	public String pronadji(Valuta v) {
		daLiJeNull(v);
		if(!valute.contains(v))
			throw new RuntimeException("Kurs koji ste uneli ne postoji!");
		return v.toString();
	}

	public LinkedList<Valuta> getValute() {
		return valute;
	}
	
}
