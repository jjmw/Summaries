# Virtulenv

[latest doc](https://virtualenvwrapper.readthedocs.io/en/latest/command_ref.html)


#### remove virtual environment
rmvirtualenv name

#### create virtual environment
mkvirtualenv -p python3.6 name

#### switch virtual environmen
workon name

#### List all of the environments.
lsvirtualenv

#### Navigate into the directory of the currently activated virtual environment,
cdvirtualenv

#### so you can browse its site-packages, for example.
cdsitepackages

#### Like the above, but directly into site-packages directory.
lssitepackages
Shows contents of site-packages directory. 

* * *

## Anaconda
#### Om python3.5 environment te creeeren
conda create -n py35 python=3.5 anaconda     
source activate py35
source deactivate
