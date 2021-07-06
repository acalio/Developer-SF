class App {

    public static void main(String[] args) {
	Contatore c = new Contatore(0);

	for(int i = 0; i<10 ; i++){
	    c.incrementa();
	    System.out.println(c.valore());
	}
	System.out.println("=========Modulare========");

	Contatore cm = new ContatoreModulare(3);
	for (int i = 0; i < 10; i++) {
	    cm.incrementa();
	    System.out.println(cm.valore());

	}

    }
}
