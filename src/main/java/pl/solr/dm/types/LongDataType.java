package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class LongDataType extends DataType {

	@Override
	public Object getValue() {
		return RANDOM.nextLong();
	}

}
