# automated-qa-testing

Scenarios are described in the .feature files in /src/test/resources/features/


# Run with docker
go to the specific project, for instance: `cd GO/`
build docker image: `docker build -t go-test .`
run docker container: `docker run -it -v "$PWD":/usr/src go-test mvn clean verify`