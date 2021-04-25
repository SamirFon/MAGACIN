package MagacinKlase;

import java.io.Serializable;

public class StavkaPrijemnica implements Serializable {

	
	private static final long serialVersionUID = 1989610904752260181L;

	private Artikal artikliSifra; // predstavljaju primarni kljuc stavkePrijemnica

	private int kolicina;

	public Artikal getArtikliSifra() {
		return artikliSifra;
	}

	public void setArtikliSifra(Artikal artikliSifra) {
		this.artikliSifra = artikliSifra;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		if (kolicina <= 0)

			throw new MagacinException("Kolicina mora biti veca od nule");

		this.kolicina = kolicina;
	}

	@Override
	public String toString() {
		return "\n " + artikliSifra + ", kolicina=" + kolicina + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikliSifra == null) ? 0 : artikliSifra.hashCode());
		result = prime * result + kolicina;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StavkaPrijemnica))
			return false;
		StavkaPrijemnica other = (StavkaPrijemnica) obj;
		if (artikliSifra == null) {
			if (other.artikliSifra != null)
				return false;
		} else if (!artikliSifra.equals(other.artikliSifra))
			return false;
		if (kolicina != other.kolicina)
			return false;

		return true;
	}

}
