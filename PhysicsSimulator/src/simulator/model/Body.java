package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class Body {
	protected String id;
	protected Vector2D v ; //velocity
	protected Vector2D f ; //Force
	protected Vector2D p ; //position
	protected double m ; //mass
	
	public Body (String id,Vector2D v, Vector2D p, double m ) {
		this.id = id;
		this.v = v;
		this.p = p;
		this.m = m;
		this.f = new Vector2D();
	}
	
	
	void addForce(Vector2D f) {
		this.f.plus(f);		
	}
	
	void move(double t) {
		Vector2D a ;
		
		if(m == 0) {
			a = new Vector2D();
		}
		else {
			a = f.scale(1/m) ;
		}
			
		p.plus(v.scale(t));
		p.plus(a.scale((t*t)/2));
		
		v.plus(a.scale(t)) ;			

	}
	
	public JSONObject getState() {
		
		JSONObject a ;
		a.
		return {"id": id, "m": m, "p": p, "v": v, "f" : f} ;
		
	}
	
	public String toString() {
		return getState().toString();
	}
	
	void resetForce() { //reseting force vector
		this.f = new Vector2D();
	}
	
	//getters 
	public String getId() {
		return id;
	}

	public Vector2D getV() {
		return v;
	}

	public Vector2D getF() {
		return f;
	}

	public Vector2D getP() {
		return p;
	}

	public double getM() {
		return m;
	}
	
	
}
