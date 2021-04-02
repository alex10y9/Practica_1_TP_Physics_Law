package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator>{

	@Override
	public EpsilonEqualStates createInstance(JSONObject info) throws Exception{
		
		
		if(info.getString("type").equalsIgnoreCase("epseq")) {
			
			double eps = 0 ;
			
			if(info.has("eps")) {
				eps = info.getDouble("eps");
			}

			EpsilonEqualStates b = new EpsilonEqualStates(eps);
			return b;
			
		}
		
		else {
			return null ;
		}
	}


	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "epseq");
		
		JSONObject b = new JSONObject();
		b.put("eps" , 0.1 );
		
		info.put("data", b);
		info.put("desc", " ");
	
		return info;
	}

}
