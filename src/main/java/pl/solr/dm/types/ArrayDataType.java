package pl.solr.dm.types;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import pl.solr.dm.DataType;

public class ArrayDataType extends DataType {
	@JsonProperty
	private DataType subtype;
	
	@JsonProperty
	private int size;

	@Override
	public List<DataType> getValue() {
		List<DataType> result = new ArrayList<DataType>();
		for (int i = 0; i < size; i++) {
			result.add(subtype);
		}
		return result;
	}
}
