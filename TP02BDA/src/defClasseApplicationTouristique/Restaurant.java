package defClasseApplicationTouristique;

import java.util.List;

public class Restaurant 
{
	String nomRestaurant;
	int nbCouverts;
	int nbToques;
	Ville ville_restaurant;//Relationship Ville ville_restaurant inverse restaurants;
	Adresse adresse_restaurant;//Relationship Adresse adresse_restaurant inverse restaurant_adresse;
	Hotel hotel_restaurant;//Relationship Hotel hotel_restaurant inverse restaurants_hotel;

}
