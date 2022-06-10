# Service84.IO Sample Service

## License
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Usage
This is a sample service that shows off automatic OpenAPI stub generation for Spring Services as well as publishing the OpenAPI definition of the service to a maven repository.

[SampleScript](https://github.com/service84-io/sample-script) is the counter part showing automatic OpenAPI download and client generation

Since the purpose of this repository is to showcase how to do something technical the API that is exposed by the service is a toy API related to proverbs and quotes.

## Build
This is a Java 11 project that builds best with Gradle 6.3

## Publishing
The OpenAPI specification can be published in 2 ways one way is to publish the whole service jar which includes all the compiled classes. The other ways is to publish a jar that only contains the service.yaml file.  The reason I packaged the service.yaml file in a jar is because MavenCentral will only publish things that are in jars, I admit this might be a misuse of MavenCentral, but it is free for OSS.

### Publishing the Big JAR
Just run the gradle publish command, for your local maven repository run the following:

    gradle publishToMavenLocal

Note that the provided build files will publish io.service84.services:sample

This way includes services in the package name whereas the other way includes openapi in the package name

### Publishing the service.yaml JAR
There is a openapi directory with a build.gradle file that references out to the service.yaml file. So, from the openapi direcotry just run the gradle publish command, for your local maven repository run the following

    cd openapi
    gradle publishToMavenLocal

Note that the provided build files will publish io.service84.openapi:sample

This way includes openapi in the package name whereas the other way includes services in the package name

## Versioning
This project makes a best effort to comply with [SemVer](https://semver.org/)
