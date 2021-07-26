package geometria;
class Punto {
	protected double x = 0;
	protected double y = 0;

	public Punto(){}

	public Punto(double x, double y){
		this.x = x;
		this.y = y;
	}

	public Punto(Punto p){
		this.x = p.x;
		this.y = p.y;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}


	public double distanza(Punto p) {
		double c1 = x - p.x;
		double c2 = y - p.y;
		double d = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
		return d;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + "y="+y+"]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		return true;
	}
	

}
