package pl.solr.dm.producers;

import java.util.Map.Entry;

import pl.solr.dm.DataModel;
import pl.solr.dm.DataType;
import pl.solr.dm.types.ArrayDataType;
import pl.solr.dm.types.ObjectDataType;

public class SolrDataModelProducer extends DataModelProducer {

	@Override
	public String convert(DataModel model) {
		StringBuilder builder = new StringBuilder();
		builder.append("<doc>\n");
		for (Entry<String, DataType> entry : model.getValue().getValue().entrySet()) {
			processItem(builder, entry.getKey(), entry.getValue());
		}
		builder.append("</doc>\n");
		return builder.toString();
	}
	
	private void processItem(StringBuilder builder, String key, DataType type) {
		//TODO type safety
		if (type instanceof ArrayDataType) {
			processArray(builder, key , (ArrayDataType) type);
			return;
		}
		
		if (type instanceof ObjectDataType) {
			processObject(builder, key, (ObjectDataType) type);
			return;
		}
		
		appendField(builder, key, type.getValue());		
	}

	private void processArray(StringBuilder builder, String key, ArrayDataType array) {
		for (DataType item : array.getValue()) {
			processItem(builder, key, item);
		}
		
	}
	
	private void processObject(StringBuilder builder, String key, ObjectDataType object) {
		for (Entry<String, DataType> entry : object.getValue().entrySet()) {
			processItem(builder, key + "." + entry.getKey(), entry.getValue());
		}
		
	}
	
	private void appendField(StringBuilder builder, String key, Object value) {		
		builder.append("\t<field name=\"");
		builder.append(key);
		builder.append("\">");
		builder.append(value);
		builder.append("</field>\n");
	}

}
