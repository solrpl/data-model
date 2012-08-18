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
