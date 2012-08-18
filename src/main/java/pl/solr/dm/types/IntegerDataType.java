package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class IntegerDataType extends DataType {

	@Override
	protected Object generateValue() {
		return GENERATOR.getNumberUpTo(Integer.MAX_VALUE);
	}

}
