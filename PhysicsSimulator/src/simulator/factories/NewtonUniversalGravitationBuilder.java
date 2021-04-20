package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {

	public NewtonUniversalGravitationBuilder() {
		super("nlug", "Newton gravitation ");
	}
	
	@Override
	public NewtonUniversalGravitation createTheInstance(JSONObject info) throws Exception {

		double G = 6.67E-11 ;
		if(info.has("G")) {
			G = info.getDouble("G");
		}
							
		NewtonUniversalGravitation b = new NewtonUniversalGravitation(G);
		return b;
	
	}

	@Override
	public JSONObject createData() {
		
		JSONObject b = new JSONObject();
		b.put("G",  6.67e-11);


		return b;
	}
}
