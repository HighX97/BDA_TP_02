package defClasseApplicationTouristique;

public class Adresse 
{
	
	//Attributs
	
	private int numRue;
	private String nomRue;
	private Ville ville;//Relationship Ville villeAdresse;
	private Hotel hotel;//Relationship Hotel hotel_adresse inverse adresse_hotel;
	private Restaurant restaurant_adresse;//Relationship Restaurant restaurant_adresse inverse adresse_restaurant;
	
	
	//Constructeurs
	
	//Accesseurs
	
	public int getNumRue() {
		return numRue;
	}
	
	public String getNomRue() {
		return nomRue;
	}

	public Ville getVille() {
		return ville;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Restaurant getRestaurant_adresse() {
		return restaurant_adresse;
	}
	
	//Mutateurs
	
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public void setRestaurant_adresse(Restaurant restaurant_adresse) {
		this.restaurant_adresse = restaurant_adresse;
	}




	
	
	
}
