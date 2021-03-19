package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body {

	private double lossFactor ;
	private double lossFrequency ;
	private double accumulatedTime;
	
	public MassLossingBody(String id, Vector2D v, Vector2D p, double m, double lfac, double lfreq) {
		super(id, v, p, m);
		this.lossFactor = lfac ;
		this.lossFrequency = lfreq ;
		accumulatedTime = 0.0 ;
	}

	public void move (double t) {
		super.move(t);
		accumulatedTime += t ;
		
		if( accumulatedTime >= lossFrequency ) {
			m = (m* (1 - lossFactor)) ;
			accumulatedTime = 0.0 ;
		}
		
	}
	
	public JSONObject getState() {
		
		JSONObject a = new JSONObject() ;
		a.put("id", id);
		a.put("m", m);
		a.put("p", p);
		a.put("f", f);
		a.put("freq",lossFrequency );
		a.put("factor",lossFactor );
		return a ;
		
	}
	
	public String toString() {
		
		return getState().toString();
		
	}
	
}
