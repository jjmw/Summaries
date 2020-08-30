

# Indexes


### Create index without mapping

```json
{
	PUT <index>
}
```

### Delete index

```json
{
	DELETE <index>
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
- Can not change the number of shards after index iz created
- re-index is possible (worstcase)
- replicas can be added later


### Types of fields
- object (may contain inner objects; json docs are hierarchocal in nature)
- nested


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
```json
  PUT /<index>/_mapping
  {
    "properties": {
        "name": {
           "type": "text"    
         }
     }
  }
```




### Create NESTED mapping, insert data and query
```json
DELETE /developer

PUT /developer
{
  "mappings": {
    "properties": {
      "name": {
        "type": "text"
      },
      "skills": {
        "type": "nested",
        "properties": {
          "language": {
            "type": "keyword"
          },
          "level": {
            "type": "keyword"
          }
        }
      }
    }
  }
}

POST /developer/_doc/101
{
  "name": "john Doe",
  "skills": [
    {
      "language": "ruby",
      "level": "expert"
    },
    {
      "language": "javascript",
      "level": "beginner"
    }
  ]
}


GET /developer/_search
{
  "query": {
    "nested": {
      "path": "skills",
      "query": {
        "bool": {
          "must": [
            {
              "match": {
                "skills.language": "ruby"
              }
            },
            {
              "match": {
                "skills.level": "expert"
              }
            }
          ]
        }
      }
    }
  }
}
```






### Create OBJECT mapping, insert data and query





