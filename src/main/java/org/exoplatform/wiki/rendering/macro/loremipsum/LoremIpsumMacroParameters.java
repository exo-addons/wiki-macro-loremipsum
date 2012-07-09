/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.wiki.rendering.macro.loremipsum;

import org.xwiki.properties.annotation.PropertyDescription;
import org.xwiki.properties.annotation.PropertyMandatory;

import javax.validation.constraints.Min;

/**
 * Parameters for the {@link org.exoplatform.wiki.rendering.macro.loremipsum.internal.LoremIpsumMacro} Macro.
 */
public class LoremIpsumMacroParameters {
    public static final String DEFAULT_PARAGRAPHS = "3";

    /**
     * @see {@link #getParagraphs}
     */
    @Min(1)
    private int paragraphs = 3;

    /**
     * @return the type parameter
     */
    public int getParagraphs() {
        return this.paragraphs;
    }

    /**
     * @param paragraphs the type for the status
     */
    @PropertyDescription("Number of paragraphs to generate")
    public void setParagraphs(int paragraphs) {
        this.paragraphs = paragraphs;
    }
}
