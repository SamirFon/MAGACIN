package MagacinKlase;

//import MagacinKlase.Artikal;

//import java.awt.image.BufferedImageFilter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
//import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import MagacinGUI.MagacinGUI;

public class Magacin implements MagacinInterfejs {

	private int magacinID;
	private String naziv;

	private LinkedList<MagacinskiProstor> magacinskiProstori;

	private LinkedList<Prijemnica> prijemnice;

	private LinkedList<Otpremnica> otpremnice;
	
	private List sI;
	

	public Magacin() {

		magacinskiProstori = new LinkedList<MagacinskiProstor>();

		prijemnice = new LinkedList<Prijemnica>();

		otpremnice = new LinkedList<Otpremnica>();
		
		sI= new LinkedList(); 
		
		 
	}

	public int getMagacinID() {
		return magacinID;
	}

	public void setMagacinID(int magacinID) {
		if (magacinID <= 0)

			throw new MagacinException("MagacinID mora biti veci od nule");

		this.magacinID = magacinID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.equals(""))

			throw new MagacinException("Naziv me sme biti null");

		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Magacin [magacinID=" + magacinID + ", naziv=" + naziv + ", magacinskiProstori=" + magacinskiProstori
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + magacinID;
		result = prime * result + ((magacinskiProstori == null) ? 0 : magacinskiProstori.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Magacin))
			return false;
		Magacin other = (Magacin) obj;
		if (magacinID != other.magacinID)
			return false;
		if (magacinskiProstori == null) {
			if (other.magacinskiProstori != null)
				return false;
		} else if (!magacinskiProstori.equals(other.magacinskiProstori))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	@Override
	public void primiRobu(int magacinskiProstorID, Prijemnica prijemnica) {

		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");
		if (prijemnica == null || prijemnica.getPrijemnicaID() == "")
			throw new MagacinException("Prijemnica ne sme biti null ili prazan string");

		prijemnice.add(prijemnica);

		MagacinskiProstor mp = null;
		for (int i = 0; i < magacinskiProstori.size(); i++) {
			if (magacinskiProstori.get(i).getMagacinskiProstorID() == magacinskiProstorID) {
				mp = magacinskiProstori.get(i);
			}
		}
		if (mp == null)
			throw new MagacinException("Nije pronadjen magacinski prostor");

		if (prijemnica.getStavkePr().size() <= 0)
			throw new MagacinException("Prijemnica ne moze da bude bez stavki");
		for (int i = 0; i < prijemnica.getStavkePr().size(); i++) {
			if (prijemnica.getStavkePr().get(i) == null)
				continue;
			int kolStavke = prijemnica.getStavkePr().get(i).getKolicina();

			boolean unesen = false;

			for (int j = 0; j < mp.getArtikli().size(); j++) {

				if (prijemnica.getStavkePr().get(i).getArtikliSifra()
						.getSifra() == (mp.getArtikli().get(j).getSifra())) {

					int kolArt = mp.getArtikli().get(j).getKolicina();

					mp.getArtikli().get(j).setKolicina(kolStavke + kolArt);
					unesen = true;
					break;
				}

			}
			if (!unesen) {

				Artikal a = null;

				if (prijemnice.get(i).getStavkePr().get(i).getArtikliSifra() instanceof KancelarijskiMaterijal) {
					a = new KancelarijskiMaterijal();
				} else if (prijemnice.get(i).getStavkePr().get(i).getArtikliSifra() instanceof KucnaHemija) {
					a = new KucnaHemija();
				} else if (prijemnice.get(i).getStavkePr().get(i).getArtikliSifra() instanceof Knjiga) {
					a = new Knjiga();
				}

				if (a != null) {

					a.setSifra(prijemnice.get(i).getStavkePr().get(i).getArtikliSifra().getSifra());
					a.setKolicina(prijemnice.get(i).getStavkePr().get(i).getKolicina());
					a.setNaziv(prijemnice.get(i).getStavkePr().get(i).getArtikliSifra().getNaziv());

					unesiArtikle(magacinskiProstorID, a);

				}
			}

		}
	}

