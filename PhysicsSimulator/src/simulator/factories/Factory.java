package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public interface Factory<T> {
	public T createInstance(JSONObject info) throws Exception;

	public List<JSONObject> getInfo();
	
}
