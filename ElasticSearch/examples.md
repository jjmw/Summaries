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


GET /shakespeare/_search
{
  "query": {
    "bool": {
      "must": [
        {"term": {
          "speaker": {
            "value": "KING HENRY IV"
          }
        }}
      ],
      "filter": [
        {"term": {
          "speech_number": "1"
        }}
      ]
    }
  }
}


GET /shakespeare/_search
{
  "query": {
    "bool": {
      "must": [
        {"match": {
          "speaker": "KING HENRY IV"
        }}
      ],
      "should": [
        {"term": {
          "line_number": {
            "value": "1.1.2"
          }
        }},
        {"term": {
          "speech_number": {
            "value": "2"
          }
        }}
      ],
      "minimum_should_match": 1, 
      "filter": [
        {"term": {
          "play_name": "Henry IV"
        }}
      ]
  }
      
    }
  }


GET /shakespeare/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "wildcard": {
            "line_number": {
              "value": "1.1.?"
            }
          }
        },
        {
          "range": {
            "line_id": {
              "gte": 1,
              "lte": 40
            }
          }
        }
      ],
      "minimum_should_match": 2
    }
  }
}

GET /shakespeare/_search
{
  "query": {
    "query_string": {
      "fields": ["speaker","play_name"],
      "query": "KING HENRY IV",
      "default_operator": "OR"
    }
  }
}


  PUT /shakespeare/_mapping
  {
    "properties": {
        "spreker_1": {
           "type": "keyword" 
         }
     }
  }


DELETE /test_analyzer



PUT /test_analyzer
{
  "settings": {
    "analysis": {
      "tokenizer": {
        "split_on_words": {
          "type" : "pattern",
          "pattern": "\\W|_|[a-c]",
          "lowercase": true
        }
      }, 
      "analyzer": {
        "rebuild_pattern": {
          "tokenizer" : "split_on_words",
          "filter": ["lowercase"]
           
        }
      }
    }
  }
}
  
  
  "mappings": {
      "properties": {
        "spreker_1": {
          "type": "keyword"

        }
      }
    }
}

GET /test_analyzer/_analyze
{
  "analyzer": "rebuild_pattern",
  "field": "spreker_1",
  "text": ["Whsat is_the dd@this 1 builder's"]
}

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



PUT /developer1
{
  "mappings": {
    "properties": {
      "name": {
        "type": "text"
      },
      "skills": {
        "type": "object",
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

POST /developer1/_doc/101
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



GET /developer1/_search
{
  "query": {
    "match": {
      "skills.language": "ruby"
    }
  }
}



```