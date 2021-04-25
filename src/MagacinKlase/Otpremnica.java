package MagacinKlase;
import java.util.Date;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Otpremnica implements Serializable {
	
	
	private static final long serialVersionUID = 1307062721096562964L;
	private int brojOtpremnice;
	private GregorianCalendar datum;
	private String kupac;
	
//	private Date datum1;

	private LinkedList<StavkaOtpremnica> stavkeOt;

	public LinkedList<StavkaOtpremnica> getStavkeOt() {
		return stavkeOt;
	}

/*	public Date getDatum1() {
		return datum1;
	}

	public void setDatum1(Date datum1) {
		this.datum1 = datum1;
	}
*/
	public void setStavkeOt(LinkedList<StavkaOtpremnica> stavkeOt) {
		this.stavkeOt = stavkeOt;
	}

	public int getBrojOtpremnice() {
		return brojOtpremnice;
	}

	public void setBrojOtpremnice(int brojOtpremnice) {
		if (brojOtpremnice <= 0)

			throw new MagacinException("Broj otpremnice mora biti veci od nule");

		this.brojOtpremnice = brojOtpremnice;
	}

	public GregorianCalendar getDatum() {
		return datum;
	}

	public void setDatum(GregorianCalendar datum) {
		if (datum.after(new GregorianCalendar()))

			throw new MagacinException("Datum ne sme biti datum iz proslosti");

		this.datum = datum;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		if (kupac == null || kupac.equals(""))

			throw new MagacinException("Kupac ne sme biti null ili prazan string");

		this.kupac = kupac;
	}

	@Override
	public String toString() {

		return "Otpremnica " + brojOtpremnice + " datum: " + datum.getTime() + " kupac: " + kupac
				+ ", stavkeOt: " + stavkeOt ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojOtpremnice;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((kupac == null) ? 0 : kupac.hashCode());
		result = prime * result + ((stavkeOt == null) ? 0 : stavkeOt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Otpremnica))
			return false;
		Otpremnica other = (Otpremnica) obj;
		if (brojOtpremnice != other.brojOtpremnice)
			return false;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (kupac == null) {
			if (other.kupac != null)
				return false;
		} else if (!kupac.equals(other.kupac))
			return false;
		if (stavkeOt == null) {
			if (other.stavkeOt != null)
				return false;
		} else if (!stavkeOt.equals(other.stavkeOt))
			return false;
		return true;
	}

}