package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPointBuilder<ForceLaws> extends Builder<ForceLaws>{

	@Override
	public Object createInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getBuilderInfo() {
		
		JSONObject info = new JSONObject();
		info.put("type", "mtcp");
		
		JSONObject b = new JSONObject();
		b.put("c", (new Vector2D()).asJSONArray());
		b.put("g", 9.81);
		
		info.put("data", b);

		return info;
	}
	

}
