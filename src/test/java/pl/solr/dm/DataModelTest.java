package pl.solr.dm;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.solr.dm.DataModel;
import pl.solr.dm.producers.JsonDataModelProducer;
import pl.solr.dm.producers.SolrDataModelProducer;

public class DataModelTest {
	
	@Test
	public void unserialize() {
		DataModel model = DataModel.builder().fromJson(DataModelTest.class.getResourceAsStream("/input.json"));
		for (int i = 0; i < 10; i++) {
			System.err.println(new JsonDataModelProducer().convert(model));
		}
		for (int i = 0; i < 10; i++) {
			System.err.println(new SolrDataModelProducer().convert(model));
		}
	}

}
