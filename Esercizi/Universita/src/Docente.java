class Docente
{
    
    /**
     * Vettore contenente il nome dei ruoli
     */
    private static String[] ROLES = {
	"Ricercatore", // -> 0
	"Associato",   // -> 1
	"Ordinario"   // -> 2
    };

    /**
     * Codice identificativo progressivo
     */
    private static int CODE = 0;

    /**
     * nome del docente
     */
    private String name;

    /**
     * cognome del docente
     */
    private String lastName;

    /**
     * Codice identificativo
     */
    private int code; 

    
    /**
     * Eta del docente
     */
    private int age;


    /**
     * Ruolo (Ricercatore, Associato, Ordinario)
     */
    private int role;


    public Docente(String n, String ln, int a, int r)
    {
	//!!!!!! Attenzione al valore di r !!!!!!!
	this.name = n;
	this.lastName = ln;
	this.age = a;
	this.role = r;
	this.code = CODE++;
    }

    public Docente(String n, String ln, int a, int r, int cod)
    {
	//!!!!!! Attenzione al valore di r !!!!!!!
	this.name = n;
	this.lastName = ln;
	this.age = a;
	this.role = r;
	if (cod >= CODE) {
	    this.code = cod;
	    CODE = this.code + 1; 
	// } else {
	//     //il programma si stoppa! 
	//     throw RuntimeException();
	}
    }


    public Docente(Docente tmp)
    {
	//!!!!!! Attenzione al valore di r !!!!!!!
	this.name = tmp.name;
	this.lastName = tmp.lastName;
	this.age = tmp.age;
	this.role = tmp.role;
	this.code = tmp.code;
	//devo incrementeare la variabile CODE? NO
    }


    public String getName()
    {
	return name;
    }


    public void setName(String name)
    {
	this.name = name;
    }


    public String getLastName()
    {
	return lastName;
    }


    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }


    public int getAge()
    {
	return age;
    }


    public void setAge(int age)
    {
	this.age = age;
    }


    public int getRole()
    {
	return role;
    }


    public void setRole(int role) {
	this.role = role;
    }

    


    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

    @Override
    public String toString()
    {
	return "Docente [codice="+code+" nome="+name+" cognome="+lastName+ " age=" + age + " ruolo="+ROLES[role]+"]";
    }


	@Override
	public boolean equals(Object obj) {
	    if (this == obj) // il riferimento di this e uguale al riferimento obj
		return true;
	    if (obj == null) 
		return false;
	    if (this.getClass() != obj.getClass()) // le classi sono diverse -> sicuramente this e diverso da obj
		return false;
	    
	    Docente other = (Docente) obj; // casting -> obj e di tipo Docente (alias)
	    if (code != other.code)
		return false;

	    return true;
	}

    
    
}
