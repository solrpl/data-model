package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class IntegerDataType extends DataType {

	@Override
	public Object getValue() {
		return GENERATOR.getNumberUpTo(Integer.MAX_VALUE);
	}

}
