package level;

public class Feld {
	
	private boolean istSchiff;
	private boolean istBeschossen;
	private boolean istZerstoert;

	public Feld() {
		istSchiff = false;
		istBeschossen = false;
		istZerstoert = false;
	}

	public boolean isIstSchiff() {
		return istSchiff;
	}

	public void setIstSchiff(boolean istSchiff) {
		this.istSchiff = istSchiff;
	}

	public boolean isIstBeschossen() {
		return istBeschossen;
	}

	public void setIstBeschossen(boolean istBeschossen) {
		this.istBeschossen = istBeschossen;
	}

	public void setIstZerstoert(boolean istZerstoert) {
		this.istZerstoert = istZerstoert;
	}

	@Override
	public String toString() {
		if (istZerstoert == true) {
			return "[#]";
		}
		else if (istBeschossen == true && istSchiff == false) {
			return "[-]";
		}
		else if (istBeschossen == true && istSchiff == true) {
			return "[X]";
		}
		return "[ ]";
	}
}
