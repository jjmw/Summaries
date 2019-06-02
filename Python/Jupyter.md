Jupyter

### change theme
pip install jupyterthemes

jt -l     // list available themes

```bash
export PYSPARK_DRIVER_PYTHON="/home/john/environments/notebook/bin/ipython"
```

```python
# Import findspark when not pip install pyspark
import findspark

# Initialize and provide path
findspark.init("/home/john/opt/spark")
# or let spark find it
findspark.init()
```

https://towardsdatascience.com/introducing-jupytext-9234fdff6c57
https://github.com/mwouts/jupytext