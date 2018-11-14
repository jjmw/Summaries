# notes

psql DBNAME USERNAME

\d              \\ list all relations
\d tablename    \\ ddl




sudo -u postgres CREATEUSER <username>
sudo -u postgres CREATEDB <datebasename>

psql# ALTER USER <username> WITH ENCRYPTED PASSWORD '<password>';
psql# GRANT ALL PRIVILEGES ON DATABASE <databasename> to <username>;





## In jupyter:
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