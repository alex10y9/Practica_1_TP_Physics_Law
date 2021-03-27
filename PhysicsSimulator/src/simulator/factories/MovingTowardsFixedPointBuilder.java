package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{

	@Override
	public MovingTowardsFixedPoint createInstance(JSONObject info) throws Exception {
		
		if(info.getString("type").equalsIgnoreCase("mtfp")) {
			double m = info.getDouble("m");
			
			JSONObject data = info.getJSONObject("data");
			double gravity = data.getDouble("g");
			
			JSONArray carray = data.getJSONArray("c");
			
			if(carray.length() != 2) {
				
				throw new Exception("Cuidado, el tamaño del vector es distinto de 2, array c  ");
				
			}
			
			Vector2D c = new Vector2D(carray.getDouble(0), carray.getDouble(1)) ; 
								
			MovingTowardsFixedPoint b = new MovingTowardsFixedPoint(c, gravity);
			return b;
		}
		
		else {
			return null ;
		}
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "mtfp");
		
		JSONObject b = new JSONObject();
		b.put("c", (new Vector2D()).asJSONArray());
		b.put("g", 9.81);
		
		info.put("data", b);

		return info;
	}
	

}
