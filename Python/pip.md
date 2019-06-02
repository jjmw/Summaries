pip


[pip install documentation](https://pip.pypa.io/en/stable/reference/pip_install/#id18)

### upgrade pip. watch -m parameter "run module as an module"
python3 -m pip install -U pip

pip uninstall < package-name >

<https://pypi.org/>
pip search <package you want to search for> // also multiple packages

pip install < package-name >

pip show < package-name >

### update all packages
sudo pip install -U $(pip freeze | awk '{split($0, a, "=="); print a[1]}')

### install specific (not latest version)
pip install  <package-name>==version

### latest version
pip list --outdated --format=columns
pip-check

### dump current packages, with version number
pip freeze > requirements.txt

### install or upgrade
pip install -r requirements.txt
pip install --upgrade -r requirements.txt

### requirements.txt contains ie:
Flask==0.12
click==4.1
requests==2.13.0

### logical operators can be used
certifi>=2018.11.29
chardet>=3.0.4

### new versions of packages are not always backwards compatible!!!!!!!

pip list | grep bleach | xargs sudo pip uninstall -y