package geometria;

class Cerchio extends Punto {

	private int raggio = 0;

	public Cerchio(){super();}

	public Cerchio(int x, int y, int raggio){
		super(x, y);
		this.raggio = raggio;
	}

	public Cerchio(Cerchio c){
		super(c.x, c.y);
		this.raggio = c.raggio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + raggio;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerchio other = (Cerchio) obj;
		if (raggio != other.raggio)
			return false;
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Cerchio [centro=("+x+","+y+") raggio=" + raggio + "]";
	}

	

}
