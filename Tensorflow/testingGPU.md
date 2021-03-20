### list devices CPU, GPU

```python
tf.config.experimental.list_physical_devices("GPU")
from tensorflow.python.client import device_lib
print(device_lib.list_local_devices())
```


### Init GPU; disable experimentals
```python
physical_devices = tf.config.list_physical_devices('GPU') 
tf.config.experimental.set_memory_growth(physical_devices[0], True)
tf.config.experimental.disable_mlir_graph_optimization()
tf.config.experimental.enable_tensor_float_32_execution(enabled=True)
```

### assign memory to GPU
```python
gpus = tf.config.experimental.list_physical_devices("GPU")

if gpus:
    # Restrict TensorFlow to only allocate 22GB of memory on the first GPU

    try:
        tf.config.experimental.set_virtual_device_configuration(
            gpus[0],
            [tf.config.experimental.VirtualDeviceConfiguration(memory_limit=7000)],
        )

        logical_gpus = tf.config.experimental.list_logical_devices("GPU")

        print(len(gpus), "Physical GPUs,", len(logical_gpus), "Logical GPUs")
    except RuntimeError as e:
        # Virtual devices must be set before GPUs have been initialized
        print(e)
```
