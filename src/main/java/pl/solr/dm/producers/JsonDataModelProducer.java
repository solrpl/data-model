package pl.solr.dm.producers;

import org.codehaus.jackson.map.ObjectMapper;

import pl.solr.dm.DataModel;

public class JsonDataModelProducer extends DataModelProducer {

	public String convert(DataModel model) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(model.getValue());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
