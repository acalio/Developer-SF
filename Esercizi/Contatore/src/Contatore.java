class Contatore {

    protected int cnt = 0;

    public Contatore(){}

    public Contatore(int cnt){ this.cnt = cnt; }
    
    public Contatore(Contatore other) { this.cnt = other.cnt;}


    public void incrementa(){ cnt++;}

    public void decrementa(){ cnt--; }

    public int valore() { return cnt;}

}


class ContatoreModulare extends Contatore {

    private int modulo;

    public ContatoreModulare(int modulo) {
	super();
	this.modulo = modulo;
    }

    public ContatoreModulare(int modulo, int cnt) {
	super(cnt);
	this.modulo = modulo;
    }

    public ContatoreModulare(ContatoreModulare other){
	super();
	this.modulo = other.modulo;
	this.cnt = other.cnt;
    }
    

    public void incrementa() {
	super.incrementa();
	this.cnt = this.cnt % modulo;
    }    

    public void decrementa() {
	super.decrementa();
	if(this.cnt<0)
	    this.cnt = modulo-1;
    }

}
