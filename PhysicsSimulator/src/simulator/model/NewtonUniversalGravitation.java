package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws{
	
	public double G;

	public NewtonUniversalGravitation(double g) {
		G = g;
	}

	@Override
	public void apply(List<Body> bodies) {

/* private Vector2D force(Body a, Body b) {
    Vector2D delta = b.getPosition().minus(a.getPosition());
    double dist = delta.magnitude();
    double magnitude = dist>0 ? (_G * a.getMass() * b.getMass()) / (dist * dist) : 0.0;
    return delta.direction().scale(magnitude);*/
				
		for(Body b1 : bodies) {
			Vector2D Fij;
			for(Body b2 : bodies) {				
				
				if(!b1.equals(b2)) {
					
					if(b1.getPosition().distanceTo(b2.getPosition()) == 0 || b1.getMass() == 0 || b2.getMass() == 0) {
						
					}
					else {
						Vector2D dir = b2.getPosition().minus(b1.getPosition());						
						
						double fij = G * ((b1.getMass() * b2.getMass()) / Math.pow(dir.magnitude(), 2) );        //formula
						dir = dir.direction();
						Fij = dir.scale(fij);
						
						b1.addForce(Fij);
					}
				
				}
			
				
			}
		
		}
		
		
	}	
	
	public String toString() {
		return  "Moving with constant aceleration " + G ;
	}
	
}

