package simulator.factories;

import org.json.JSONObject;

public class EpsilonEqualStatesBuilder<StateComparator> extends Builder<StateComparator>{

	@Override
	public StateComparator createInstance() {
		
		return null;
	}


	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "epseq");
		
		JSONObject b = new JSONObject();
		b.put("eps" , 0.1 );
		
		info.put("data", b);
	
		return info;
	}

}
