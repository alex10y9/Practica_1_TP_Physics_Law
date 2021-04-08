package simulator.factories;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Builder<T>  {
	
	protected String typeTag;
	protected String desc; 
	
	public Builder(String t, String d) {
		typeTag = t;
		desc = d;
	}

	public abstract T createInstance(JSONObject o) throws Exception ;
	
	public abstract JSONObject createData();
	
	public T createTheInstance(JSONObject o) throws JSONException, Exception {
		T b= null ;
		if(typeTag != null && typeTag.equals(o.getString("type")))
			b = createInstance(o.getJSONObject("data"));
		return b ;
	}
	
	public JSONObject getBuilderInfo() {
		JSONObject info = new JSONObject();
		info.put("type", typeTag);
		info.put("data", createData());
		info.put("desc", desc);
		return info ;
	}
	
	
}
