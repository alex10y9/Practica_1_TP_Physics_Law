package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {

	@Override
	public NewtonUniversalGravitation createInstance(JSONObject info) throws Exception {
		
		if(info.getString("type").equalsIgnoreCase("nlug")) {
			
			double m = info.getDouble("m");
			
			JSONObject data = info.getJSONObject("data");
			double G = data.getDouble("G");
								
			NewtonUniversalGravitation b = new NewtonUniversalGravitation(G);
			return b;
		}
		
		else {
			return null ;
		}
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
