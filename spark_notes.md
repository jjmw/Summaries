# Apache Spark notes:


SparkContext is a Scala implementation entry point (Only one SparkContext may be active per JVM)
JavaSparkContext is a java wrapper of sparkContext. Returns org.apache.spark.api.java.JavaRDD
SQLContext is entry point of SparkSQL which can be received from sparkContex

Since Spark 2.x.x, All three data abstractions are unified and **SparkSession** is the unified entry point of Spark.
SparkSession: The entry point to programming Spark with the Dataset and DataFrame API.

Convert or create Context using Sparksession:
sparkSession.sparkContext() and for SQL, sparkSession.sqlContext()

```python
from pyspark.sql import SparkSession

spark = SparkSession \
    .builder \
    .appName('appname') \
    .getOrCreate()
```
