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
			
			JSONObject data = info.getJSONObject("data");
			
			double gravity ;
			if(data.has("g")) {
				 gravity = data.getDouble("g");
			}
			else {
				 gravity = 9.81 ;
			}
			
			Vector2D c;
			
			if(data.has("c")) {
				JSONArray carray = data.getJSONArray("c");
				
				if(carray.length() != 2) {
					
					throw new Exception("Cuidado, el tamaño del vector es distinto de 2, array c  ");
					
				}
				c = new Vector2D(carray.getDouble(0), carray.getDouble(1)) ; 
			}

			else {
				c = new Vector2D();
			}

								
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
		info.put("desc", " ");

		return info;
	}
	

}
