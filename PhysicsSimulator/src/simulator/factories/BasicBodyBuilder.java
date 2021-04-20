package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

	
	public BasicBodyBuilder() {
		super("basic", "Default Body");
	}
	
	@Override
	public Body createTheInstance(JSONObject info) throws Exception{
		
		String id = info.getString("id");
		double m = info.getDouble("m");
		JSONArray parray = info.getJSONArray("p");
		JSONArray varray = info.getJSONArray("v");
		
		if(parray.length() != 2 || varray.length() != 2) {
			
			throw new Exception("Cuidado, el tamaño de los vectores es distinto de 2, que son v y p ");
			
		}
		
		Vector2D p = new Vector2D(parray.getDouble(0), parray.getDouble(1)) ; 
				
		Vector2D v = new Vector2D(varray.getDouble(0), varray.getDouble(1));
		
		Body b = new Body(id , v, p, m);
		return b;

		
	}

	public JSONObject createData() {
		
		JSONObject b = new JSONObject();
		
		b.put("id", "b1");
		b.put("p", (new Vector2D()).asJSONArray());
		b.put("v", (new Vector2D()).asJSONArray());
		b.put("m", 5.97e24);

		return b;
	}

	
}
