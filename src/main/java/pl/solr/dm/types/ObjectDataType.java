package pl.solr.dm.types;

import java.util.HashMap;
import java.util.Map;

import pl.solr.dm.DataType;

public class ObjectDataType extends DataType<Map<String, DataType<?>>> {
	
	private Map<String, DataType<?>> fields = new HashMap<String, DataType<?>>();
	
	protected ObjectDataType() {
		
	}
	
	public String getIdentifier() {
		for( DataType<?> data : fields.values()) {
			if (data instanceof IdentifierDataType) {
				return (String) data.getValue();
			}
		}
		throw new RuntimeException("Data Object have no identifier field.");
	}
	
	protected ObjectDataType(Map<String, DataType<?>> fields) {
		this.fields = fields;
	}


	@Override
	protected Map<String, DataType<?>> generateValue() {
		return fields;
	}

	public static ObjectDataType create(Map<String, DataType<?>> data) {
		return new ObjectDataType(data);
	}
}
