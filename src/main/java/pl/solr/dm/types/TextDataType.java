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
package pl.solr.dm.types;

import pl.solr.dm.DataType;

/**
 * Type which returns random text.
 *
 * @author negativ
 *
 */
public class TextDataType extends DataType<String> {

	@Override
	protected String generateValue() {
		StringBuilder builder = new StringBuilder();
		int words = RANDOM.nextInt(40);
		while (words-- > 0) {
			builder.append(GENERATOR.getRandomText(1, 8));
			if (words > 1) {
				builder.append(' ');
			}
		}
		return builder.toString();
	}

}
