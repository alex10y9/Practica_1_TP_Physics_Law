package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{

	public MovingTowardsFixedPointBuilder() {
		super("mtfp", "Moving toward fixed point  ");
	}
	
	@Override
	public MovingTowardsFixedPoint createTheInstance(JSONObject info) throws Exception {
			
		double gravity ;
		if(info.has("g")) {
			 gravity = info.getDouble("g");
		}
		else {
			 gravity = 9.81 ;
		}
		
		Vector2D c;
		
		if(info.has("c")) {
			JSONArray carray = info.getJSONArray("c");
			
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

	@Override
	public JSONObject createData() {
		
		JSONObject b = new JSONObject();
		b.put("c", (new Vector2D()).asJSONArray());
		b.put("g", 9.81);


		return b;
	}
	

}
