# SSH keys

## check current

```bash
 for keyfile in ~/.ssh/id_*; do ssh-keygen -l -f "${keyfile}"; done | uniq
 ```
 
 Ed25519 is intended to provide attack resistance comparable to quality 128-bit symmetric ciphers.
 
 
 ```bash
 ssh-keygen -o -a 100 -t ed25519
 ```
 
 result
 ```bash
 ~/.ssh/id_ed25519
 ```
 
 ### Change or set a passphrase
 
 ```bash
 ssh-keygen -f ~/.ssh/id_rsa -p -o -a 100
 ```
 
 [Source](https://blog.g3rt.nl/upgrade-your-ssh-keys.html)
