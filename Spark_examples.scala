// first full example

val flightData2015 = spark
  .read
  .option("inferSchema","True")
  .option("header","True")
  .csv("/FileStore/tables/2015_summary-ebaee.csv")

spark.conf.set("spark.sql.shuffle.partitions", "5")

flightData2015.take(4)

flightData2015.createOrReplaceTempView("Data2015")

spark.sql("""select DEST_COUNTRY_NAME, count(*) as telling from Data2015 group by DEST_COUNTRY_NAME order by 2 desc limit 5""").show()

import org.apache.spark.sql.functions.desc
flightData2015
  .groupBy("DEST_COUNTRY_NAME")
  .sum("count")
  .withColumnRenamed("sum(count)","aantal")
  .sort(desc("aantal"))
  .limit(5)
  .show()
// ============================





