# cUrl commands

curl -X<VERB> '<PROTOCOL>://<HOST>:<PORT>/<PATH>?<QUERY_STRING>' -d '<BODY>'

| Variables  | Description |
| :--------- | :---------- |
| <VERB>     | The appropriate HTTP method or verb. For example, GET, POST, PUT, HEAD, or DELETE |
| <PROTOCOL> | Either http or https. Use the latter if you have an HTTPS proxy in front of Elasticsearch or you use Elasticsearch security features to encrypt HTTP communications | 
| <HOST>     | The hostname of any node in your Elasticsearch cluster. Alternatively, use localhost for a node on your local machine | 
| <PORT>     | The port running the Elasticsearch HTTP service, which defaults to 9200 | 
| <PATH>     | The API endpoint, which can contain multiple components, such as _cluster/stats or _nodes/stats/jvm. 
| <QUERY_STRING> | Any optional query-string parameters. For example, ?pretty will pretty-print the JSON response to make it easier to read | 
| <BODY>     | A JSON-encoded request body (if necessary) | 


## Test connection and ES correctly running
```bash
    curl -I -XHEAD localhost:9200
```

## Create Index
```bash
curl -X PUT http://localhost:9200/indexName
```

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

Lookup on index id
```bash
curl -XGET --header 'Content-Type: application/json' http://localhost:9200/indexName/_search -d '{
      "query" : {
        "match" : { "_id": "37" }
    }
}'
```

## List index mapping
### aka schema; fieldnames and their type
```bash
curl -X GET http://localhost:9200/indexName
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

### load a dataset
```bash
curl -u elastic -H 'Content-Type: application/x-ndjson' -XPOST '<host>:<port>/bank/_bulk?pretty' --data-binary @accounts.json
```



[Source 1](https://www.bmc.com/blogs/elasticsearch-commands/)

