# HTTP API commands

### list indexes
```http
    GET /_cat/indices?v   <!-- index with all columns -->
    GET /_cat/indices
    GET /<index>/_mapping <!-- get all mappings of index catalog -->
    GET /<index>/_doc/<id>

    GET /_cat/health?v     <!-- info about cluster and nodes -->
```
### Searches
```http
  GET /<index>,<index>/<type>/_search    <!-- Searches over all indices on types -->
  GET _search                            <!-- Searches every index on all types -->
```

### Most basic query; it returns all the content and with the score of 1.0 for every object.
```http
GET /<index>/_search
{
   "query":{
      "match_all":{}
   }
}
```

### exanple
```http
GET /customer/_search
{
   "query": {                               <!-- when search query is first level always -->
      "match" : { "name" : "John Doe" }
   }
}
```


### Index API CRUD operations
```http
  PUT /catalog/_doc/1
  PUT /<index>/<type>/<id>  <!-- providing an ID -->
  POST /catalog/_doc{....}
  POST /<index>/<type> <!-- without providing an ID; ID = generated hash string -->

  POST /catalog/_update/1{ doc { ....} }
  POST <index>/<type>/<id>/_update

  DELETE <index>/<type>/<id>
```

### Creating an **new** index
## Elasticsearch Query DSL
```http
  PUT /catalog 
  {
    "settings": {
      "index": {
         "number_of_shards": <int>,
         "number_of_replicas": <int>
       }
      },
  "mappings": {
    "properties": {
    "speaker": {"type": "keyword"},
    "play_name": {"type": "keyword"},
    "line_id": {"type": "integer"},
    "description": {"type": "text"}
    "speech_number": {"type": "integer"}
    }
  }
}
```

### Adding a type mapping in an existing index
merged into the existing mappings of the _doc type
```http
  PUT /<index>/_mapping
  {
    "properties": {
        "name": {
           "type": "text"    
         }
     }
  }
```

### Formatting the JSON response
```bash
curl -XGET http://localhost:9200/catalog/_doc/1?pretty=true
```

### Standard tokenizer
```http
POST _analyze
  {"tokenizer": "standard",  "text": "Tokenizer breaks characters into tokens!"
}
```

### analyzer example with english stopwords
```http
PUT index_standard_analyzer_english_stopwords
{ "settings": {
       "analysis": {
         "analyzer": {
           "std": {
             "type": "standard",
             "stopwords": "_english_"         }       
           }
          }
        },
        "mappings": {
          "properties": {
            "my_text": {         "type": "text",         "analyzer": "std"
            }
          }
        }
}
```

