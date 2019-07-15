Cheat Sheat

### Python, Spark setting

```bash
# Spark home for full install
export SPARK_HOME="/usr/local/spark/"
# Set a fixed value for the hash seed secret
export PYTHONHASHSEED=0
# Set an alternate Python executable
export PYSPARK_PYTHON=/usr/local/ipython/bin/ipython
# Augment the default search path for shared libraries
export LD_LIBRARY_PATH=/usr/local/ipython/bin/ipython
# Augment the default search path for private libraries 
export PYTHONPATH=$SPARK_HOME/python/lib/py4j-*-src.zip:$PYTHONPATH:$SPARK_HOME/python/
```

### Initializing SparkSession

```python
from pyspark.sql import SparkSession
spark = SparkSession
    .builder
    .appName("Python Spark SQL basic example")
    .config("spark.executor.memory", "1gb")
    .config("spark.some.config.option", "some-value")
    .getOrCreate

sc = spark.sparkContext
```

### Creating DataFrames

```python
from pyspark.sql.types import *

# Infer Schema
sc = spark.sparkContext
lines = sc.textFile("people.txt")
parts = lines.map(lambda l: l.split(","))
people = parts.map(lambda p: Row(name=p[0],age=int(p[1])))
df_people = spark.createDataFrame(people)

# Specify Schema
people = parts.map(lambda p: Row(name=p[0],age=int(p[1].strip())))
schemaString = "name age"
fields = [StructField(field_name, StringType(), True) for field_name in schemaString.split()]
schema = StructType(fields)
spark.createDataFrame(people, schema).show()
```

### From Spark Data Sources

```python
# JSON
df = spark.read.json("customer.json")
df2 = spark.read.load("people.json", format="json")

# Parquet files
df3 = spark.read.load("users.parquet")

# TXT files
df4 = spark.read.text("people.txt")
```

 | Inspect Data | Inspect Data          |
 | ------------ | --------------------- |
 | df.types     | df.describe().show()  |
 | df.show()    | df.columns            |
 | df.head()    | df.count()            |
 | df.first()   | df.distinct().count() |
 | df.take(2)   | df.printSchema()      |
 | df.schema    | df.explain()          |

### Duplicate Values

```python
df = df.dropDuplicates()
```

### Queries

```python
from pyspark.sql import functions as F

# Select
df.select('firstName',
    'lastName',
    explode('phoneNumber').alias('contactInfo'),
    "adddress.type",  # type of address column
    df['age'] + 10
    ).show()

# When
# Show firstName and 0 or 1 depending on age > 30
df.select("firstName",F.when(df.age > 30, 1).otherwise(0)).show()
# Show firstName if in the given options
df[df.firstName.isin("Jane","Boris")].collect()
df1.withColumn("new column",when(df1["major"] == "J",1).otherwise(0)).show()

# Like
df.select("firstName", df.lastName.like("Smith")).show()

# Startswith - Endswith
df.select("firstName", df.lastName.startswith("Sm")).show()
df.select(df.lastName.endswith("th")).show()

# Substring
df.select(df.firstName.subs(1,3).alias("name"))

# Between
df.select(df.age.between(22, 24))
```

### Add, Update, Remove Columns

```python
# Adding Columns
from pyspark.sql.types import *
df = df.withColumn('city',df.address.city)
    .withColumn('postalCode',df.address.postalCode)
    .withColumn('state',df.address.state) .withColumn('streetAddress',df.address.streetAddress)
    .withColumn('telePhoneNumber', explode(df.phoneNumber.number))
    .withColumn('telePhoneType', explode(df.phoneNumber.type))
    .withColumn("medianHouseValue", df["medianHouseValue"].cast(FloatType())

from pyspark.sql.functions import add_months,current_date, year, dayofmonth, when
df2.select(add_months(df2.dt, 1).alias('next_month')).collect()
df3 = df2.withColumn("day",dayofmonth(current_date()))
df3.withColumn("year",when(year(current_date()) < 2020,year(current_date())).otherwise(2020)).show()

# Updating Column ame
df = df.withColumnRenamed('telePhoneNumber', 'phoneNumber')

# Removing Columns
df = df.drop("address", "phoneNumber")
df = df.drop(df.address).drop(df.phoneNumber)

# GroupBy
df.groupBy("age").count()

# Filter
df.filter(df["age"]>24)

# Sort
peopledf.sort(peopledf.age.desc())
df.sort("age", ascending=False)
df.orderBy(["age","city"],ascending=[0,1])

# Missing & Replacing Values
df.na.fill(50)
df.na.drop()
df.na.replace(10,20)

# Repartitioning
df.repartittion(10).rdd.getNumPartitions()  # df with 10 partitions
df.coalesce(1).rdd.getNumPartitions()       # df with 1 partions
```

### Running SQL Queries Programmatically

```python
# Registering DataFrames & Query as Views
df.createOrReplaceTempView("customer")
df.createTempView("customer")
df5 = spark.sql("SELECT * FROM customer")

peopledf.createGlobalTempView("people")
peopledf2 = spark.sql("SELECT * FROM global_temp.people")
```

### Output

```python
# Data Structures
rdd1 = df.rdd
df.toJSON().first()
df.toPandas()

# Write & Save to Files
df.select("firstName", "city").write.save('someName.parquet')
df.select("firstName", "age").write.save('someName.json',format='json')
```
