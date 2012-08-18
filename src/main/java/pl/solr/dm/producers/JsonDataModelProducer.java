package pl.solr.dm.producers;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pl.solr.dm.DataModel;

public class JsonDataModelProducer extends DataModelProducer {

	public String convert(DataModel model) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(model.getValue());
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
