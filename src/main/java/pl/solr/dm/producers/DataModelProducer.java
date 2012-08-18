package pl.solr.dm.producers;

import pl.solr.dm.DataModel;

public abstract class DataModelProducer {
	public abstract String convert(DataModel model);
}
