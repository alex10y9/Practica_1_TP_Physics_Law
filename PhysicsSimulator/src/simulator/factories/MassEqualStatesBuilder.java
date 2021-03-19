package simulator.factories;

import org.json.JSONObject;

public class MassEqualStatesBuilder<StateComparator> extends Builder<StateComparator>{

	@Override
	public StateComparator createInstance() {
		// TODO Auto-generated method stub
		return null;
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
