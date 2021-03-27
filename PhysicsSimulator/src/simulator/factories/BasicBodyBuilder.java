package simulator.factories;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class BasicBodyBuilder extends Builder<Body> {

	@Override
	public Body createInstance(JSONObject info) throws Exception{
		
		if(info.getString("type").equalsIgnoreCase("basic")) {
			
			String id = info.getString("id");
			double m = info.getDouble("m");
			
			JSONObject data = info.getJSONObject("data");
			
			JSONArray parray = data.getJSONArray("p");
			JSONArray varray = data.getJSONArray("v");
			
			if(parray.length() != 2 || varray.length() != 2) {
				
				throw new Exception("Cuidado, el tamaño de los vectores es distinto de 2, que son v y p ");
				
			}
			
			Vector2D p = new Vector2D(parray.getDouble(0), parray.getDouble(1)) ; 
					
			Vector2D v = new Vector2D(varray.getDouble(0), varray.getDouble(1));
			
			Body b = new Body(id , v, p, m);
			return b;
			
		}
		
		else {
			return null;
		}
		
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "basic");
		
		JSONObject b = new JSONObject();
		b.put("id", "b1");
		b.put("p", (new Vector2D()).asJSONArray());
		b.put("v", (new Vector2D()).asJSONArray());
		b.put("m", 5.97e24);
		
		info.put("data", b);

		return info;
	}

	
}
