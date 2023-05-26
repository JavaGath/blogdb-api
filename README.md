# blogdb-api

This service enables communication with blogdb.
Blogdb contains all articles which where saved in the blog.

## How to build

### Locally

Firs of all you have to simulate host names on your localhost

```
sudo vim /etc/hosts
```

After that you can start to create your containers. It is important to use host-network.
<br> While building the process is not in the docker-network because it is not a docker container.
<br> With host-network Dockerfile will use while building host-names from your machine.

```
docker build . -f blog-db.Dockerfile -t blog-db 
docker run --name blog-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d blog-db 
docker build --network="host" . -f blogdb-api.Dockerfile -t blogdb-api --no-cache --progress=plain
```

### In Docker-network

You need to create a network for DNS container-names

```
docker network create javagath
docker run --net javagath --name blog-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d blog-db
docker run --net javagath  --name blogdb-api -p 8081:8081 -d blogdb-api
docker network inspect javagath
localhost:8081/actuator/health
```

In the script dummy-data.sql you can find dummy data to work with new empty docker container. 