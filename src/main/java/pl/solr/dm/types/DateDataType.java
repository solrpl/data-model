package pl.solr.dm.types;

import java.util.Date;

import pl.solr.dm.DataType;

public class DateDataType extends DataType<Date> {

	@Override
	protected Date generateValue() {
		return GENERATOR.getDateBetween(new Date(0), new Date());
	}

}
