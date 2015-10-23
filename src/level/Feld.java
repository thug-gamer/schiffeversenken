package level;

public class Feld {
	
	private boolean istSchiff;
	private boolean istBeschossen;
	
	public Feld() {
		istSchiff = false;
		istBeschossen = false;
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

	@Override
	public String toString() {
		if (istBeschossen == true && istSchiff == false) {
			return "[-]";
		}
		else if (istBeschossen == true && istSchiff == true) {
			return "[X]";
		}
		return "[ ]";
	}

}
