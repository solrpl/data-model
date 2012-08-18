package pl.solr.dm.types;

import java.util.HashMap;
import java.util.Map;

import pl.solr.dm.DataType;

public class ObjectDataType extends DataType {
	
	private Map<String, DataType> fields = new HashMap<String, DataType>();
	
	protected ObjectDataType() {
		
	}
	
	protected ObjectDataType(Map<String, DataType> fields) {
		this.fields = fields;
	}


	@Override
	public Map<String, DataType> getValue() {
		return fields;
	}

	public static ObjectDataType create(Map<String, DataType> data) {
		return new ObjectDataType(data);
	}
}
