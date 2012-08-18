package pl.solr.dm;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.StringBufferInputStream;

import org.junit.Test;

import pl.solr.dm.DataModel;
import pl.solr.dm.producers.JsonDataModelProducer;
import pl.solr.dm.producers.SolrDataModelProducer;
import pl.solr.dm.types.ArrayDataType;

public class DataModelTest {
	
	@Test
	public void unserialize() {
		DataModel model = DataModel.builder().fromJson(DataModelTest.class.getResourceAsStream("/input.json"));
		assertNotNull(model.getValue().getValue().get("id"));
		assertNotNull(model.getValue().getValue().get("created"));
		DataType<?> tags = model.getValue().getValue().get("tags");
		assertNotNull(tags);
		assertTrue(tags instanceof ArrayDataType);
		for (int i = 0; i < 3; i++) {
			System.err.println(new JsonDataModelProducer().convert(model.getValue()));
		}
		for (int i = 0; i < 3; i++) {
			System.err.println(new SolrDataModelProducer().convert(model.getValue()));
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void unserializeWithError() {
		ByteArrayInputStream bais = new ByteArrayInputStream("{ syntax_error: }".getBytes());
		
		DataModel model = DataModel.builder()
				.fromJson(bais);
	}

}
