package MagacinKlase;

public class KancelarijskiMaterijal extends Artikal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6569994125826345864L;
	private String pakovanje;
	
	
	public KancelarijskiMaterijal () {
		super ();
	}

	public KancelarijskiMaterijal(int sifra, int kolicina, String naziv, String pakovanje) {
		
	super (sifra, kolicina, naziv );
	
	setPakovanje(pakovanje);
		
		
	}
	
	
	public String getPakovanje() {
		return pakovanje;
	}

	public void setPakovanje(String pakovanje) {
		if (pakovanje == null || pakovanje.length() < 1)

			throw new MagacinException("Pakovanje ne sme biti null ili manje od jednog karaktera");

		this.pakovanje = pakovanje;
	}

	@Override
	public String toString() {
		return "KancelarijskiMaterijal: Sifra:" + getSifra() + " Kolicina: " + getKolicina() + " Naziv: " + getNaziv()
				+ " Pakovanje " + pakovanje;
	}

}
