package data.locdvd;

public class Client {
	
	int id;
	String nom;
	String numero;
	
	public Client(int id, String nom, String numero) {

		this.id = id;
		this.nom = nom;
		this.numero = numero;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	

}
