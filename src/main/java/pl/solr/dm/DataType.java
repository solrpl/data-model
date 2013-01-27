/**
 * Copyright 2012,2013 Solr.pl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.solr.dm;

import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Parent class for all types which can be used in data model definition.
 * 
 * @author negativ
 *
 * @param <T> java type used by type definition
 */
public abstract class DataType<T> {
	/** generator used for random values. */
	protected static final DataFactory GENERATOR = new DataFactory();
	
	/** random generator used by types definition. */ 
	protected static final Random RANDOM = new Random();
	
	/** probability used for decision: generate or not field for current data record returned. */
	private int probability = 100;

	static {
		GENERATOR.randomize((int) System.currentTimeMillis());
	}


//	/**
//	 * Generate next value for current field considering probability.
//	 *
//	 * @return new generated data or null if field should be skipped for given record
//	 */
//	@JsonValue
//	public final T getValue() {
//		if (RANDOM.nextInt(100) < probability) {
//			return generateValue();
//		}
//		return null;
//	}
//	
	
	public boolean exists() {
		if (RANDOM.nextInt(100) < probability) {
			return true;
		}
		return false;
	}
	/**
	 * Generate next value for current field.
	 * @return next generated field
	 * TODO: change name and identifier should have always the same value
	 */
	@JsonValue
	public abstract T getValue();
}
