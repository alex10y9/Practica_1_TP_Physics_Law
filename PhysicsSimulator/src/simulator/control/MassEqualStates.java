package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

public class MassEqualStates implements StateComparator{

	
	public MassEqualStates() {
		
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
		
			for(int i = 0; i < a1.length() ; i++) { 		
				
				JSONObject b1 = a1.getJSONObject(i);
				JSONObject b2 = a2.getJSONObject(i);	
				
				if(!b1.getString("id").equalsIgnoreCase(b2.getString("id")) || b1.getDouble("m") != b2.getDouble("m")) return false ;
			
			}		
			
		}
		else {
			return false ;
		}
		
		return true ;
	}
	
}
