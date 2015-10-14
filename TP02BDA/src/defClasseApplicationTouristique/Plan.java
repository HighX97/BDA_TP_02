package defClasseApplicationTouristique;

public class Plan 
{
	int idPlan;
	Region region;//Relationship Region region_plan inverse plan_region;
	
	Plan()
	{
		System.out.println("Plan créé");
	}
}
