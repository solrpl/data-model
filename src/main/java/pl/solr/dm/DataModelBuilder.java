package pl.solr.dm;

import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;

import pl.solr.dm.serialization.DataTypeConfigMixin;
import pl.solr.dm.serialization.ObjectDataTypeConfigMixin;
import pl.solr.dm.types.ObjectDataType;

public class DataModelBuilder {

	protected DataModelBuilder() {
		
	}

	public DataModel fromJson(final InputStream resource) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig().addMixInAnnotations(DataType.class, DataTypeConfigMixin.class);
		mapper.getDeserializationConfig().addMixInAnnotations(ObjectDataType.class, ObjectDataTypeConfigMixin.class);
		try {
			return mapper.readValue(resource, DataModel.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
