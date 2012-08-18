package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class StringDataType extends DataType {

	@Override
	protected Object generateValue() {
		return GENERATOR.getRandomWord();
	}

}
