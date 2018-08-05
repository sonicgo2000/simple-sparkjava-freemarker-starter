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

package org.ringo.web.spark;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

import org.ringo.web.spark.routes.StarterRoute;

import spark.servlet.SparkApplication;

public class Application implements SparkApplication {

    /*
     * (non-Javadoc)
     * @see spark.servlet.SparkApplication#init()
     */
    @Override
    public void init() {
        configure();
        route();
    }

    private void configure() {
        // Configure static files for holding HTML, CSS, and JavaScripts
        staticFiles.location("/public");
    }

    private void route() {
        // Configure routing; Using in-line
        get("/hello", (req, res) -> "Hello World");

        // Configure routing; Using custom class instance 
        get("/starter", new StarterRoute());
    }
}
