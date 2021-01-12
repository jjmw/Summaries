# Bash

PROMPT_COMMAND='echo -n "writing the prompt at " && date'

HISTTIMEFORMAT='I ran this at: %d/%m/%y %T '

## CDPATH

As with the PATH variable, the CDPATH variable is a colon-separated list of paths. When you run a cd command with a relative path (ie one without a leading slash), by default the shell looks in your local folder for matching names. CDPATH will look in the paths you give it for the directory you want to change to.

If you set CDPATH up like this:

```bash
CDPATH=/:/lib
```

Then typing in:

```bash
cd /home
cd tmp
```

will always take you to /tmp no matter where you are.

Watch out, though, as if you don’t put the local (.) folder in the list, then you won’t be able to create any other tmp folder and move to it as you normally would:

$ cd /home
$ mkdir tmp
$ cd tmp
$ pwd
/tmp

Oops!

This is similar to the confusion I felt when I realised the dot folder was not included in my more familiar PATH variable… but you should do that in the PATH variable because you can get tricked into running a ‘fake’ command from some downloaded code.

Correct way:

```bash
CDPATH=.:/space:/etc:/var/lib:/usr/share:/opt
```

### Restart terminal

```bash
exec "$SHELL"
```

### SHLVL

This variable tracks how deeply nested you are in the bash shell. 

```bash
echo $SHLVL
```

### LINENO
reports the number of commands that have been run in the session so far.

### TMOUT

If nothing is typed in for the number of seconds this is set to, then the shell will exit.
