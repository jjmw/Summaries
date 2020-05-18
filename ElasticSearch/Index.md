

# Indexes



### Create index without mapping

```json
{
	PUT items
}
```

### Delete index

```json
{
	DELETE items
}
```



### Mapping is the process of defining how a document, and the fields it contains, are stored and indexed.

[Mapping](https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping.html)

```json
{
    GET /<index>/_mapping
}

{
    GET /<index>/_mapping/field/<fieldname>
}
```

### create a new index with mapping (example)

```json
PUT /items
{
    "settings": {
    "index": {
        "number_of_shards": <int>,
        "number_of_replicas": <int>
        }
    },
  "mappings": {
    "properties": {
      "name": {
        "type": "keyword"
      },
      "production_date": {
        "type": "date"
      },
      "location": {
        "type": "geo_point"
      },
      "max_spots": {
          "type": "integer"
      },
      "description": {
          "type": "text"
      }
    }
  }
}
```
[Field datatypes](https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-types.html)


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