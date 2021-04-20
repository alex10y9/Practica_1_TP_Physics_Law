package simulator.factories;

import org.json.JSONObject;
import simulator.model.ForceLaws;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws> {

	public NoForceBuilder() {
		super("nf", "No force ");
	}
	
	@Override
	public NoForce createTheInstance(JSONObject info) {
			
		NoForce b = new NoForce();
		return  b;
			
	}

	public JSONObject createData() {
		return null;
	}

	
}
