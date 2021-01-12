# Postgresql

![postgresql](https://d1q6f0aelx0por.cloudfront.net/product-logos/a28dcd12-094d-4248-bfcc-f6fb954c7ab8-postgres.png?)


psql DBNAME USERNAME
\d              \\ list all relations
\d tablename    \\ ddl

```bash
sudo -u postgres CREATEUSER <username>
sudo -u postgres CREATEDB <datebasename>
```

```psql
psql# ALTER USER <username> WITH ENCRYPTED PASSWORD '<password>';
psql# GRANT ALL PRIVILEGES ON DATABASE <databasename> to <username>;
```

## create csv file

```sql
COPY (SELECT * FROM "public".empbase) TO '/tmp/empbase.csv' WITH CSV header;
```

### Jupyter:
> first install:
> ipython-sql and psycopg2

```jupyter
* %load_ext sql
* %sql postgresql://john:****@localhost/testdb
* %%sql
  - select * from aap;
```

## From python program

```python
import psycopg2
query = "select * from aap"

try:
    conn = psycopg2.connect("postgres://john:qw12aap@localhost:5432/testdb")
except psycopg2.OperationalError as e:
    print('Unable to connect!\n{0}').format(e)
    sys.exit(1)
finally:
    print("connected")

cur = conn.cursor()
cur.execute(query)
for x in cur.fetchall():
    print(x)
cur.close()
conn.close()
```

[Source PostgreSQL](https://www.postgresql.org/files/documentation/pdf/11/postgresql-11-A4.pdf)

## Connection from Apache Spark example:

```scala
val driver = "org.postgresql.Driver"
Class.forName(driver)

val df =  spark.sqlContext
    .read
    .format("jdbc")
    .options(Map("url"->"jdbc:postgresql://172.17.0.2:5432/postgres", "user"->"postgres","password"->"qw12aap","driver"->driver,"dbtable"->"company"))
    .load()
```

## Install Docker

<https://hackernoon.com/dont-install-postgres-docker-pull-postgres-bee20e200198>
<https://docs.databricks.com/spark/latest/data-sources/sql-databases.html>

## create persistant storage location

```bash
mkdir -p $HOME/docker/volumes/postgres
```

## launch docker container

```bash
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres
```

## connect to running container

```bash
docker exec -it  pg-docker /bin/bash
```

## inside container

```bash
psql -h localhost -U postgres -d postgres
```

[Postgresql tutorial](https://www.tutorialspoint.com/postgresql)

# notes

psql DBNAME USERNAME

\d              \\ list all relations
\d tablename    \\ ddl

sudo -u postgres CREATEUSER <username>
sudo -u postgres CREATEDB <datebasename>

psql# ALTER USER <username> WITH ENCRYPTED PASSWORD '<password>';
psql# GRANT ALL PRIVILEGES ON DATABASE <databasename> to <username>;

## create csv file:

```sql
COPY (SELECT * FROM "public".empbase) TO '/tmp/empbase.csv' WITH CSV header;
```

## In jupyter

> first install:
> ipython-sql and psycopg2

Use:

* %load_ext sql
* %sql postgresql://john:****@localhost/testdb
* %%sql
 - select * from aap;

## From python program

```python
import psycopg2
query = "select * from aap"

try:
    conn = psycopg2.connect("postgres://john:qw12aap@localhost:5432/testdb")
except psycopg2.OperationalError as e:
    print('Unable to connect!\n{0}').format(e)
    sys.exit(1)
finally:
    print("connected")

cur = conn.cursor()
cur.execute(query)
for x in cur.fetchall():
    print(x)
cur.close()
conn.close()
```

sources:
https://www.postgresql.org/files/documentation/pdf/11/postgresql-11-A4.pdf

## Connection from Apache Spark example:

```scala
val driver = "org.postgresql.Driver"
Class.forName(driver)

val df =  spark.sqlContext
    .read
    .format("jdbc")
    .options(Map("url"->"jdbc:postgresql://172.17.0.2:5432/postgres", "user"->"postgres","password"->"qw12aap","driver"->driver,"dbtable"->"company"))
    .load()
```
