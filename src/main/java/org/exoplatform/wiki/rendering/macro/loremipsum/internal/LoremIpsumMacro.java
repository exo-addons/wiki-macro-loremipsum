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
package org.exoplatform.wiki.rendering.macro.loremipsum.internal;

import javax.inject.Named;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.exoplatform.wiki.rendering.macro.loremipsum.LoremIpsumMacroParameters;
import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.block.Block;
import org.xwiki.rendering.block.ParagraphBlock;
import org.xwiki.rendering.block.RawBlock;
import org.xwiki.rendering.block.WordBlock;
import org.xwiki.rendering.macro.AbstractMacro;
import org.xwiki.rendering.macro.MacroExecutionException;
import org.xwiki.rendering.syntax.Syntax;
import org.xwiki.rendering.transformation.MacroTransformationContext;

/**
 * A status Macro.
 */
@Component
@Named("loremipsum")
public class LoremIpsumMacro extends AbstractMacro<LoremIpsumMacroParameters> {
    /**
     * The description of the macro.
     */
    private static final String DESCRIPTION = "Lorem Ipsum Macro";

    private static final String[] PARAGRAPHS = {
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            "Ut ligula. Maecenas consequat. Aliquam placerat. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla convallis. Ut quis tortor. Vestibulum a lectus at diam fermentum vehicula. Mauris sed turpis a nisl ultricies facilisis. Fusce ornare, mi vitae hendrerit eleifend, augue erat cursus nunc, a aliquam elit leo sed est. Donec eget sapien sit amet eros vehicula mollis. In sollicitudin libero in felis. Phasellus metus sem, pulvinar in, porta nec, faucibus in, ipsum. Nam a tellus. Aliquam erat volutpat.",
            "Sed id velit ut orci feugiat tempus. Pellentesque accumsan augue at libero elementum vestibulum. Maecenas sit amet metus. Etiam molestie massa sed erat. Aenean tincidunt. Mauris id eros. Quisque eu ante. Fusce eu dolor. Aenean ultricies ante ut diam. Donec iaculis, pede eu aliquet lobortis, wisi est dignissim diam, ut fringilla eros magna a mi. Nulla vel lorem. Donec placerat, lectus quis molestie hendrerit, ante tortor pharetra risus, ac rutrum arcu odio eu tortor. In dapibus lacus nec ligula. Aenean vel metus. Nunc mattis lorem posuere felis. In vehicula tempus lacus. Phasellus arcu. Nam ut arcu. Duis eget elit id eros adipiscing dignissim.",
            "Nullam vel leo. Quisque vestibulum mollis turpis. Phasellus malesuada tellus vel diam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Ut varius lorem. Mauris bibendum pulvinar sem. Fusce vulputate. Aenean imperdiet, massa ut viverra dignissim, nunc purus pellentesque ligula, quis dictum est sem vitae sem. Ut bibendum elit id sapien. Quisque quis est. Phasellus tellus. Donec aliquam lorem sit amet libero. Cras massa dolor, dignissim id, faucibus vulputate, pharetra nec, erat. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec justo nunc, vestibulum a, vestibulum eget, aliquam non, augue. Morbi cursus consectetuer turpis. Duis non quam. Nam aliquet lorem ut tortor. Pellentesque malesuada, sem non tempor semper, magna pede aliquet lectus, sit amet egestas neque magna ut nunc.",
            "Integer sagittis aliquet diam. Proin fringilla vestibulum sem. Donec est lacus, imperdiet vel, elementum eu, tincidunt quis, odio. Proin dolor. Nulla arcu. Etiam dolor massa, fermentum id, adipiscing ultricies, suscipit in, orci. Aliquam erat volutpat. Ut tortor est, placerat ac, dictum ut, imperdiet vitae, leo. Nullam suscipit. Sed accumsan malesuada magna. Nulla facilisi. Donec est tellus, dictum in, bibendum sit amet, eleifend sit amet, risus. Quisque mauris lectus, tincidunt eget, pretium sed, eleifend ac, risus. Fusce mauris.",
            "Maecenas sed dolor. Sed nisl tellus, rutrum vitae, adipiscing id, semper quis, libero. Ut vestibulum interdum mi. Aliquam fringilla eleifend ante. Duis rhoncus odio in ante. Curabitur lobortis hendrerit enim. Duis tincidunt tellus at eros. Aliquam erat volutpat. Aenean enim. Maecenas pede magna, scelerisque ut, mattis id, auctor id, elit. Nullam interdum wisi vitae eros. Morbi non pede a augue lobortis egestas. Fusce vel turpis ut elit hendrerit dapibus.",
            "Ut aliquam pede sed magna. Suspendisse mattis orci id ligula commodo feugiat. Praesent neque augue, placerat nec, dapibus ac, laoreet id, justo. Vestibulum libero mauris, facilisis semper, accumsan quis, ullamcorper vel, libero. Aenean diam. Fusce commodo euismod turpis. Nulla facilisi. Maecenas nulla nisl, hendrerit eu, luctus sit amet, interdum ut, dui. Phasellus ut odio sed lorem venenatis porttitor. Vestibulum auctor.",
            "In sit amet ante at enim dictum egestas. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla eleifend. Suspendisse vulputate consequat tellus. Nunc et enim. Integer sapien. Nunc lacinia velit sit amet orci. Fusce dui leo, facilisis quis, sagittis et, aliquam non, nunc. Donec fringilla dui eu quam. Donec eros. Maecenas blandit dictum ipsum.",
            "Sed ut justo at sem congue laoreet. Sed cursus augue dignissim dolor. Donec vel felis. Nam vehicula eleifend mauris. Maecenas varius risus. Etiam ornare commodo erat. Etiam vestibulum sagittis justo. Aenean auctor. Suspendisse lacus erat, ultricies non, ultrices at, mattis quis, tellus. Maecenas eros quam, aliquam nec, ultricies non, vestibulum non, lacus. Morbi in nibh. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Ut lobortis auctor lacus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.",
            "Suspendisse at est sed pede suscipit hendrerit. Vivamus pharetra, tellus sed tempor fermentum, urna ipsum fringilla ante, vel sodales dolor justo quis arcu. Proin vehicula. Donec id pede sit amet metus convallis pharetra. Nulla ut enim sed diam euismod vestibulum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nulla ante massa, cursus nec, consequat sit amet, luctus non, nunc. Suspendisse potenti. Phasellus nec justo. Suspendisse nisl wisi, lacinia sit amet, blandit vitae, tristique vitae, ante.",
            "Curabitur pede metus, condimentum vel, gravida eget, commodo ac, nibh. Etiam volutpat nonummy justo. Praesent vel sem quis tortor hendrerit congue. Pellentesque odio erat, pharetra vel, facilisis non, mattis vel, lectus. Mauris eget orci. Fusce tempor, nunc at fringilla blandit, nibh nisl porta augue, ut eleifend purus wisi sed est. Vestibulum nec dui. Mauris vitae lorem non neque auctor accumsan. In eu metus. Donec iaculis, lacus ut porttitor malesuada, ipsum libero nonummy odio, vel pretium quam dui et nibh. Suspendisse potenti. Duis nunc risus, porta et, iaculis ac, laoreet eget, sem. Sed sem est, tincidunt aliquam, tempus sed, tempus vel, ipsum. Sed interdum hendrerit massa. Vivamus hendrerit nisl iaculis arcu. Curabitur mauris dolor, laoreet non, sodales vitae, pulvinar eget, metus.",
            "Suspendisse tempus nisl vitae odio. Aenean ligula. Proin accumsan. Sed tellus lacus, tincidunt non, bibendum non, bibendum ac, mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut id dolor sed ante ultricies placerat. Aliquam justo metus, luctus vel, tempor nec, sagittis a, libero. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Fusce sollicitudin fringilla augue. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dapibus nunc ac purus. Curabitur viverra eleifend justo. Sed id elit nec urna ullamcorper mollis. Nam sollicitudin erat ac pede.",
            "Nam tortor. Fusce at nulla. Phasellus condimentum malesuada est. Pellentesque sit amet nisl at quam scelerisque aliquam. Vestibulum quis nibh. Sed semper viverra nisl. Etiam ipsum augue, sagittis in, tincidunt ac, mollis ac, ante. Vestibulum posuere, diam non dignissim pellentesque, dui pede hendrerit quam, eget placerat magna massa vehicula lorem. Aliquam tempor condimentum augue. Suspendisse egestas, ligula eu tempor auctor, dui eros facilisis diam, ut pulvinar eros sem vel tortor.",
            "In hac habitasse platea dictumst. Vestibulum ut magna hendrerit tellus euismod ullamcorper. Phasellus consequat, lacus tempus sodales vestibulum, nunc felis tristique lectus, nec porta magna eros non lorem. Ut eros lacus, ultricies id, venenatis ut, mattis nec, augue. Aliquam a ante a eros consequat commodo. Proin viverra. Nunc interdum, arcu non ullamcorper pretium, arcu ligula pharetra ligula, tempus ultrices eros mi ut purus. Nulla vehicula. Fusce non purus. Nunc lobortis, elit a venenatis rhoncus, arcu libero mattis magna, eu blandit velit nisl at leo. Mauris elementum metus a ligula. Nullam eu enim. Morbi non diam. Nullam ut velit eget felis iaculis molestie. In bibendum aliquam urna. Aenean a wisi.",
            "Etiam in turpis vitae enim sagittis placerat. Nunc scelerisque eleifend justo. Donec sollicitudin enim eget turpis. Sed at ligula. Curabitur tempus mollis augue. Aliquam consequat quam ac dui. Nunc ac quam. Aenean quis diam at felis condimentum volutpat. Vestibulum et elit a sapien fringilla mattis. Nunc euismod. Fusce iaculis, ligula sit amet mattis euismod, lorem est egestas wisi, sit amet tempor arcu augue id dolor. Nullam quis wisi vitae sapien pellentesque eleifend. Etiam quis odio nec lorem tincidunt imperdiet. Quisque velit."
    };

