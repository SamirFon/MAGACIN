package MagacinKlase;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JList;

public class MagacinTest1 {

	public static void main(String[] args) {
		
		JList list;

		Magacin m = new Magacin();
		m.setMagacinID(1);
		m.setNaziv("MAGACIN");

		LinkedList<StavkaOtpremnica> stavOt = new LinkedList<StavkaOtpremnica>();
		LinkedList<StavkaPrijemnica> stavkePr = new LinkedList<StavkaPrijemnica>();

		m.unesiMagacinskiProstor(1, "KancelarijskiMaterijal");
		m.unesiMagacinskiProstor(2, "Hemija");
		m.unesiMagacinskiProstor(3, "Knjige");

		Artikal k = new KancelarijskiMaterijal();
		k.setKolicina(100);
		k.setNaziv("Olovka");
		k.setSifra(1);

		Artikal k1 = new KancelarijskiMaterijal();
		k1.setKolicina(100);
		k1.setNaziv("Gumica");
		k1.setSifra(2);

		Artikal k2 = new KancelarijskiMaterijal();
		k2.setKolicina(100);
		k2.setNaziv("Marker");
		k2.setSifra(3);

		/*
		 * Artikal k3 = new KancelarijskiMaterijal(); k3.setKolicina(100);
		 * k3.setNaziv("Olovka"); k3.setSifra(1);
		 */
		Artikal k4 = new KancelarijskiMaterijal();
		k4.setKolicina(100);
		k4.setNaziv("Gumica");
		k4.setSifra(2);

		m.unesiArtikle(1, k);
		m.unesiArtikle(1, k1);
		m.unesiArtikle(1, k2);
		// m.unesiArtikle(1, k3);
		// m.unesiArtikle(1, k4);

		StavkaOtpremnica sk = new StavkaOtpremnica();

		sk.setArtikliID(k);
		sk.setKolicina(30);

		StavkaOtpremnica sk1 = new StavkaOtpremnica();
		sk1.setArtikliID(k1);
		sk1.setKolicina(30);

		StavkaOtpremnica sk2 = new StavkaOtpremnica();
		sk2.setArtikliID(k2);
		sk2.setKolicina(30);

		Otpremnica ok = new Otpremnica();
		ok.setBrojOtpremnice(1);
		ok.setDatum(new GregorianCalendar());
		ok.setKupac("FON");
		ok.setStavkeOt(stavOt);

		ok.getStavkeOt().add(sk);
		ok.getStavkeOt().add(sk1);
		ok.getStavkeOt().add(sk2);

		Prijemnica pr = new Prijemnica();
		pr.setPrijemnicaID("1");
		pr.setDatum(new GregorianCalendar());
		pr.setNazivDobavljaca("Fon");
		pr.setStavkePr(stavkePr);

		StavkaPrijemnica stavPr = new StavkaPrijemnica();

		stavPr.setArtikliSifra(k);
		stavPr.setKolicina(20);

		StavkaPrijemnica StavPr1 = new StavkaPrijemnica();
		StavPr1.setArtikliSifra(k1);
		StavPr1.setKolicina(20);

		pr.getStavkePr().add(stavPr);
		pr.getStavkePr().add(StavPr1);

		// System.out.println(pr);

		// m.izdajRobu(1, ok);

	//	 m.pregledStanja(1);
		// m.primiRobu(1, pr);

		// m.pregledStanja(1);
		// m.izbrisiMagacinskiProstor(1);
	//	 m.primiRobu(1, pr);
		// m.sastaviIzvestaj(new GregorianCalendar());

	//	m.unesiMagacinskiProstor(4, "Pice");

	//	m.unesiArtikle(4, k4);
	//	m.pregledStanja(1);
	//	System.out.println(m);
		
	//	m.sacuvajMagacin("stanje1");
		
	//	m.ucitajMagacin("stanje");
		
	//	System.out.println(m);
		
		
	//	m.ucitajMagacin("stanje1");
		
	//	List<MagacinskiProstor> mp = 	m.vratiSveMagacinskeProstore();
	//	MagacinskiProstor mp1 = mp.get(0);
		
	//	list = new JList(mp1.getArtikli().toArray());
	
		
	//	System.out.println(list);
		
		
		Artikal h = new KucnaHemija();
		h.setKolicina(100);
		h.setNaziv("Ajaks");
		h.setSifra(4);
		
		Artikal h1 = new KucnaHemija();
		h1.setKolicina(100);
		h1.setNaziv("Mer");
		h1.setSifra(5);

		Artikal h2 = new KucnaHemija();
		h2.setKolicina(100);
		h2.setNaziv("Cif");
		h2.setSifra(6);

		/*
		 * Artikal k3 = new KancelarijskiMaterijal(); k3.setKolicina(100);
		 * k3.setNaziv("Olovka"); k3.setSifra(1);
		 */
	/*	Artikal k4 = new KancelarijskiMaterijal();
		k4.setKolicina(100);
		k4.setNaziv("Gumica");
		k4.setSifra(2);          */

		m.unesiArtikle(2, h);
		m.unesiArtikle(2, h1);
		m.unesiArtikle(2, h2);
		// m.unesiArtikle(1, k3);
		// m.unesiArtikle(1, k4);

		StavkaOtpremnica sh = new StavkaOtpremnica();

		sh.setArtikliID(h);
		sh.setKolicina(30);

		StavkaOtpremnica sh1 = new StavkaOtpremnica();
		sh1.setArtikliID(h1);
		sh1.setKolicina(30);

		StavkaOtpremnica sh2 = new StavkaOtpremnica();
		sh2.setArtikliID(h2);
		sh2.setKolicina(30);

		Otpremnica oh = new Otpremnica();
		oh.setBrojOtpremnice(2);
		oh.setDatum(new GregorianCalendar());
		oh.setKupac("FON");
		oh.setStavkeOt(stavOt);

		oh.getStavkeOt().add(sh);
		oh.getStavkeOt().add(sh1);
		oh.getStavkeOt().add(sh2);


		StavkaPrijemnica stavPrh = new StavkaPrijemnica();

		stavPrh.setArtikliSifra(h);
		stavPrh.setKolicina(20);

		StavkaPrijemnica StavPrh1 = new StavkaPrijemnica();
		StavPrh1.setArtikliSifra(h1);
		StavPrh1.setKolicina(20);
		
		

		Prijemnica prh = new Prijemnica();
		prh.setPrijemnicaID("2");
		prh.setDatum(new GregorianCalendar());
		prh.setNazivDobavljaca("Fon");
		prh.setStavkePr(stavkePr);

		prh.getStavkePr().add(stavPrh);
		prh.getStavkePr().add(StavPrh1);
		
		// System.out.println(pr);
			
	//	 m.izdajRobu(2, oh);

	//	 m.pregledStanja(2);
	//	 m.primiRobu(2, prh);
	
	//	 m.pregledStanja(2);
		// m.izbrisiMagacinskiProstor(1);
	//	 m.primiRobu(1, pr);
		// m.sastaviIzvestaj(new GregorianCalendar());

	//	m.unesiMagacinskiProstor(4, "Pice");

	//	m.unesiArtikle(4, k4);
	//	m.pregledStanja(1);
	//	System.out.println(m);
		
	//	m.sacuvajMagacin("stanjeM.txt");
		
	//	m.ucitajMagacin("stanjeM.txt");
	//	
	//	System.out.println(m);
		
		
	//	m.ucitajMagacin("stanje1");
		
	//	List<MagacinskiProstor> mp = 	m.vratiSveMagacinskeProstore();
	//	MagacinskiProstor mp1 = mp.get(0);
		
	//	list = new JList(mp1.getArtikli().toArray());
	
		
	//	System.out.println(list);
		
		
		Artikal kn = new Knjiga();
		kn.setKolicina(100);
		kn.setNaziv("Ekonomija");
		kn.setSifra(7);

		Artikal kn1 = new Knjiga();
		kn1.setKolicina(100);
		kn1.setNaziv("Fizika");
		kn1.setSifra(8);

		Artikal kn2 = new Knjiga();
		kn2.setKolicina(100);
		kn2.setNaziv("Srpski");
		kn2.setSifra(9);

		/*
		 * Artikal k3 = new KancelarijskiMaterijal(); k3.setKolicina(100);
		 * k3.setNaziv("Olovka"); k3.setSifra(1);
		 */
	/*	Artikal k4 = new KancelarijskiMaterijal();
		k4.setKolicina(100);
		k4.setNaziv("Gumica");
		k4.setSifra(2);          */

		m.unesiArtikle(3, kn);
		m.unesiArtikle(3, kn1);
		m.unesiArtikle(3, kn2);
		// m.unesiArtikle(1, k3);
		// m.unesiArtikle(1, k4);

		StavkaOtpremnica skn = new StavkaOtpremnica();

		skn.setArtikliID(kn);
		skn.setKolicina(30);

		StavkaOtpremnica skn1 = new StavkaOtpremnica();
		skn1.setArtikliID(kn1);
		skn1.setKolicina(30);

		StavkaOtpremnica skn2 = new StavkaOtpremnica();
		skn2.setArtikliID(kn2);
		skn2.setKolicina(30);

		Otpremnica okn = new Otpremnica();
		okn.setBrojOtpremnice(2);
		okn.setDatum(new GregorianCalendar());
		okn.setKupac("FON");
		okn.setStavkeOt(stavOt);

		okn.getStavkeOt().add(skn);
		okn.getStavkeOt().add(skn1);
		okn.getStavkeOt().add(skn2);


		StavkaPrijemnica stavPkn = new StavkaPrijemnica();

		stavPkn.setArtikliSifra(kn);
		stavPkn.setKolicina(20);

		StavkaPrijemnica StavPkn1 = new StavkaPrijemnica();
		StavPkn1.setArtikliSifra(kn1);
		StavPkn1.setKolicina(20);
		
		

		Prijemnica pkn = new Prijemnica();
		pkn.setPrijemnicaID("2");
		pkn.setDatum(new GregorianCalendar());
		pkn.setNazivDobavljaca("Fon");
		pkn.setStavkePr(stavkePr);

		pkn.getStavkePr().add(stavPkn);
		pkn.getStavkePr().add(stavPkn);
		
		// System.out.println(pr);
			
	//	 m.izdajRobu(2, oh);

	//	 m.pregledStanja(2);
	//	 m.primiRobu(2, prh);
	
	//	 m.pregledStanja(2);
		// m.izbrisiMagacinskiProstor(1);
	//	 m.primiRobu(1, pr);
		// m.sastaviIzvestaj(new GregorianCalendar());

	//	m.unesiMagacinskiProstor(4, "Pice");

	//	m.unesiArtikle(4, k4);
	//	m.pregledStanja(1);
	//	System.out.println(m);
		
		m.sacuvajMagacin("SviMagacini");
		
	//	m.ucitajMagacin("STANJE");
		
/*		Magacin kancMat = new Magacin();
		
		kancMat.unesiMagacinskiProstor(1, "KancelarijskiMaterijal");
		for (int i=0; i<m.vratiSveMagacinskeProstore().get(0).getArtikli().size(); i++) {
			kancMat.unesiArtikle(1, m.vratiSveMagacinskeProstore().get(0).getArtikli().get(i));
		}

		System.out.println(kancMat);
	Magacin hem = new Magacin();
		
		hem.unesiMagacinskiProstor(2, "Hemija");
		for (int i=0; i<m.vratiSveMagacinskeProstore().get(1).getArtikli().size(); i++) {
			hem.unesiArtikle(2, m.vratiSveMagacinskeProstore().get(1).getArtikli().get(i));
		}
		
		System.out.println(hem);
	Magacin knjiga = new Magacin();
		
		knjiga.unesiMagacinskiProstor(3, "Knjige");
		for (int i=0; i<m.vratiSveMagacinskeProstore().get(2).getArtikli().size(); i++) {
			knjiga.unesiArtikle(3, m.vratiSveMagacinskeProstore().get(2).getArtikli().get(i));
		}
		
	
		System.out.println(knjiga);

		m.sacuvajMagacin("KancelarijskiMaterijal");

		m.sacuvajMagacin("Hemija");

		m.sacuvajMagacin("Knjige");
	*/	
		System.out.println(m);
		
		
	//	m.ucitajMagacin("stanje1");
		
	//	List<MagacinskiProstor> mp = 	m.vratiSveMagacinskeProstore();
	//	MagacinskiProstor mp1 = mp.get(0);
		
	//	list = new JList(mp1.getArtikli().toArray());
	
		
	//	System.out.println(list);
		
		
	}

}
