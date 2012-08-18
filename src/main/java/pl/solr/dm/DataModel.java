package pl.solr.dm;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import pl.solr.dm.types.ObjectDataType;

public class DataModel {
	@JsonProperty
	private Map<String, DataType<?>> data = new HashMap<String, DataType<?>>();
	
	public static DataModelBuilder builder() {
		return new DataModelBuilder();
	}

	public ObjectDataType getValue() {
		return ObjectDataType.create(data);
	}
}