    /**
     * Create and initialize the descriptor of the macro.
     */
    public LoremIpsumMacro() {
        super("Lorem Ipsum", DESCRIPTION, LoremIpsumMacroParameters.class);
        setDefaultCategory(DEFAULT_CATEGORY_CONTENT);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.xwiki.rendering.macro.Macro#execute(Object, String, MacroTransformationContext)
     */
    public List<Block> execute(LoremIpsumMacroParameters parameters, String content, MacroTransformationContext context)
            throws MacroExecutionException {

        int paragraphs = parameters.getParagraphs();

//        List<ParagraphBlock> result = new ArrayList<ParagraphBlock>(paragraphs);

        StringBuilder sb = new StringBuilder((PARAGRAPHS[0].length() + 30) * paragraphs);
        int p = 1;
        for (int i = 0; i < paragraphs; i++) {
//            result.add(new ParagraphBlock(Collections.singletonList((Block) new WordBlock(PARAGRAPHS[p - 1]))));
            sb.append("<p>");
            sb.append(PARAGRAPHS[p - 1]);
            sb.append("</p>");
            if (p == PARAGRAPHS.length) {
                p = 1;
            } else {
                p++;
            }
        }

/*
        // Handle both inline mode and standalone mode.
        if (context.isInline()) {
            result = wordBlockAsList;
        } else {
            // Wrap the result in a Paragraph Block since a WordBlock is an inline element and it needs to be
            // inside a standalone block.
            result = Arrays.<Block>asList(new ParagraphBlock(wordBlockAsList));
        }
*/
        RawBlock rawBlock = new RawBlock(sb.toString(), Syntax.XHTML_1_0);

//        return Collections.singletonList((Block) result);
        return Collections.singletonList((Block) rawBlock);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.xwiki.rendering.macro.Macro#supportsInlineMode()
     */
    public boolean supportsInlineMode() {
        return true;
    }
}
