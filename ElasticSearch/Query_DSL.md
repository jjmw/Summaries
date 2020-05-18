# Elasticsearch Query DSL

### Queries can be classified into three types

1. Filtering by exact values
2. Searching on analyzed text
3. A combination of the two

Every __document field__ can be classified:

- either as an exact values
- analyzed text (also called full text)

## Exact values

are fields like user_id, date, email_addresses
Querying documents can be done by specifying __filters over exact values__. Whether the document gets returned is a __binary__ yes or no

---

## Analyzed search 

__Analyzed text__ is text data like  product_description or email_body

- Querying documents by searching analyzed text returns results based on __relevance__  (score)
- Highly complex operation and involves different __analyzer packages__ depending on the type of text data
- -  The default analyzer package is the _standard analyzer_ which splits text by word boundaries, lowercases and removes punctuation
- less performant than just filtering by exact values



## Two type of Query DSL:

1. Leaf query clause

   Look for a particulair field, such as **match**, **term** or **range**.

2. Compound query clause

   wrap other leaf(s) or compound queries and are used to combine multiple queries in a logical fashion (**bool** or **dis_max**)

   Or alter their behaviour (such as **constant_score**)



Queries behave different: **query context** or **filter context** (see below)



## Expensive queries

1. Lineair scans

   - script queries
2. high up-front
   - fussie queries
    - reqexp queries
    - prefix  queries without index_prefixes
    - wildcard  queries
    - range  queries on text and keyword fields
3. joinig queries

4. Queries on deprecated geo shapes

5. high per-document cost

   - script score queries
   - percolate queries

The execution of such queries can be prevented by setting the value of the `search.allow_expensive_queries` setting to `false` (defaults to `true`).



## Scoring queries

By default, Elasticsearch sorts matching search results by **relevance score**, which measures how well each document matches a query.

But depends if the query is executed in **query** or **filter** context



## => Query context

“*How well does this document match this query clause?*” The relevance is stored in the **_score** meta_field

Query context is in effect whenever query clause is passed to the query parameter.



## => Filter context

“*Does this document match this query clause?*” Answer is a true of false. No score is calculated.

Mostly used for filtering structured data, eq

- Does this timestamp fall in range....
- is the status field set to "text value"

Frequently used filters will be cached

Filter contect in effect when filter clause is used

- such as filter or must_not parameters in bool query
- filter parameter ins constant_score query
- filter aggregation

Example
```json
GET /_search
{
  "query": {    <= query context
    "bool": { 	<= query context, together with matches: how well they match documents
      "must": [
        { "match": { "title":   "Search"        }},
        { "match": { "content": "Elasticsearch" }}
      ],
      "filter": [ 	<= filter context
        { "term":  { "status": "published" }},
        { "range": { "publish_date": { "gte": "2015-01-01" }}}
      ]
    }
  }
}
```



---

## The Query DSL

Elasticsearch queries are comprised of one or many __query clauses__. Query clauses can be combined to create other query clauses, called __compound query clauses__. All query clauses have either one of these two formats:

```json
{
  QUERY_CLAUSE: {         // match, match_all, multi_match, term, terms, exists, missing, range, bool
    ARGUMENT: VALUE,
    ARGUMENT: VALUE,...
  }
}

{
  QUERY_CLAUSE: {
    FIELD_NAME: {
      ARGUMENT: VALUE,
      ARGUMENT: VALUE,...
    }
  }
}
```
Query clauses can be __repeatedly nested__ inside other query clauses

```json
{
  QUERY_CLAUSE {
    QUERY_CLAUSE: {
      QUERY_CLAUSE: {
        QUERY_CLAUSE: {
          ARGUMENT: VALUE,
          ARGUMENT: VALUE,...
        }
      }
    }
  }
}
```



## Compound queries

- bool query

  multiple leaf or compound query clauses 

  must, should => scores combined

  must_not, filter => in context filter

