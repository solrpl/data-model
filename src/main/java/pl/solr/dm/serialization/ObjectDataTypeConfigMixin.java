package pl.solr.dm.serialization;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import pl.solr.dm.DataType;

public class ObjectDataTypeConfigMixin {
	@JsonProperty
	private Map<String, DataType> fields;
}
