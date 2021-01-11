# Pyenv & Pipenv

## Installing Pyenv

```bash
git clone https://github.com/pyenv/pyenv.git ~/.pyenv
echo 'export PYENV_ROOT="$HOME/.pyenv"' >> ~/.bashrc
echo 'export PATH="$PYENV_ROOT/bin:$PATH"' >> ~/.bashrc
```

```bash
pyenv versions         # list installed python versions
pyenv install --list   # list all available versions for installation
pyenv install <python_version>    # install a version
pyenv uninstall <python_version>   
pyenv global <python_version>     # set version globally
pyenv local <python_version>      # set the file .python-version with version 3.8.2
pyenv shell <python_version>      # set PYENV_VERSION environment variable as current
pyenv virtualenv <python_version> <environment_name>    # create environment

pyenv local <environment_name>    # activate enviroment
pyenv activate <environment_name> # the same as above

pyenv deactivate
```

## Using pipenv

### Install

pip install --user --upgrade pipenv

### Usage

```bash
cd project_directory
pipenv --python <python_version> install     ## install python in this dir

```

### Pipfile

This is where we will keep of application requirements rather than using requirements.txt

```bash
pipenv install fastapi uvicorn
```

Install some packages and the Pipfile is created with the packages added to Pipfile. By default, Pipenv will always install the newest versions of packages.

```text
[[source]]
name = "pypi"
url = "https://pypi.org/simple"
verify_ssl = true

[dev-packages]

[packages]
fastapi = "*"
uvicorn = "*"

[requires]
python_version = "3.7"
```
Other file created is Pipfile.lock and is super important because it does two things:

- Provides good security by keeping a hash of each package installed.
- Pins the versions of all dependencies and sub-dependencies, giving you replicable environments.


To install development packages just pass the --dev argument. Like

```bash
pipenv install --dev ptpython
pipenv update      ## update the packages
```

By default, pipenv install will **ONLY** install the base packages that should live on production. This is what we want. Passing the --dev parameter will allow us to install base AND dev packages locally or during the CI process.

```bash
pipenv shell    # Launching subshell in virtual environment…
pip list        # lists all install packages and version
pipenv check    # check for vulnerabilities (Checking PEP 508 requirements)
```


## cheatsheet

```bash
pipenv shell    # Activate
python --version    # Check version of Python

python      # Check path
>>> import sys
>>> sys.executable
quit()

pipenv install camelcase    # Install a package
pipenv lock -r      # Check local packages
pipenv uninstall camelcase  # Uninstall a package
pipenv install nose --dev   # Install a dev package
pipenv install -r ./requirements.txt    # Install from requirements.txt
pipenv check    # Check security vulnerabilities
pipenv graph    # Check dependency graph
pipenv install --ignore-pipfile     # Ignore pipfile
pipenv lock     # Set lockfile - before deployment
exit    Exiting the virtualenv
pipenv run *    # Run with pipenv
```

[Source 1](https://dev.to/writingcode/the-python-virtual-environment-with-pyenv-pipenv-3mlo)

[Source 2](https://hackernoon.com/reaching-python-development-nirvana-bb5692adf30c)

[github pipenv](https://github.com/pypa/pipenv)