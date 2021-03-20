package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitationBuilder<ForceLaws> extends Builder<ForceLaws> {

	@Override
	public ForceLaws createInstance(JSONObject o) {
	
		return null;
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "nlug");
		
		JSONObject b = new JSONObject();
		b.put("G",  6.67e10-11);
		
		info.put("data", b);

		return info;
	}
}
