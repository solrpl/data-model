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
package pl.solr.dm.serialization;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import pl.solr.dm.types.ArrayDataType;
import pl.solr.dm.types.DateDataType;
import pl.solr.dm.types.IdentifierDataType;
import pl.solr.dm.types.IntegerDataType;
import pl.solr.dm.types.LongDataType;
import pl.solr.dm.types.ObjectDataType;
import pl.solr.dm.types.StringDataType;

@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(name = "identifier", value = IdentifierDataType.class),
	@JsonSubTypes.Type(name = "array", value = ArrayDataType.class),
	@JsonSubTypes.Type(name = "long", value = LongDataType.class),
	@JsonSubTypes.Type(name = "integer", value = IntegerDataType.class),
	@JsonSubTypes.Type(name = "string", value = StringDataType.class),
	@JsonSubTypes.Type(name = "date", value = DateDataType.class),
	@JsonSubTypes.Type(name = "object", value = ObjectDataType.class)
})
public class DataTypeConfigMixin {
	@JsonProperty
	private int probability;
}
