FROM maven:3.9

# Create app-directory and copy the project
ADD . /blogdb-api
WORKDIR /blogdb-api

# Is everything ok?
RUN ls

# Run Maven build
RUN mvn clean install

RUN echo "jar is ready"
# Remove the build container and just use the build artifact
FROM openjdk:17-jdk

LABEL maintainer="Ievgenii Izrailtenko"

VOLUME /tmp

# Add jar to container
COPY --from=0 "/blogdb-api/target/blogdb-api.jar" blogdb-api.jar

# Run jar-artifact
CMD ["java","-jar","/blogdb-api.jar"]