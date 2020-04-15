FROM markhobson/maven-chrome

COPY pom.xml ./usr/src
COPY . ../usr/src

WORKDIR /usr/src
RUN mvn package
