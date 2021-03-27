package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;
import simulator.model.NewtonUniversalGravitation;

public class MassEqualStatesBuilder extends Builder<StateComparator>{

	@Override
	public MassEqualStates createInstance(JSONObject info) { //falta
		
		
		if(info.getString("type").equalsIgnoreCase("masseq")) {
								
			MassEqualStates b = new MassEqualStates();
			return b;
			
		}
		
		else {
			return null ;
		}
	
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "masseq");
		
		JSONObject b = new JSONObject();	
		

		info.put("data", b);

		return info;
	}

}
