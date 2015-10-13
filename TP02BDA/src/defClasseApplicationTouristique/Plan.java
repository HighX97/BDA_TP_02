package defClasseApplicationTouristique;

import java.util.List;

import javax.management.relation.Relation;

public class Plan 
{
	int idPlan;
	List<Relation> regions;//Relationship Region region_plan inverse plan_region;
}
