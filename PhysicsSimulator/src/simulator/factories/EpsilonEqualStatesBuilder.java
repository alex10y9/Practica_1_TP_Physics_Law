package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator>{

	
	public EpsilonEqualStatesBuilder() {
		super("epseq", "Epsilon state ");
	}
	
	@Override
	public EpsilonEqualStates createTheInstance(JSONObject info) throws Exception{

			
		double eps = 0.0 ;
		
		if(info.has("eps")) {
			eps = info.getDouble("eps");
		}

		EpsilonEqualStates b = new EpsilonEqualStates(eps);
		return b;

	}


	@Override
	public JSONObject createData() {	
		JSONObject b = new JSONObject();
		b.put("eps" , 0.1 );
	
		return b;
	}

}
