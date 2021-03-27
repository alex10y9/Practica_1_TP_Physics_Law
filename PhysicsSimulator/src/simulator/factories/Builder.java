package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public abstract class Builder<T>  {
	
	public abstract T createInstance(JSONObject o) throws Exception ;
	
	public abstract JSONObject getBuilderInfo();
	
	
}
