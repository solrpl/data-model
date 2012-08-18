package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class LongDataType extends DataType {

	@Override
	protected Object generateValue() {
		return RANDOM.nextLong();
	}

}
