package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;
import simulator.model.NewtonUniversalGravitation;

public class MassEqualStatesBuilder extends Builder<StateComparator>{
	
	public MassEqualStatesBuilder() {
		super("masseq", "Mass equal state ");
	}
	
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

}
