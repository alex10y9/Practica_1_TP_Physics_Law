package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator>{
	
	public MassEqualStatesBuilder() {
		super("masseq", "Mass equal state ");
	}
	
	@Override
	public MassEqualStates createTheInstance(JSONObject info) { //falta

								
		MassEqualStates b = new MassEqualStates();
		return b;

	}

	@Override
	public JSONObject createData() {
		return null;
	}

}
