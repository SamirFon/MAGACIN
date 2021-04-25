package MagacinKlase;
import java.util.Date;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Prijemnica implements Serializable{

	
	private static final long serialVersionUID = -4173296540711467368L;

	private String prijemnicaID;

	private String nazivDobavljaca;
	private GregorianCalendar datum;
	

	private LinkedList<StavkaPrijemnica> stavkePr;

	public LinkedList<StavkaPrijemnica> getStavkePr() {
		return stavkePr;
	}

	public void setStavkePr(LinkedList<StavkaPrijemnica> stavkePr) {
		this.stavkePr = stavkePr;
	}

	public String getPrijemnicaID() {
		return prijemnicaID;
	}

	public void setPrijemnicaID(String prijemnicaID) {
		if (prijemnicaID == null) {

			throw new MagacinException("PrijemnicaID mora imati vrednost");
		}
		this.prijemnicaID = prijemnicaID;
	}

	public String getNazivDobavljaca() {
		return nazivDobavljaca;
	}

	public void setNazivDobavljaca(String nazivDobavljaca) {
		if (nazivDobavljaca == null || nazivDobavljaca.equals(""))
			throw new MagacinException("Naziv dobavljaca mora imati biti upisan");
		this.nazivDobavljaca = nazivDobavljaca;
	}

	public GregorianCalendar getDatum() {
		return datum;
	}

	public void setDatum(GregorianCalendar datum) {
		if (datum.after(new GregorianCalendar()))
			throw new MagacinException("Datum ne sme biti posle sadasnjeg");
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Prijemnica " + prijemnicaID + ", Dobavljac: " + nazivDobavljaca + ", datum: "
				+ datum.getTime() + ", stavkePr: " + stavkePr ;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((nazivDobavljaca == null) ? 0 : nazivDobavljaca.hashCode());
		result = prime * result + ((prijemnicaID == null) ? 0 : prijemnicaID.hashCode());
		result = prime * result + ((stavkePr == null) ? 0 : stavkePr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Prijemnica))
			return false;
		Prijemnica other = (Prijemnica) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (nazivDobavljaca == null) {
			if (other.nazivDobavljaca != null)
				return false;
		} else if (!nazivDobavljaca.equals(other.nazivDobavljaca))
			return false;
		if (prijemnicaID == null) {
			if (other.prijemnicaID != null)
				return false;
		} else if (!prijemnicaID.equals(other.prijemnicaID))
			return false;
		if (stavkePr == null) {
			if (other.stavkePr != null)
				return false;
		} else if (!stavkePr.equals(other.stavkePr))
			return false;
		return true;
	}

}
