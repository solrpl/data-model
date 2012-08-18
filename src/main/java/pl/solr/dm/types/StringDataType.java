package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class StringDataType extends DataType {

	@Override
	public Object getValue() {
		return GENERATOR.getRandomWord();
	}

}
