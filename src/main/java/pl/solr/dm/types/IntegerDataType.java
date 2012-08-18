package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class IntegerDataType extends DataType<Integer> {

	@Override
	protected Integer generateValue() {
		return GENERATOR.getNumberUpTo(Integer.MAX_VALUE);
	}

}
