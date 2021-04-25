package MagacinKlase;

import java.io.Serializable;

public class StavkaOtpremnica implements Serializable {

	
	private static final long serialVersionUID = -8679651196129516943L;

	private Artikal artikliID;

	private int kolicina;

	public Artikal getArtikliID() {
		return artikliID;
	}

	public void setArtikliID(Artikal artikliID) {
		this.artikliID = artikliID;
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
	
		return "\n " + artikliID + ", kolicina=" + kolicina + "]";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikliID == null) ? 0 : artikliID.hashCode());
		result = prime * result + kolicina;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StavkaOtpremnica))
			return false;
		StavkaOtpremnica other = (StavkaOtpremnica) obj;
		if (artikliID == null) {
			if (other.artikliID != null)
				return false;
		} else if (!artikliID.equals(other.artikliID))
			return false;
		if (kolicina != other.kolicina)
			return false;
		return true;
	}

}
