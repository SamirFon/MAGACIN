package MagacinKlase;

public class KucnaHemija extends Artikal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 899480556013709534L;
	private String sastav;
	
	
	public KucnaHemija () {
		
		super();
	}
	
	public KucnaHemija (int sifra, int kolicina, String naziv, String sastav) {
		
		super(sifra, kolicina, naziv);
		
		setSastav(sastav);
		
	}
	
	

	public String getSastav() {
		return sastav;
	}

	public void setSastav(String sastav) {
		if (sastav == null || sastav.length() < 2)

			throw new MagacinException("Sastav ne sme biti null i morati imati vise od jednog karaktera");

		this.sastav = sastav;
	}

	@Override
	public String toString() {
		return "KucnaHemija Sifra:" + getSifra() + " Kolicina: " + getKolicina() + " Naziv: " + getNaziv() + " Sastav: "
				+ sastav;

	}

}
