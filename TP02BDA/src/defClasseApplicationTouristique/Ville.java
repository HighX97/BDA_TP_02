package defClasseApplicationTouristique;

import java.util.List;

import com.db4o.ObjectContainer;

public class Ville extends Agglomeration 
{
	List<Hotel> hotels;//Relationship set<Hotel> hotels inverse ville_hotel;
	List<Restaurant> restaurants;//Relationship set<Restaurant> restaurants inverse ville_restaurant;

	//@TODO pending because its a interface an
	public void showAgglomerationsByRegion(ObjectContainer bd, String idRegion){
		
	}
}	
