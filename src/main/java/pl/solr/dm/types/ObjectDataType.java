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
package pl.solr.dm.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	public Map<String, DataType<?>> getValue() {
		return filteredFields(fields);
	}

	public static ObjectDataType create(Map<String, DataType<?>> data) {
		return new ObjectDataType(data);
	}
	
	private Map<String, DataType<?>> filteredFields(Map<String, DataType<?>> fields) {
		Map<String, DataType<?>> filtered = new HashMap<String, DataType<?>>();
		for (Entry<String, DataType<?>> entry : fields.entrySet()) {
			if (entry.getValue().exists()) {
				filtered.put(entry.getKey(), entry.getValue());
			}
		}
		return filtered;
	}
}
