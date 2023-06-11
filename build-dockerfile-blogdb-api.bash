mvn clean install
cp -R /Users/ievgeniiizrailtenko/.m2/repository/de/javagath/shared-contract/ target/shared-contract/
docker build --network="host" . -f blogdb-api.Dockerfile -t blogdb-api --no-cache --progress=plain