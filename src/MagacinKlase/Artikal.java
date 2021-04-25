
package MagacinKlase;

import java.io.Serializable;

public abstract class Artikal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6911206152981354017L;
	private int sifra;
	private int kolicina;
	private String naziv;
	
	
	public Artikal() {
		
	}

	public Artikal (int sifra, int kolicina, String naziv) {
		super ();
		
		setSifra(sifra);
		setNaziv(naziv);
		setKolicina(kolicina);
	}
	
	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		if (sifra <= 0)

			throw new MagacinException("Sifra mora biti veca od nule");

		this.sifra = sifra;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		if (kolicina < 0)

			throw new MagacinException("Kolicina mora biti nula ili veca od nule");

		this.kolicina = kolicina;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.equals(""))

			throw new MagacinException("Naziv ne sme biti null ili prazan string");

		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Artikli [sifra=" + sifra + ", kolicina=" + kolicina + ", naziv=" + naziv + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sifra;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Artikal))
			return false;
		Artikal other = (Artikal) obj;
		if (sifra != other.sifra)
			return false;
		return true;
	}

}
