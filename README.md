# blogdb-service

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
```