package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MassLossingBody;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws> {

	public NoForceBuilder() {
		super("nf", "No force ");
	}
	
	@Override
	public NoForce createInstance(JSONObject info) {
		
		if(info.getString("type").equalsIgnoreCase("nf")) {
			
			NoForce b = new NoForce();
			return  b;
			
		}
		
		else {
			return null;
		}
	}

	
}
