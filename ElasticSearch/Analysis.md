# Analysis

### Analyses is performed by a analyser
- tokenizer: breaks sentence in tokens, position of the tokens, optional for a specific language
- token filter: filter out stopwords
- character filter

Reader -> tokenizer -> token filter -> token

### Where use analyses?
- query
- mapping parameter
- index setting

Analyser is used in the mapping part
Example

### Analysers
1. Standard
	- max_token_length (default 255)
	- stopwords (defaults \_none_)
	- stopwords_path (path to file containing stopwords)
	- keep numeric values
2. simple
	- lowercase
	- remove special characters (ie dog's -> [dog, s])
	- remove numeric values
3. whitespace
	- breakes text into terms whenever it encounters a whitespace character
	- no lowercase transformation
	- takes terms as they are
	- keeps special characters
4. own analyzer (see below)



### Example
```json
PUT /test_analyzer
{
  "settings": {
    "analysis": {
      "analyzer": {
        "my_analyzer": {
          "type": "standard",
          "max_token_length": 5,
          "stopwords": "_english_"
        }
      }
    }
  },
  "mappings": {
      "properties": {
        "spreker_1": {
          "type": "keyword",
          "analyzer" : "my_analyzer"     <== or an other analyzer; so per field
        }
      }
    }
}
```

```json
GET /test_analyzer/_analyze
{
  "analyzer": "my_analyzer",
   "field": "spreker_1",
  "text": ["What is the this builders"]
}
```


