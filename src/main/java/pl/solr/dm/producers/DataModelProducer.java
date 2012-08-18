package pl.solr.dm.producers;

import pl.solr.dm.types.ObjectDataType;

public abstract class DataModelProducer {
	public abstract String convert(ObjectDataType object);
}
