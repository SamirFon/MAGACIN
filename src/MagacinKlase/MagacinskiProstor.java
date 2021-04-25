package MagacinKlase;

import java.io.Serializable;
import java.util.LinkedList;

public class MagacinskiProstor implements Serializable{

	
	private static final long serialVersionUID = 8889604538671329777L;
	private int magacinskiProstorID; // primarni kljuc moze biti i jedinstvena lokacija
	private String lokacija;

	private LinkedList<Artikal> artikli;

	public LinkedList<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(LinkedList<Artikal> artikli) {
		this.artikli = artikli;
	}

	public int getMagacinskiProstorID() {
		return magacinskiProstorID;
	}

	public void setMagacinskiProstorID(int magacinskiProstorID) {
		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor ID mora biti pozitivan broj ");
		this.magacinskiProstorID = magacinskiProstorID;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		if (lokacija == null || lokacija.equals("")) // || lokacija!="Hemija" || lokacija != "KancelarijskiMaterijal" ||
														// lokacija != "Knjige")
			throw new MagacinException("Pogresna lokacija");

		this.lokacija = lokacija;
	}

	@Override
	public String toString() {
		return "MagacinskiProstor [magacinskiProstorID=" + magacinskiProstorID + ", lokacija=" + lokacija + ", artikli="
				+ artikli + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + magacinskiProstorID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MagacinskiProstor))
			return false;
		MagacinskiProstor other = (MagacinskiProstor) obj;
		if (magacinskiProstorID != other.magacinskiProstorID)
			return false;
		return true;
	}

}
