package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class IdentifierDataType extends DataType<String> {
	private static long counter = 0;
	
	@Override
	protected String generateValue() {
		return "" + (++counter);
	}

}
