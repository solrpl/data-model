/**
 * Copyright 2012,2013 Solr.pl
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import pl.solr.dm.producers.JsonDataModelProducer;
import pl.solr.dm.producers.SolrDataModelProducer;
import pl.solr.dm.types.ArrayDataType;
import pl.solr.dm.types.DateDataType;
import pl.solr.dm.types.IdentifierDataType;
import pl.solr.dm.types.ObjectDataType;

public class DataModelTest {
	
	@Test
	public void unserialize() {
		DataModel model = DataModel.builder().fromJson(DataModelTest.class.getResourceAsStream("/input.json"));
		assertEquals("1", model.getValue().getIdentifier());
		
		DataType<?> id = model.getValue().getValue().get("id");
		assertTypeAndNotNull(id, IdentifierDataType.class);

		DataType<?> created = model.getValue().getValue().get("created"); 
		assertTypeAndNotNull(created, DateDataType.class);
		
		DataType<?> tags = model.getValue().getValue().get("tags");
		assertTypeAndNotNull(tags, ArrayDataType.class);
		
		DataType<?> position = model.getValue().getValue().get("position");
		if (position != null) { //probability 50%
			assertTypeAndNotNull(position, ObjectDataType.class);
			try {
				((ObjectDataType) position).getIdentifier();
				fail("getIdentifier() should throw exception");
			} catch (RuntimeException re) {
				assertTrue(true); //It's ok
			}
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(new JsonDataModelProducer().convert(model.getValue()));
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(new SolrDataModelProducer().convert(model.getValue()));
		}
	}
	

	@Test
	public void unserializeToJsonWithNull() {
		DataModel model = DataModel.builder().fromJson(
				DataModelTest.class.getResourceAsStream("/null.json"));
		System.err.println(new JsonDataModelProducer().convert(model.getValue()));
		assertTrue("Field should not be available in json", !new JsonDataModelProducer().convert(model.getValue()).contains("field"));		
		System.err.println(new JsonDataModelProducer().convert(model.getValue()));
		assertTrue("Field should not be available in json", !new JsonDataModelProducer().convert(model.getValue()).contains("field"));		

	}
	
	@Test(expected = RuntimeException.class)
	public void unserializeWithError() {
		ByteArrayInputStream bais = new ByteArrayInputStream("{ syntax_error: }".getBytes());
		
		DataModel.builder()
				.fromJson(bais);
	}

	private void assertTypeAndNotNull(DataType<?> obj, Class<?> type) {
		assertNotNull(obj);
		assertTrue("obj: " + obj + " should have type: " + type, obj.getClass().equals(type));
	}
}
