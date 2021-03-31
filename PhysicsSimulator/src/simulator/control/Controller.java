package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.BuilderBasedFactory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {

	private PhysicsSimulator simulator ;
	private BuilderBasedFactory<Body> factory ;
 	
	public Controller(PhysicsSimulator sim, BuilderBasedFactory<Body> factory ) {
		this.simulator = sim;
		this.factory = factory;
		
		
	}
	
	public void loadBodies(InputStream in) {
		
		JSONObject jsonInupt = new JSONObject(new JSONTokener(in));
		JSONArray bodies = jsonInupt.getJSONArray("bodies") ;
		JSONObject obj ;
		Body b ;
		
		for(int i = 0; i < bodies.length(); i++) {
			
			obj = bodies.getJSONObject(i);
			try {
				
				b = this.factory.createInstance(obj) ;
				this.simulator.addBody(b);
				
			}
			
			catch(Exception e ){
				System.out.println("Error en load bodies de controller ");
			}
			
			
		}
		
		
		
		
	}
	
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) throws Exception {
		
		JSONObject state1, state2 ;
		JSONObject  expectedStates = new JSONObject(new JSONTokener(expOut));
		JSONArray exit = expectedStates.getJSONArray("states");
		PrintStream p = new PrintStream(out) ;
		p.println("{");
		p.println("\"states\": [");
		p.println(this.simulator.getState().toString()); //primer getState donde n no vale 0 pero indicamos el estado inciial del simulador 
		
		for (int i = 0; i < n ; i++) {
			
			simulator.advance();
			state1 = simulator.getState();
			state2 = exit.getJSONObject(i);
			if(cmp.equal(state1, state2)) {
				p.println(state1.toString());
			}
			else {
				throw new Exception("Error en el paso numero " + i + "\n" + state1.toString() + "\n" + state2.toString());
			}
			
			
		}
		
		p.println("]");
		p.println("}");
		
		
	}
	
	
}
