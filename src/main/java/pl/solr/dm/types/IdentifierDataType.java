package pl.solr.dm.types;

import pl.solr.dm.DataType;

public class IdentifierDataType extends DataType {
	private static long counter = 0;
	
	@Override
	public Object getValue() {
		return "" + (++counter);
	}

}
