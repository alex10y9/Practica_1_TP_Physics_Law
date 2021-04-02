package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator {

	private double eps;
	
	public EpsilonEqualStates(double eps) {
		this.eps = eps ;
	}
	
	@Override
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		double time1, time2 ;
		time1 = s1.getDouble("time");
		time2 = s2.getDouble("time");			
		if(time1 == time2) {
		JSONArray a1 = s1.getJSONArray("bodies");
		JSONArray a2 = s2.getJSONArray("bodies");	
		if(a1.length() != a2.length()) return false ;
		
			for(int i = 0; i < a1.length() ; i++) { //solo necesita 1for 
				
				
				JSONObject b1 = a1.getJSONObject(i);
				JSONObject b2 = a2.getJSONObject(i);	
				
				if(!b1.get("id").equals(b2.get("id"))) return false ;
				if(Math.abs(b1.getDouble("m")- b2.getDouble("m")) > eps ) return false ;
				else {
					JSONArray p1 = b1.getJSONArray("p") ; //ponemos como un JSONArray 
					Vector2D pf1 = new Vector2D(p1.getDouble(0), p1.getDouble(1) );			 //creamos un vector con las 2 coordenadas .
					JSONArray p2 = b2.getJSONArray("p") ; //ponemos como un JSONArray 
					Vector2D pf2 = new Vector2D(p2.getDouble(0), p2.getDouble(1) );			 //creamos un vector con las 2 coordenadas .					
					if(pf1.distanceTo(pf2) > eps ) return false ;
					
					p1 = b1.getJSONArray("v") ; //ponemos como un JSONArray 
					pf1 = new Vector2D(p1.getDouble(0), p1.getDouble(1) );			 
					p2 = b2.getJSONArray("v") ; //ponemos como un JSONArray 
					pf2 = new Vector2D(p2.getDouble(0), p2.getDouble(1) );								
					if(pf1.distanceTo(pf2) > eps ) return false ;
					
					p1 = b1.getJSONArray("f") ; //ponemos como un JSONArray 
					pf1 = new Vector2D(p1.getDouble(0), p1.getDouble(1) );			
					p2 = b2.getJSONArray("f") ; //ponemos como un JSONArray 
					pf2 = new Vector2D(p2.getDouble(0), p2.getDouble(1) );								
					if(pf1.distanceTo(pf2) > eps ) return false ;				
					
				}							
		
			
			}		    	
		    
			
		}
		
		return true ;
	}
}
