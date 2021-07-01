class Cliente {

	private String code; // la banca assenga il codice
	private String name;
	private String lastName;
	private String address;
	private String tel;
	private String email;
	private String birthDate;
	private String cf;

	public Cliente(String name,
		       String lastName,
		       String address,
		       String tel,
		       String email,
		       String birthDate,
		       String cf) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthDate = birthDate;
		this.cf = cf;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (this.code != null)
		    //il codice cliente è gia stato settato
		    throw new RuntimeException("Non puoi cambiare codice ad un correntista"); // Prog. Termina!
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		return true;
	}

    

}
