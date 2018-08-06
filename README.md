<!---
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <https://www.gnu.org/licenses/>.
 -->

# Simple SparkJava + Freemarker Starter Kit

A simple starter kit for those who want to jump start developing SparkJava with Freemarker templating engine.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
Deployment on production environment is not yet tested.

### Prerequisites

Minimum Required software to run the project

- Java 8
- Eclipse (preferably with Gradle integration)
- Gradle 4

### Installing

- Import in Eclipse as an Existing Gradle project
- In eclipse, refresh the project using 
    ```Right Click -> Gradle -> Refresh Gradle Project``` to update dependencies

### Running in Development Server

- Add a new Run Configuration in Eclipse for Gradle Project
    ```Right Click -> Run As -> Run Configurations -> Gradle Project -> New Configuration```
- Set Working Directory to the current project in workspace
- Set Gradle Tasks to ```clean appRun```
- Then click on Run button
- Access ```http://localhost:8081/starter``` in a browser

If a sample page will load, then congratulations you have finished setting up the project.

## Source Description

### Directories

- ```src/main/java``` contains the java source files
- ```src/main/resources/public``` contains the static files
- ```src/main/web/ftl``` freemarker templates

### Configuration Files

- ```org.ringo.web.spark.Application.java``` Spark configuration file
- ```org.ringo.web.spark.freemarker.FreemarkerConfig``` Freemarker Singleton Configuration