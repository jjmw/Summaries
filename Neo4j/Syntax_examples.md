## show dabase schema
call db.schema.visualization()
call db.schema.relTypeProperties
call db.schema.nodeTypeProperties


## show node with name "Tom Hanks"
MATCH (tom {name: "Tom"}) RETURN tom
## return all nodes in database
MATCH (a:Person) WHERE a.name = "Tom" RETURN a
MATCH (a:Person) RETURN a.name

## with where clause
match (a:Movie)
where a.released >= 1990 and a.released < 1999
return a.title;


##  a list of all properties that match a string
MATCH (n) WITH keys(n) AS p UNWIND p AS x WITH DISTINCT x WHERE x =~ ".*" RETURN collect(x) AS SET;
  
## delete all nodes and relations
MATCH (n)
DETACH DELETE n

