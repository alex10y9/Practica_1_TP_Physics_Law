package simulator.model;

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
	
	
}
