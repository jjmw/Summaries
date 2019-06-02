jdbc

### method a load drivers
```python
import os
os.environ['PYSPARK_SUBMIT_ARGS'] = '--jars file:/home/john/opt/jars/postgresql-42.2.5.jar pyspark-shell'
```

### method b load drivers
```bash
pyspark \
--packages org.postgresql:postgresql:42.2.5 \
--driver-class-path /home/john/opt/jars/postgresql-42.2.5.jar
```

alone driver-class-path is also OK

```python
from pyspark.sql import DataFrameReader, SparkSession

spark = SparkSession.builder \
    .master("local") \
    .appName("jdbc data sources") \
    .config("spark.sql.shuffle.partitions", "4") \
    .getOrCreate()
```

### method 1
```python
df_company = (
    spark.read.format("jdbc")
    .option("url", "jdbc:postgresql://172.17.0.2/postgres")
    .option("dbtable", "public.company")
    .option("user", "postgres")
    .option("password", "qw12aap")
    .option("driver", "org.postgresql.Driver")
    .load()
)
df_company.show()
```

### method 2
```python
dataframe = (
    spark.read.format("jdbc")
    .options(
        url="jdbc:postgresql://172.17.0.2/postgres?user=postgres&password=qw12aap",
        database="public",
        dbtable="company",
        driver="org.postgresql.Driver"
    )
    .load()
)
dataframe.show()
```
