package pl.solr.dm.producers;

import org.codehaus.jackson.map.ObjectMapper;

import pl.solr.dm.types.ObjectDataType;

public class JsonDataModelProducer extends DataModelProducer {

	public String convert(ObjectDataType object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
