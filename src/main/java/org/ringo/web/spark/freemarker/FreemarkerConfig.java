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

package org.ringo.web.spark.freemarker;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerConfig {

    private static FreemarkerConfig _config;

    private Configuration cfg;

    private FreemarkerConfig() { }

    public static FreemarkerConfig getInstance() {
        if (_config == null) {
            _config = new FreemarkerConfig();
        }
        return _config;
    }

    public void initialize(ServletContext context) {
        this.cfg = new Configuration(Configuration.VERSION_2_3_27);
        this.cfg.setServletContextForTemplateLoading(context, "ftl");
        this.cfg.setDefaultEncoding("UTF-8");
        this.cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        this.cfg.setLogTemplateExceptions(false);
        this.cfg.setWrapUncheckedExceptions(true);
    }

    public Template getTemplate(String template) {
        Template templateObj = null;
        try {
            templateObj = this.cfg.getTemplate(template);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return templateObj;
    }

    public String getTemplateAsString(String template) {
        Template templateObj = getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        try {
            templateObj.process(new Object(), stringWriter);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    public class Templates {
        public static final String STARTER_PAGE = "starter.ftl";
    }
}
