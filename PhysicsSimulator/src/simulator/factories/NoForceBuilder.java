package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class NoForceBuilder<ForceLaws> extends Builder<ForceLaws> {

	@Override
	public ForceLaws createInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "nf");
		
		JSONObject b = new JSONObject();		

		info.put("data", b);

		return info;
	}
	
}
