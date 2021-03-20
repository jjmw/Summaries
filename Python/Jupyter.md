# Jupyter

```bash
pip install jupyterthemes
```

```bash
jt -l     # list available themes
jupyter-kernelspec list
jupyter --paths  # will list all of the possible locations for everything it uses to run: kernels, extensions, pidfiles, etc.
```

```bash
jupyter notebook --ip=0.0.0.0 --port=8080 --no-browser
jupyter lab --ip=0.0.0.0 --port=8080  --no-browser
```

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

