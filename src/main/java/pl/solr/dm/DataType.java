package pl.solr.dm;

import java.util.Random;

import org.codehaus.jackson.annotate.JsonValue;
import org.fluttercode.datafactory.impl.DataFactory;


public abstract class DataType<T> {
	protected static DataFactory GENERATOR = new DataFactory();
	protected static Random RANDOM = new Random();
	
	private int probability = 100;

	static {
		GENERATOR.randomize((int) System.currentTimeMillis());
	}


	@JsonValue
	public final T getValue() {
		if (RANDOM.nextInt(100) < probability) {
			return generateValue();
		}
		return null;
	}
	
	protected abstract T generateValue();
}
