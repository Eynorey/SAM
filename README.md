[![Build Status](https://eynorey.visualstudio.com/_apis/public/build/definitions/a5593139-cad8-4cc9-bb8c-b0b77cda90b0/9/badge)](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_build/index?context=allDefinitions&path=%5C&definitionId=9&_a=completed)
[![Quality Gate](http://193.196.7.25/api/badges/gate?key=io.bookster:bookster-2)](https://sonarcloud.io/dashboard?id=sam_new)
[![Code Coverage](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=coverage)](https://sonarcloud.io/dashboard?id=sam_new)
[![lines of code](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=lines)](https://sonarcloud.io/dashboard?id=sam_new)
[![test_errors](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=test_errors)](https://sonarcloud.io/dashboard?id=sam_new)
[![test_failures](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=test_failures)](https://sonarcloud.io/dashboard?id=sam_new)
[![bugs](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=bugs)](https://sonarcloud.io/dashboard?id=sam_new)
[![code_smells](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=new_code_smells)](https://sonarcloud.io/dashboard?id=sam_new)
[![new_vulnerabilities](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=new_vulnerabilities)](https://sonarcloud.io/dashboard?id=sam_new)
[![new_maintainability_rating](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=new_maintainability_rating)](https://sonarcloud.io/dashboard?id=sam_new)
[![new_reliability_rating](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=new_reliability_rating)](https://sonarcloud.io/dashboard?id=sam_new)
[![new_security_rating](https://sonarcloud.io/api/badges/measure?key=sam_new&metric=new_security_rating)](https://sonarcloud.io/dashboard?id=sam_new)


# SAM
This application was generated using JHipster 4.2.0, you can find documentation and help at [https://jhipster.github.io/documentation-archive/v4.2.0](https://jhipster.github.io/documentation-archive/v4.2.0).

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js][]: We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

    npm install

We use [Gulp][] as our build system. Install the Gulp command-line tool globally with:

    npm install -g gulp-cli

Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

    ./gradlew
    gulp

[Bower][] is used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [bower.json](bower.json). You can also run `bower update` and `bower install` to manage dependencies.
Add the `-h` flag on any command to see how you can use it. For example, `bower update -h`.

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development](https://jhipster.github.io/development/).


## Building for production

To optimize the sam application for production, run:

    ./gradlew -Pprod clean bootRepackage

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files.
To ensure everything worked, run:

    java -jar build/libs/*.war

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

## Testing

To launch our application's Java Unit tests, run:

    .\gradlew test

To launch our cucumber tests, run:

    src\test\seleniumcucumber\runtests.bat

For more information, refer to our Test Plan.