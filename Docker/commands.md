commands

- docker version --format '{{.Server.Version}}'
- docker rm $(docker ps -a -q) // remove all stopped containers

### Docker lifecycle

1. [docker create [OPTIONS] IMAGE [COMMAND] [ARG...]](https://docs.docker.com/engine/reference/commandline/create/) create but doesn't start
2. [docker rename CONTAINER NEW_NAME](https://docs.docker.com/engine/reference/commandline/rename/)
3. [docker run [OPTIONS] IMAGE [COMMAND] [ARG...]](https://docs.docker.com/engine/reference/commandline/run/)  run and create in one statement
4. [docker rm](https://docs.docker.com/engine/reference/commandline/rm/)
docker image rm  dd9acebe0b4d
5. [docker update](https://docs.docker.com/engine/reference/commandline/update/) update configuration of one or more containers

**Dockerfile** defines what goes on in the environment inside your container.

Let’s check the logs and see what the daemon container is doing right now:
docker logs -f daemon

### docker ipaddress or running container
docker inspect <containerNameOrId> | grep '"IPAddress"' | head -n 1

### beakerx
docker run -p 8888:8888 beakerx/beakerx