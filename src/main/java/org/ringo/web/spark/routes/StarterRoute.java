/* --------------------------------------------------------------------------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * --------------------------------------------------------------------------------
 */

package org.ringo.web.spark.routes;

import org.ringo.web.spark.freemarker.FreemarkerConfig;

import spark.Request;
import spark.Response;
import spark.Route;

public class StarterRoute implements Route {

    /*
     * (non-Javadoc)
     * @see spark.Route#handle(spark.Request, spark.Response)
     */
    @Override
    public Object handle(Request request, Response response) throws Exception {
        FreemarkerConfig.getInstance().initialize(request.raw().getServletContext());
        String htmlString = FreemarkerConfig.getInstance().getTemplateAsString(FreemarkerConfig.Templates.STARTER_PAGE);

        response.type("text/html");
        return htmlString;
    }

}
