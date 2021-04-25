package MagacinKlase;

public class Knjiga extends Artikal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7945737917103534299L;
	private String ISBN;
	
	
	public Knjiga () {
		super ();
	}
	
	public Knjiga (int sifra, int kolicina, String naziv, String isbn) {
		
		super (sifra, kolicina, naziv);
		
		setISBN(isbn);
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		if (iSBN.length() < 4 || iSBN.length() > 4)

			throw new MagacinException("ISNB mora da ima 4 karaktera");

		ISBN = iSBN;
	}

	@Override
	public String toString() {
		return "Knjige : Sifra: " + getSifra() + " Kolicina: " + getKolicina() + " Naziv: " + getNaziv() + " ISBN: "
				+ ISBN;
	}

}
