package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {

	public NewtonUniversalGravitationBuilder() {
		super("nlug", "Newton gravitation ");
	}
	
	@Override
	public NewtonUniversalGravitation createInstance(JSONObject info) throws Exception {
		
		if(info.getString("type").equalsIgnoreCase("nlug")) {			
			JSONObject data = info.getJSONObject("data");
			double G = 6.67E-11 ;
			if(data.has("G")) {
				G = data.getDouble("G");
			}
								
			NewtonUniversalGravitation b = new NewtonUniversalGravitation(G);
			return b;
		}
		
		else {
			return null ;
		}
	}

	@Override
	public JSONObject createData() {
		
		JSONObject b = new JSONObject();
		b.put("G",  6.67e-11);


		return b;
	}
}
