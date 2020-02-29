# cUrl commands

## Create Index



## Delete Index
``` bash
curl -X DELETE 'http://localhost:9200/indexName'
```

## List all indexes
``` bash
curl -X GET 'http://localhost:9200/_cat/indices?v'
```

## query using URL parameters
### Lucene syntax
```bash
curl -X GET http://localhost:9200/IndexName/_search?q=school:Harvard
```

## Query using JSON
### ElasticSearch DSL syntax
```bash
curl -XGET --header 'Content-Type: application/json' http://localhost:9200/indexName/_search -d '{
      "query" : {
        "match" : { "school": "Harvard" }
    }
}'
```

## List index mapping
### aka schema; fieldnames and their type
```bash
curl -X GET http://localhost:9200/indeName
```

## Add data
### indeName and doc# = 1 
curl -XPUT --header 'Content-Type: application/json' http://localhost:9200/indexName/_doc/1 -d '{
   "school" : "Harvard"
}'


## Update a document
## In this example create first a doc and then update the document
```bash
curl -XPUT --header 'Content-Type: application/json' http://localhost:9200/indexName/_doc/2 -d '
{
    "school": "Clemson"
}'

curl -XPOST --header 'Content-Type: application/json' http://localhost:9200/indexName/_doc/2/_update -d '{
"doc" : {
               "students": 50000}
}'
```




![Source](https://www.bmc.com/blogs/elasticsearch-commands/)

