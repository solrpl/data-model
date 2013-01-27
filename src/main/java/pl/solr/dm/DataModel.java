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


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import pl.solr.dm.types.ObjectDataType;

/**
 * Model of generated data.
 *
 * @author negativ
 *
 */
public final class DataModel {
	/** data definition. */
	@JsonProperty
	private Map<String, DataType<?>> data = new HashMap<String, DataType<?>>();

	private DataModel() {
		// no instances except generated by me.
	}

	/**
	 * @return default builder for model
	 */
	public static DataModelBuilder builder() {
		return new DataModelBuilder();
	}

	/**
	 * Returns root object from current model.
	 * @return root object
	 */
	public ObjectDataType getValue() {
		return ObjectDataType.create(data);
	}
}
