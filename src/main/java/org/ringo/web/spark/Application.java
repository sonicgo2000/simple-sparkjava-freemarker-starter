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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.servlet.SparkApplication;

/**
 * Configuration class for Spark Framework.
 *
 * @author r.go
 * @version 0.1
 */
public class Application implements SparkApplication {

    /** Static instance for sl4j logger. */ 
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    /*
     * (non-Javadoc)
     * @see spark.servlet.SparkApplication#init()
     */
    @Override
    public void init() {
        logger.info("Initializing Spark framework...");

        configure();
        route();
    }

    private void configure() {
        logger.info("Setting up configurations...");

        // Configure static files for holding HTML, CSS, and JavaScripts
        staticFiles.location("/public");
    }

    private void route() {
        logger.info("Setting up routers...");

        // Configure routing; Using in-line
        get("/hello", (req, res) -> "Hello World");

        // Configure routing; Using custom class instance 
        get("/starter", new StarterRoute());
    }
}
