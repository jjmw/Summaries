# NVIDIA

## show installed video drivers

nvidia-smi

[Latest drivers](https://www.nvidia.com/Download/index.aspx?lang=en-us)

## list installed hw

lspci | grep -i nvidia
sudo lshw -numeric -C display

## find NVIDIA modules

find /usr/lib/modules -name nvidia.ko

## Settings

nvidia-settings

## monitoring nvidia

https://github.com/fbcotter/py3nvml


## successful NUMA node read from SysFS had negative value (-1), but there must be at least one NUMA node, so returning NUMA node zero

/sys/bus/pci/devices/0000:2b:00.0/numa_node

https://stackoverflow.com/questions/44232898/memoryerror-in-tensorflow-and-successful-numa-node-read-from-sysfs-had-negativ
