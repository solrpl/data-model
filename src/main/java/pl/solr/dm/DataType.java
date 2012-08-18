package pl.solr.dm;

import java.util.Random;

import org.codehaus.jackson.annotate.JsonValue;
import org.fluttercode.datafactory.impl.DataFactory;


public abstract class DataType {
	protected static DataFactory GENERATOR = new DataFactory();
	protected static Random RANDOM = new Random();
	
	private int probability = 100;

	static {
		GENERATOR.randomize((int) System.currentTimeMillis());
	}


	@JsonValue
	public Object getValueIfNecessary() {
		if (RANDOM.nextInt(100) < probability) {
			return getValue();
		}
		return null;
	}
	
	public abstract Object getValue();
}