- boosting query

- constant_score query

- dis_max query

- function_score query









## Match Query Clause

Match query clause is the most generic and commonly used query clause:
- run on a analyzed text field, it performs an analyzed search on the text
- run on an exact value field, it performs a filter
- calculates the score

example:
```json
{ "match": { "description": "Fourier analysis signals processing" }}
{ "match": { "date": "2014-09-01" }}
{ "match": { "visible": true }}
```

## The Match All Query Clause

Returns all documemts
```json
{ "match_all": {} }
```

## Term/Terms Query Clause
The term and terms query clauses are used to **filter** by a exact value fields by single or multiple values, respectively. In the case of multiple values, the logical connection is OR.

```json
{
  "query": {
    "term": { "tag": "math" }
    }
}

{
  "query": {
    "term": { "tag": ["math", "second"] }
    }
}



```

##  Multi Match Query Clause
Is run across multiple fields instead of just one

```json
{ "query": {
  "multi_match": {
    "query": "probability theory",    // value
    "fields": ["title^3", "*body"],    // fields, with wildcard *
                                      // no fields == *
                                      // title 3* more important
    "type":       "best_fields",
    }
  }
}
```
[Other types](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-multi-match-query.html#multi-match-types)
## Exists and Missing Filters Query Clause
- The exists filter checks that documents have a value at a specified field
```json
{
  "query": {
   "exists": {
     "field": "*installCount"   // also with wildcards
   }
}
}
```
- The missing filter checks that documents do not have have a value at a specified field

```json
{
  "missing" : {
    "field" : "title"
  }
}
```

## Range Filter Query Clause
Number and date fields in ranges, using the operators gt gte lt lte
```json
{ "range" : { "age" : { "gt" : 30 } } }

{ 
  "range": {
    "born" : {
       "gte": "01/01/2012",
       "lte": "2013",
       "format": "dd/MM/yyyy||yyyy"
    }
  }
}
```

## Query in filter context
### No scores are calculated: yes or no
The __query__ parameter indicates query context.
The __bool__ and two __match__ clauses are used in query context, which means that they are used to score how well each document matches.
The __filter__ parameter indicates  	__*filter context*__. Its term and range clauses are used in filter context. They will filter out documents which do not match, but they will	__*not affect the score*__ for matching documents.
__Must__ clause is not required (score == 0.0)

```json
GET /.kibana/_search
{
  "query": {
    "bool": {
      "must": [
        {"match": {"type" : "ui-metric"}},
        {"match": {"ui-metric.count" : "1"}}
      ],
      "filter": [
        {"range": {"updated_at": {"gte": "2020-04-01"}}}
      ]
    }
  }
}
```

## Bool Query Clause
Are built from other query clauses are called compound query clauses. <sup> Note that compound query clauses can also be comprised of other compound query clauses, allowing for multi-layer nesting <sup>.

The three supported boolean operators are __must__ (and) __must_not__ (not) and __should__ (or)
```json
{
    "bool": {
        "must":     { "term": { "tag":    "math" }},
        "must_not": { "term": { "tag":    "probability"  }},
        "should": [
                    { "term": { "favorite": true   }},
                    { "term": { "unread":  true   }}
        ]
    }
}
```

## Combining Analyzed Search With Filters

Example: query to find all posts by performing an analyzed search for “Probability Theory” but we only want posts with 20 or more upvotes and not those with that tag “frequentist”.
```json
{
   "filtered": {
     "query": { "match": { "body": "Probability Theory" }},
     "filter": { 
        "bool": {
          "must": {
            "range":  { "upvotes" : { "gt" : 20 } } 
           },
          "must_not": { "term":  { "tag": "frequentist" } }
        }
     }
  }
}
```

[Source: Understanding the Elasticsearch Query DSL](https://medium.com/@User3141592/understanding-the-elasticsearch-query-dsl-ce1d67f1aa5b)