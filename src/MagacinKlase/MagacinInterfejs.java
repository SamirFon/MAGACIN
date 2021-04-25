package MagacinKlase;

import java.util.List;
import java.util.GregorianCalendar;

public interface MagacinInterfejs  {

	public void primiRobu(int magacinskiProstorID, Prijemnica prijemnica);

	public void izdajRobu(int magacinskiProstorID, Otpremnica otpremnica);
	
	public List sastaviIzvestaj(GregorianCalendar dan);
	
	public void sacuvajIzvestaj (List priotpr, String fajl);

	void pregledStanja(int magacinskiProstorID, String fajl);

	public void unesiMagacinskiProstor(int magacinskiProstorID, String lokacija);

	public void izbrisiMagacinskiProstor(int magacinskiProstorID);

	public void unesiArtikle(int magacinskiProstorID, Artikal artikal);

	public void izbrisiArtikle(int magacinkiProstorID, Artikal artikal);

	public void sacuvajMagacin(String fajl);

	public void ucitajMagacin(String fajl);
	
	public List<Prijemnica> vratiSvePrijemnice ();
	
	public List<Otpremnica> vratiSveOtpremnice ();
	
	public List<MagacinskiProstor> vratiSveMagacinskeProstore ();

	

}
