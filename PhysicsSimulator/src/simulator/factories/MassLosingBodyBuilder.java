package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body>{

	@Override
	public MassLossingBody createInstance(JSONObject info) {
		
		if(info.getString("type").equalsIgnoreCase("basic")) {
			
			String id = info.getString("id");
			double m = info.getDouble("m");
			double lfac = info.getDouble("factor");
			double lfreq = info.getDouble("freq");
			
			JSONObject data = info.getJSONObject("data");
			
			JSONArray parray = data.getJSONArray("p");
			JSONArray varray = data.getJSONArray("v");
			
			if(parray.length() != 2 || varray.length() != 2) {
				
				throw new Exception("Cuidado, el tamaño de los vectores es distinto de 2, que son v y p ");
				
			}
			
			Vector2D p = new Vector2D(parray.getDouble(0), parray.getDouble(1)) ; 
					
			Vector2D v = new Vector2D(varray.getDouble(0), varray.getDouble(1));
			
			MassLossingBody b = new MassLossingBody(id , v, p, m, lfac, lfreq);
			return  b;
			
		}
		
		else {
			return null;
		}
		
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "mlb");
		
		JSONObject b = new JSONObject();
		b.put("id", "b1");
		b.put("p", (new Vector2D()).asJSONArray());
		b.put("v", (new Vector2D()).asJSONArray());
		b.put("m", 5.97e24);
		b.put("freq",  1e3);
		b.put("factor", 1e-3);		
		info.put("data", b);

		return info;
	}
	
	
	
}
