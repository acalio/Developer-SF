package sortable;

class Intero extends Sortable {

	private int valore;

	public Intero(int valore) {
		this.valore = valore;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	@Override
	protected int compareTo(Sortable other) {
		Intero tmp = (Intero) other;
		return valore-tmp.valore;
	}

	@Override
	public String toString() {
		return "Intero [valore=" + valore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intero other = (Intero) obj;
		if (valore != other.valore)
			return false;
		return true;
	}

	

}
