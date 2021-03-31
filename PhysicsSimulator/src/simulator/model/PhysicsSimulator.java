package simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {

	private double realTime ;
	private double timePerStep ;
	ForceLaws actualForce ;
	private List<Body> bodies ;
	
	public PhysicsSimulator(double rt, ForceLaws forceApp ) {
		realTime = 0.0 ;
		timePerStep = rt ;
		actualForce = forceApp ;
		if(forceApp == null ) {
			throw new IllegalArgumentException();
		}
		bodies = new ArrayList<Body>();
		
	}
	
	public void advance() {
		
		for(Body b : bodies) {
			b.resetForce();			
		}
		actualForce.apply(bodies);
		for(Body b : bodies) {
			if(timePerStep <= 0.0) { 
				throw new IllegalArgumentException();
			}
			b.move(timePerStep);			
		}
		realTime += timePerStep;
		
	}
	
	public void addBody(Body b ) {
		
		boolean correct = true ;
		for(Body b1: bodies) {
			if(b1.getId() == b.getId()) {
				correct = false ;
			}
		}
		
		if(correct)	bodies.add(b);
		else {
			throw new IllegalArgumentException();
		}
	
		
	}
	
	public JSONObject getState() {
		JSONObject a = new JSONObject() ;
		JSONArray a1 = new JSONArray();
		
		for(Body b: bodies) {
			JSONObject aux = b.getState() ;
			a1.put(aux);			
		}
		
		a.put("time", realTime);
		a.put("bodies", a1 );
		return a ;
		
	}
	
	public String toString() {
		
		return getState().toString();
		
	}
	
}
