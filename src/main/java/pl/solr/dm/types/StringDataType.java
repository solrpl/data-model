package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class StringDataType extends DataType<String> {

	@Override
	protected String generateValue() {
		return GENERATOR.getRandomWord();
	}

}
