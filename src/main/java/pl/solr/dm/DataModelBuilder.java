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

import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;

import pl.solr.dm.serialization.DataTypeConfigMixin;
import pl.solr.dm.serialization.ObjectDataTypeConfigMixin;
import pl.solr.dm.types.ObjectDataType;

/**
 * Default builder for data model.
 * This builder can create data model from JSON definition
 *
 * @author negativ
 *
 */
public class DataModelBuilder {

	protected DataModelBuilder() {
		
	}

	/**
	 * Create data model definition from JSON file.
	 * @param resource resource with JSON definition
	 * @return created data model
	 * @throws RuntimeException when definition is incorrect or there is a i/o problem with stream
	 */
	public final DataModel fromJson(final InputStream resource) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig()
			.addMixInAnnotations(DataType.class, DataTypeConfigMixin.class);
		mapper.getDeserializationConfig()
			.addMixInAnnotations(ObjectDataType.class, ObjectDataTypeConfigMixin.class);
		try {
			return mapper.readValue(resource, DataModel.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
