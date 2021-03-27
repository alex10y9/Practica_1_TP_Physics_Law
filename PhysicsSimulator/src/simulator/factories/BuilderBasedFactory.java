package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T>{

	private List<Builder<T>> builders ;	
	
	public BuilderBasedFactory(List<Builder<T>> builders) {		
		this.builders = builders ;
	}
	
	@Override
	public T createInstance(JSONObject o) throws Exception {
		
		if(o != null ) {
			for(Builder<T> b: this.builders) {
				T object = b.createInstance(o);
				if(object != null) {
					return object;
				}
				
			}
		}
		throw new IllegalArgumentException("Error, JSON recibido incorrecto");	
	}

	@Override
	public List getInfo() {
		
		List array = new ArrayList();
		
		for(Builder<T> b: this.builders) {
			array.add(b.getBuilderInfo());
		}
	
		return array;
	}

}
