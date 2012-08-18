package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class LongDataType extends DataType<Long> {

	@Override
	protected Long generateValue() {
		return RANDOM.nextLong();
	}

}
