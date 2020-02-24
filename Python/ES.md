# ElasticSearch

## Ping a ES server

``` python
from elasticsearch import Elasticsearch
from elasticsearch.exceptions import ConnectionError

try:
    es:bool = Elasticsearch([{'host': 'localhost', 'port': 9200}]).ping()
    print(es)
except ConnectionRefusedError:
    print ('Connection Error!')
```

## get default response

``` python
import requests
r:requests.models.Response = requests.get('http://localhost:9200')
print(r)
r.headers
r.content
```