	@Override
	public void izdajRobu(int magacinskiProstorID, Otpremnica otpremnica) {

		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");
		if (otpremnica == null || otpremnica.getBrojOtpremnice() <= 0)
			throw new MagacinException("Otpremnica ne sme biti null ili broj otpremnice manji ili jednak nuli");

		

		MagacinskiProstor mp = null;

		for (int i = 0; i < magacinskiProstori.size(); i++) {

			if (magacinskiProstori.get(i).getMagacinskiProstorID() == magacinskiProstorID) {
				mp = magacinskiProstori.get(i);
			}
		}
		if (mp == null) {
			throw new MagacinException("Magacinski prostor nije pronadjen");
		}
		if (otpremnica.getStavkeOt().size() <= 0) {
			throw new MagacinException("Otpremnica mora da ima stavke");
		}

		for (int i = 0; i < otpremnica.getStavkeOt().size(); i++) {
			if (otpremnica.getStavkeOt().get(i) == null)
				continue;
			int kolicina = otpremnica.getStavkeOt().get(i).getKolicina();
			
			for (int j = 0; j < mp.getArtikli().size(); j++) {

				if (otpremnica.getStavkeOt().get(i).getArtikliID().getSifra() == (mp.getArtikli().get(j).getSifra())) {
					int kolArt = mp.getArtikli().get(j).getKolicina();
					
					if (kolArt<kolicina)
						throw new MagacinException("Nema dovoljno artikla na stanju"+mp.getArtikli().get(j).getNaziv());

					break;
				}
			}
		}
		for (int i = 0; i < otpremnica.getStavkeOt().size(); i++) {
			if (otpremnica.getStavkeOt().get(i) == null)
				continue;
			int kolicina = otpremnica.getStavkeOt().get(i).getKolicina();

			for (int j = 0; j < mp.getArtikli().size(); j++) {

				if (otpremnica.getStavkeOt().get(i).getArtikliID().getSifra() == (mp.getArtikli().get(j).getSifra())) {
					int kolArt = mp.getArtikli().get(j).getKolicina();

					mp.getArtikli().get(j).setKolicina(kolArt - kolicina);

					break;
				}
			}
		}
		otpremnice.add(otpremnica);

	}

	@Override
	public List sastaviIzvestaj(  GregorianCalendar dan) {
		
		
		
		
		
		if (dan.after(new GregorianCalendar()))
			throw new MagacinException("Dan ne sme biti neki dan u buducnosti");

	
			for (int i = 0; i < otpremnice.size(); i++) {
				if (!(sI.contains(otpremnice.get(i))))
					

				if (otpremnice.get(i).getDatum().get(GregorianCalendar.YEAR) == dan.get(GregorianCalendar.YEAR)
						&& otpremnice.get(i).getDatum().get(GregorianCalendar.DAY_OF_MONTH) == dan
								.get(GregorianCalendar.DAY_OF_MONTH)
						&& otpremnice.get(i).getDatum().get(GregorianCalendar.MONTH ) == dan
								.get(GregorianCalendar.MONTH )) {
					sI.add(otpremnice.get(i));
					
			}
				
			}
			for (int i = 0; i < prijemnice.size(); i++) {
				if (!(sI.contains(prijemnice.get(i))))

				if (prijemnice.get(i).getDatum().get(GregorianCalendar.YEAR) == dan.get(GregorianCalendar.YEAR)
						&& prijemnice.get(i).getDatum().get(GregorianCalendar.DAY_OF_MONTH) == dan
								.get(GregorianCalendar.DAY_OF_MONTH)
						&& prijemnice.get(i).getDatum().get(GregorianCalendar.MONTH) == dan
								.get(GregorianCalendar.MONTH)) {
					sI.add(prijemnice.get(i));
				}
				
			}

			
			return sI;
			
	}

	public void sacuvajIzvestaj (List priotpr, String fajl) {

		try {
				PrintWriter upisi = new PrintWriter(new BufferedWriter(new FileWriter(fajl)));

		upisi.println(priotpr);
		
		upisi.close();
		} catch (Exception e) {
				System.out.println("Greska" + e.getMessage());
			}
		
	}

