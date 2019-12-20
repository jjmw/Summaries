# Size File & Dirs

```bash
ls -l filename
```

lists the number of bytes

```bash
hexdump -C filename
```

lists the exact byte count and the non-printing characters as hex values

```bash
du filenaam
```

lists the number of blocks
The blocksize can be found with:

```bash
stat -f /dev/sda1
```

```bash
du
du ~/work   ## size work dir in bytes
du -a       ## all files in bytes
du -d 1     ## all files in dir 1 level deep
du --block=1 ## blocksize 1 will give the exact size of dirs and files
du ---block=1M   == du -m   ## size in megabytes
du -h       ## human readable disk space
du -h -s    ## summary
du --apparent-size  ## apparent size of the file  
du --apparent-size -s  ## summary
du --time -d 2   ## creation time or last modification
```

[source](https://www.howtogeek.com/450366/how-to-get-the-size-of-a-file-or-directory-in-linux/)