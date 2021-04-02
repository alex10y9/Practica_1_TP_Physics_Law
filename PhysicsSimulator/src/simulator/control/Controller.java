package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.BuilderBasedFactory;
import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {

	private PhysicsSimulator simulator ;
	private Factory<Body> bodyFactories ;
 	
	public Controller(PhysicsSimulator sim, Factory<Body> factory ) {
		this.simulator = sim;
		this.bodyFactories = factory;
		
		
	}
	
	public void loadBodies(InputStream in) {
		
		JSONObject jsonInupt = new JSONObject(new JSONTokener(in));
		JSONArray bodies = jsonInupt.getJSONArray("bodies") ;
		JSONObject obj ;
		Body b ;
		
		for(int i = 0; i < bodies.length(); i++) {
			
			obj = bodies.getJSONObject(i);
			try {
				
				b = this.bodyFactories.createInstance(obj) ;
				this.simulator.addBody(b);
				
			}
			
			catch(Exception e ){
				System.out.println("Error en load bodies de controller ");
			}
			
			
		}
		
		
		
		
	}
	
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) throws Exception {
		
		JSONObject state1, state2 ;
		JSONArray exit= null ;
		if(expOut != null)
		{
			JSONObject  expectedStates = new JSONObject(new JSONTokener(expOut));
			exit= expectedStates.getJSONArray("states");
		}		


		PrintStream p = new PrintStream(out) ;
		p.println("{");
		p.println("\"states\": [");
		p.println(this.simulator.getState().toString()); //primer getState donde n no vale 0 pero indicamos el estado inciial del simulador 
		
		for (int i = 1; i <= n ; i++) {
			
			simulator.advance();
			state1 = simulator.getState();
			if(expOut != null ) {
				state2 = exit.getJSONObject(i);
				if(!cmp.equal(state1, state2)) {
					throw new Exception("Error en el paso numero " + i + "\n" + state1.toString() + "\n" + state2.toString());
				}
		
			}
			p.println("," + state1.toString());
			
			
		}
		
		p.println("]");
		p.println("}");
		
		
	}
	
	
}
