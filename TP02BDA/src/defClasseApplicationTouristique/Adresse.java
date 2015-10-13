package defClasseApplicationTouristique;

public class Adresse 
{
	int numRue;
	String nomRue;
	Ville villeAdresse;//Relationship Ville villeAdresse;
	Hotel hotel_adresse;//Relationship Hotel hotel_adresse inverse adresse_hotel;
	Restaurant restaurant_adresse;//Relationship Restaurant restaurant_adresse inverse adresse_restaurant;
	
}
