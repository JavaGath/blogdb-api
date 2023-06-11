FROM maven:3.9
# Create app-directory and copy the project
ADD . /blogdb-api
# Copy private libary from target dir into docker .m2
RUN mkdir -p /root/.m2/repository/de/javagath
RUN cp -R blogdb-api/target/shared-contract/ /root/.m2/repository/de/javagath/shared-contract/
WORKDIR /blogdb-api

# Is everything ok?
RUN echo "Show me the content"
RUN ls -a

# Run Maven build
RUN mvn install

RUN echo "jar is ready"
# Remove the build container and just use the build artifact
FROM openjdk:17-jdk

LABEL maintainer="Ievgenii Izrailtenko"

VOLUME /tmp

# Add jar to container
COPY --from=0 "/blogdb-api/target/blogdb-api.jar" blogdb-api.jar

# Run jar-artifact
CMD ["java","-jar","/blogdb-api.jar"]