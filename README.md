# KUSHINADA

[![Build Status](https://travis-ci.org/tamada/kushinada.svg)](https://travis-ci.org/tamada/kushinada)

## Overview

Web interface for birthmarking toolkit.

A birthmark is a set of native characteristics that the program
originally possesses. The birthmark is carefully extracted from
critical portions of class file. Hence, if a class file P has the same
birthmark as another class file Q's, Q is very likely to be a copy of
P. Thus, the birthmark can be used as a simple but powerful signature
to distinguish doubtful class files (those which seem to be copies).

## Features

The features of KUSHINADA are:
* to store birthmark into the database, and
    * the birthmarks are extracted from given jar files, and
    * from specified maven repository.
* to compare birthmarks from database and given jar files.

## Compile & Run

1. Simply type ```mvn package```.
2. to run KUSHINADA, type ```java -jar target/kushinada-1.0-SNAPSHOT.jar```
3. Access ```http://localhost:8080``` with Web browser.

## Requirements

* Maven 3.x
* DWR 3.0.0
* Servlet 2.5
* Winstone 2.8
* h2 database
* Apache Commons DBUtils
* Stigmata

All of dependencies automtically download from internet by Maven.

## Licenses

Apache License version 2.0.

## Developers

* Haruaki Tamada

Please notify us some bugs and requests on https://github.com/tamada/kushinada.