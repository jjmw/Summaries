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
