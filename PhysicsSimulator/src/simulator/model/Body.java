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
		this.f = this.f.plus(f);		
	}
	
	void move(double t) {
		Vector2D a ;
		
		if(m == 0) {
			a = new Vector2D();
		}
		else {
			a = f.scale(1.0/m) ;
		}
			
		p = p.plus(v.scale(t).plus(a.scale(0.5 * t * t)));
		v = v.plus(a.scale(t));	

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Body other = (Body) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public JSONObject getState() { //puede estar mal 
		
		JSONObject a = new JSONObject() ;
		a.put("id", id);
		a.put("m", m);
		a.put("p", p.asJSONArray());
		a.put("v", v.asJSONArray());
		a.put("f", f.asJSONArray());
		return a ;
		
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

	public Vector2D getVelocity() {
		return new Vector2D(v);
	}

	public Vector2D getForce() {
		return new Vector2D(f);
	}

	public Vector2D getPosition() {
		return new Vector2D(p);
	}

	public double getMass() {
		return m;
	}
	
	
}
