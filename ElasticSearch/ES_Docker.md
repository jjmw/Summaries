# Setup ES with Docker

## get ES Docker container and start
```bash
    docker pull elasticsearch:7.6.2    # lastest is not supported by ES
    docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.6.2    # start a singel node
```

## Test if running correctly
```bash
    curl -I -XHEAD localhost:9200
```

[Link to ES with Kibana](https://www.elastic.co/guide/en/elasticsearch/reference/7.6/docker.html#_pulling_the_image)


