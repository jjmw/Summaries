Files

## Get remote files

```python
from pyspark import SparkContext
from pyspark import SparkFiles
from pyspark.sql import SQLContext

url = "https://raw.githubusercontent.com/.../data/adult.csv"

sc = SparkContext()
sc.addFile(url)
spark = SQLContext(sc)

df = spark \
    .read \
    .csv(SparkFiles.get("adult.csv"),header=True,inferSchema=True)
df.printSchema()
```
