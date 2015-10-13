package defClasseApplicationTouristique;

import java.util.List;

public class Hotel 
{
	String nomHotel;
	int nbLits;
	int nbEtoiles;
	Ville ville_hotel;//Relationship Ville ville_hotel inverse hotels;
	Adresse adresse_hotel;//Relationship Adresse adresse_hotel inverse hotel_adresse;
	List<Restaurant> restaurants_hotel;//Relationship set<Restaurant> restaurants_hotel inverse hotel_restaurant;

}
