package pl.solr.dm.producers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import pl.solr.dm.DataModel;
import pl.solr.dm.DataType;
import pl.solr.dm.types.ArrayDataType;
import pl.solr.dm.types.ObjectDataType;

public class SolrDataModelProducer extends DataModelProducer {
	private final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@Override
	public String convert(DataModel model) {
		StringBuilder builder = new StringBuilder();
		builder.append("<doc>\n");
		for (Entry<String, DataType<?>> entry : model.getValue().getValue().entrySet()) {
			processItem(builder, entry.getKey(), entry.getValue());
		}
		builder.append("</doc>\n");
		return builder.toString();
	}
	
	private void processItem(StringBuilder builder, String key, DataType<?> type) {
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
		for (DataType<?> item : array.getValue()) {
			processItem(builder, key, item);
		}
		
	}
	
	private void processObject(StringBuilder builder, String key, ObjectDataType object) {
		Map<String, DataType<?>> fields = object.getValue();
		if (fields == null) {
			return;
		}
		for (Entry<String, DataType<?>> entry : fields.entrySet()) {
			processItem(builder, key + "." + entry.getKey(), entry.getValue());
		}
		
	}
	
	private void appendField(StringBuilder builder, String key, Object value) {
		if (value == null) {
			return;
		}
		builder.append("\t<field name=\"");
		builder.append(key);
		builder.append("\">");
		builder.append(format(value));
		builder.append("</field>\n");
	}
	
	private String format(Object value) {
		if (value instanceof Date) {
			return FORMAT.format(value);
		}
		return value.toString();
	}

}
