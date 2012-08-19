/**
 * Copyright 2012 Solr.pl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.solr.dm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.Test;

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
		
		DataModel.builder()
				.fromJson(bais);
	}

}
