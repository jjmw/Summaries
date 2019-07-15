# Spark configuation options

SPARK_LOCAL_IP  environment variable

```bash
SPARK_LOCAL_IP=127.0.0.1 ./bin/spark-shell
```

In a program set the bindAddress

```scala
val config = new SparkConf()
config.setMaster("local[*]")
config.setAppName("Test App")
config.set("spark.driver.bindAddress", "127.0.0.1")
val sc = new SparkContext(config)
```
