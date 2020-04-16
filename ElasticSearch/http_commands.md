# HTTP API commands

### list indexes
```http
    GET /_cat/indices?v    // all columns
    GET /_cat/indices
```

### example of mapping
```json
PUT /shakespeare
{
  "mappings": {
    "properties": {
    "speaker": {"type": "keyword"},
    "play_name": {"type": "keyword"},
    "line_id": {"type": "integer"},
    "speech_number": {"type": "integer"}
    }
  }
}
```
