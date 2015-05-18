package data.locdvd;

public class Film {
	
	int id;
	String categorie;
	String titre;
	String realisateur;
	String acteur;
	int nbreExemplaire;
	String dateSortie;	
	String description;
	int limitAge;
	String recompense;
	int Img;
	
	public Film(int id, String categorie, String titre, String realisateur,
			String acteur, int nbreExemplaire, String dateSortie,
			String description, int limitAge, String recompense, int img) {
		this.id = id;
		this.categorie = categorie;
		this.titre = titre;
		this.realisateur = realisateur;
		this.acteur = acteur;
		this.nbreExemplaire = nbreExemplaire;
		this.dateSortie = dateSortie;
		this.description = description;
		this.limitAge = limitAge;
		this.recompense = recompense;
		this.Img = img;
	}
	public int getImg() {
		return Img;
	}
	public void setImg(int img) {
		Img = img;
	}
	public Film() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public String getActeur() {
		return acteur;
	}
	public void setActeur(String acteur) {
		this.acteur = acteur;
	}
	public int getNbreExemplaire() {
		return nbreExemplaire;
	}
	public void setNbreExemplaire(int nbreExemplaire) {
		this.nbreExemplaire = nbreExemplaire;
	}
	public String getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLimitAge() {
		return limitAge;
	}
	public void setLimitAge(int limitAge) {
		this.limitAge = limitAge;
	}
	public String getRecompense() {
		return recompense;
	}
	public void setRecompense(String recompense) {
		this.recompense = recompense;
	}
	
	
	

}
