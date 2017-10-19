package aula.tradutor;

public enum Romanos {
	
	I ("I", 1),
	V ("V", 5),
	X ("X", 10),
	L ("L", 50),
	C ("C", 100),
	D ("D", 500),
	M ("M", 1000);

	private String romano;
	
	private Integer valor;
	
	Romanos(String romano, Integer valor) {
		this.romano = romano;
		this.valor = valor;
	}

	public String getRomano() {
		return romano;
	}

	public void setRomano(String romano) {
		this.romano = romano;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