	@Override
	public void pregledStanja(int magacinskiProstorID,String fajl) {

		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");

		GregorianCalendar dan = new GregorianCalendar();

		try {

			PrintWriter upisiStanje = new PrintWriter(new BufferedWriter(new FileWriter(fajl)));

			for (int i = 0; i < magacinskiProstori.size(); i++) {
				if (magacinskiProstori.get(i).getMagacinskiProstorID() == magacinskiProstorID) {

					for (int j = 0; j < magacinskiProstori.get(i).getArtikli().size(); j++) {

						upisiStanje.println(magacinskiProstori.get(i).getArtikli().get(j));
					}
				}
			}
			upisiStanje.close();
		} catch (Exception e) {
			System.out.println("Greska" + e.getMessage());
		}
	}

	@Override
	public void unesiMagacinskiProstor(int magacinskiProstorID, String lokacija) {

		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");
		if (lokacija == null || lokacija.equals(""))
			throw new MagacinException("Lokacija ne sme biti null ili prazan string");

		MagacinskiProstor mp = new MagacinskiProstor();
		mp.setLokacija(lokacija);
		mp.setMagacinskiProstorID(magacinskiProstorID);
		mp.setArtikli(new LinkedList<Artikal>());

		if (magacinskiProstori.contains(mp))
			throw new MagacinException("Ovaj magacinski prostor postoji");

		magacinskiProstori.add(mp);

	}

	@Override
	public void izbrisiMagacinskiProstor(int magacinskiProstorID) {
		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");

		MagacinskiProstor mp = new MagacinskiProstor();
		mp.setMagacinskiProstorID(magacinskiProstorID);
		magacinskiProstori.remove(mp);

	}

	@Override
	public void unesiArtikle(int magacinskiProstorID, Artikal artikal) {
		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");

		if (artikal == null)
			throw new MagacinException("Artikal ne moze imati null vrednost");

		boolean postojiMagProst = false;

		for (int i = 0; i < magacinskiProstori.size(); i++) {

			if (magacinskiProstori.get(i).getMagacinskiProstorID() == magacinskiProstorID) {
				postojiMagProst = true;

				if (magacinskiProstori.get(i).getArtikli().contains(artikal))
					throw new MagacinException("Ovaj artikal se nalazi u magacinu");

				magacinskiProstori.get(i).getArtikli().add(artikal);
			}
		}

		if (!postojiMagProst)
			throw new MagacinException("Ne posotoji magacinski prostor");

	}

	@Override
	public void izbrisiArtikle(int magacinskiProstorID, Artikal artikal) {

		if (magacinskiProstorID <= 0)
			throw new MagacinException("Magacinski prostor mora biti veci od nule");

		if (artikal == null)
			throw new MagacinException("Artikal ne sme biti null");

		for (int i = 0; i < magacinskiProstori.size(); i++) {
			if (magacinskiProstori.get(i).getMagacinskiProstorID() == magacinskiProstorID) {
				
				for (int j=0; j<magacinskiProstori.get(i).getArtikli().size(); j++) {
					if (magacinskiProstori.get(i).getArtikli().get(j).getSifra()== artikal.getSifra())
 				

				magacinskiProstori.get(i).getArtikli().remove(artikal);
				}
			}

		}

	}

	@Override
	public void sacuvajMagacin(String fajl) {
		try {
			ObjectOutputStream sacuvaj = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fajl)));

			sacuvaj.writeObject(magacinskiProstori);
			sacuvaj.writeObject(otpremnice);
			sacuvaj.writeObject(prijemnice);

			sacuvaj.close();
		} catch (Exception e) {
			System.out.println("Greska" + e.getMessage());
		}

	}

	@Override
	public void ucitajMagacin(String fajl) {
		try {
			ObjectInputStream ucitaj = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fajl)));

			magacinskiProstori = (LinkedList<MagacinskiProstor>) (ucitaj.readObject());

			otpremnice = (LinkedList<Otpremnica>) (ucitaj.readObject());

			prijemnice = (LinkedList<Prijemnica>) (ucitaj.readObject());

			ucitaj.close();

		} catch (Exception e) {
			System.out.println("Greska");
		}

	}
	
	public List<Prijemnica> vratiSvePrijemnice (){
		
		return prijemnice;
	}
	
	public List<Otpremnica> vratiSveOtpremnice (){
		return otpremnice;
	}
	
	public List<MagacinskiProstor> vratiSveMagacinskeProstore (){
		
		return magacinskiProstori;
	}

}
