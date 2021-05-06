docker run \
    --name neo4jserver \
    -p7474:7474 \
    -p7687:7687 \
    -d \
    --rm \
    -v $HOME/work/data/neo4j/data:/data \
    -v $HOME/work/data/neo4j/logs:/logs \
    -v $HOME/work/data/neo4j/import:/var/lib/neo4j/import \
    -v $HOME/work/data/neo4j/plugins:/plugins \
    --user="$(id -u):$(id -g)" \
    --env NEO4J_AUTH=none \
    neo4j:latest
