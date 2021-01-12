# Docker

## remove all stopped containers

- docker rm $(docker ps -a -q)

### list and remove images

- docker images -a
- docker rmi $(docker images -a -q)
  
### Docker lifecycle

1. [docker create [OPTIONS] IMAGE [COMMAND] [ARG...]](https://docs.docker.com/engine/reference/commandline/create/) create but doesn't start
2. [docker rename CONTAINER NEW_NAME](https://docs.docker.com/engine/reference/commandline/rename/)
3. [docker run [OPTIONS] IMAGE [COMMAND] [ARG...]](https://docs.docker.com/engine/reference/commandline/run/)  run and create in one statement
4. [docker rm](https://docs.docker.com/engine/reference/commandline/rm/)
docker image rm  dd9acebe0b4d
5. [docker update](https://docs.docker.com/engine/reference/commandline/update/) update configuration of one or more containers

- docker logs -f <name daemon>

### docker ipaddress or running container

docker inspect <containerNameOrId> | grep '"IPAddress"' | head -n 1

### three basic commands

```bash
docker images <ls>
docker container <ls> <-a>
docker run <name>
```

### run tensorflow and jupyter at port 8888

docker run --rm -v $(pwd):/tf/convolutional -it -p 8888:8888 tensorflow/tensorflow:latest-jupyter

### run iterative python program directly

docker run --rm -v $(pwd):/src --rm python:latest python /src/hello-world.py

### run iterative python shell

docker run --rm -it -v $(pwd):/src --rm python:latest python

### run bash inside python container

docker run --rm -it -v $(pwd):/src --rm python:latest /bin/bash

### run a daemon with option -d

```bash
docker run --rm --name my-postgres -e POSTGRES_PASSWORD=qw12aap -d postgres:latest
docker exec -it my-postgres   psql -h localhost -U postgres -d postgres
```

### docker files

```dockerfile
FROM python:latest
RUN pip3 install numpy
CMD python3 /src/hello-world.py
```

### docker networks

Usage: docker network COMMAND

Commands:
  connect     Connect a container to a network
  create      Create a network
  disconnect  Disconnect a container from a network
  inspect     Display detailed information on one or more networks
  ls          List networks
  prune       Remove all unused networks
  rm          Remove one or more networks

```bash
docker network create net_1
docker run --rm -d --net net_1 --name my_py -v $(pwd):/src  python:latest python3 /src/run.py
docker run --rm -it --net net_1 alpine:latest /bin/bash

docker network create net_2
docker run --rm --name my-postgres --network net_2 -e POSTGRES_PASSWORD=qw12aap -d postgres:latest
docker run -it --rm --name my_postgre2 --network net_2  postgres:latest /bin/bash
```

inside: psql -U postgres -h my-postgres

### Docker Compose

```docker-compose
version: '3'
services:
     python:
             image: python:latest
             container_name: my_py
             volumes:
                     - .:/src
             command: python3 /src/run.py
             restart: always
     postgres:
             image: postgres:latest
             container_name: my_post
             environment:
                     - e POSTGRES_PASSWORD=qw12aap
             restart: always
     alpine:
             image: alpine:latest
             command: echo "hello from alpine"
             restart: always
```

[How To Remove Docker Images, Containers, and Volumes](<https://www.digitalocean.com/community/tutorials/how-to-remove-docker-images-containers-and-volumes>)

