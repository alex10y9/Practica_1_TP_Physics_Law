package simulator.control;

import org.json.JSONObject;

public class NotEqualException extends Exception{
	
	public NotEqualException(JSONObject expectedState, JSONObject currentState, int n) {		
		
		super("El estado esperado es : " + expectedState.toString() + " y tu estado es : " + currentState.toString() + ", fallas en el paso numero :" +  n);
		
	}

}
