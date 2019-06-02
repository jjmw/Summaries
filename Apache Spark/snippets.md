snippets


```python
df_main.join(df_sub,['finr','belastingjaar'],'left').filter(df_sub["element"].isin(20,30)).drop("element").groupBy('finr','belastingjaar').sum("waarde22").show()

df_main.join(df_sub,['finr','belastingjaar'],'left').filter(df_sub["element"].isin(10,20)).show()
```

```python
df = spark.createDataFrame ([
("a", 1, 10, "m1"), ("a", 1, 10, "m2"), ("a", 1, 30, "m3"),
("a", 1, 11, "m4")],
("a", "b", "cnt", "major"))
df.show()

reshaped_df = df.groupby('a','b').pivot('major').max('cnt').fillna(0)
reshaped_df.show()
```
