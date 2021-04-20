package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body>{

	public MassLosingBodyBuilder() {
		super("mlb", "Mass lossing body ");
	}
	
	@Override
	public MassLossingBody createTheInstance(JSONObject info) throws Exception {
			
			String id = info.getString("id");
			double m = info.getDouble("m");
			double lfac = info.getDouble("factor");
			double lfreq = info.getDouble("freq");
			JSONArray parray = info.getJSONArray("p");
			JSONArray varray = info.getJSONArray("v");
			
			if(parray.length() != 2 || varray.length() != 2) {
				
				throw new Exception("Cuidado, el tamaño de los vectores es distinto de 2, que son v y p ");
				
			}
			
			Vector2D p = new Vector2D(parray.getDouble(0), parray.getDouble(1)) ; 
					
			Vector2D v = new Vector2D(varray.getDouble(0), varray.getDouble(1));
			
			MassLossingBody b = new MassLossingBody(id , v, p, m, lfac, lfreq);
			return  b;
		
	}

	@Override
	public JSONObject createData() {
		
		JSONObject b = new JSONObject();
		b.put("id", "b1");
		b.put("p", (new Vector2D()).asJSONArray());
		b.put("v", (new Vector2D()).asJSONArray());
		b.put("m", 5.97e24);
		b.put("freq",  1e3);
		b.put("factor", 1e-3);		


		return b;
	}
	
	
	
}
