/*
 * Copyright 2020 Sebastian Kaspari
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package recompose.parser.values

import org.xmlpull.v1.XmlPullParser
import recompose.ast.values.Orientation
import recompose.parser.Parser

/**
 * Parses an orientation attribute (from `android:orientation`) and returns the matching [Orientation]
 * object. Throws [Parser.ParserException] if the orientation could not be parsed.
 */
internal fun XmlPullParser.orientation(): Orientation? {
    return when (val value = getAttributeValue(null, "android:orientation")) {
        "vertical" -> Orientation.Vertical
        "horizontal" -> Orientation.Horizontal
        null -> null
        else -> throw Parser.ParserException("Unknown orientation: $value")
    }
}
