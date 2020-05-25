# examples


```json
POST /items/_search
{
  "query": {
    "term": {"age" : "10"}
    }
}

GET /items/_search
{
  "query": {
    "match": {
      "name": "jan"
    }
  }
}

GET /shakespeare/_search

GET /shakespeare/_search
{
  "query": {
    "match": {
      "speech_number": "1"
    }
  }
}

GET /shakespeare/_search
{
  "query": {
    "match_phrase": {
      "text_entry": "scene I"
    }
  }
}

GET /shakespeare/_search
{
 "query": {
   "match_phrase_prefix": {
     "text_entry": "with care"
   }
 } 
}

GET /shakespeare/_search
{
  "query": {
    "match_all": {}
  }
}

GET /shakespeare/_search
{
  "query": {
    "match_phrase": {
      "text_entry":
       {"query" : "shaken are", "slop": 2}
  }
}
}

GET /shakespeare/_search
{
  "query": {
    "query_string": {
      "fields": ["play_name", "speaker"],
      "query": "KING HENRY IV",
      "default_operator": "AND"
    }
  }
}



GET /shakespeare/_search
{
  "query": {
    "match": {
      "line_id": 1
    }
}
}

GET /shakespeare/_search
{
  "query": {
    "terms": {
      "speaker": [
        "KING HENRY IV",
        "HENTY"
      ]
    }
    }
  }


GET /shakespeare/_search
{
  "query": { 
    "range": {
      "line_id": {
        "gte": 1,
        "lte": 7
      }
}
}
}


GET /shakespeare/_search
{
  "query": {
    "prefix": {
      "speaker": {
        "value": "KING"
      }
    }
  }
}


GET /shakespeare/_search
{
  "query": {
    "wildcard": {
      "speaker": {
        "value": "KING HENR*"
      }
    }
  }
}


GET /shakespeare/_mapping


```