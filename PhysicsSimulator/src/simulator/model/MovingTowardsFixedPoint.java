package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws{

	private double gravity ;
	Vector2D centre ;
	
	public MovingTowardsFixedPoint(Vector2D c , double g) {
		gravity = g ;
		centre = new Vector2D(c);	
	}
	
	@Override
	public void apply(List<Body> bodies) {
		
		for(Body b1 : bodies) {
				
			b1.addForce(centre.minus(b1.getPosition()).direction().scale(gravity * b1.getMass()));
		}
		
	}
	
	public String toString() {
		return  "Moving towards " + centre + " with constant aceleration " + gravity;
	}

}

	
	/*		//a: −g · ~di
			//f = m * a 
			Vector2D Fg ;
			Vector2D dir = new Vector2D(); 
			Vector2D centre = new Vector2D(); 
			dir = b1.getPosition().minus(centre); //direccion de la fuerza
			Fg = dir.direction().scale(-1 * gravity);			
		
			b1.addForce(Fg);
			
	*/