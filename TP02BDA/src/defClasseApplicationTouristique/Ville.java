package defClasseApplicationTouristique;

import java.util.List;

public class Ville implements Agglomeration 
{
	List<Hotel> hotels;//Relationship set<Hotel> hotels inverse ville_hotel;
	List<Restaurant> restaurants;//Relationship set<Restaurant> restaurants inverse ville_restaurant;
}	
