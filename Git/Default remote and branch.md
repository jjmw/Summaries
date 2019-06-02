Default remote and branch

```bash
cat .git/config    // wil list the remote and branch
git add .    // adds all modifications to the staging area
git commit -m "some text"  
git push  // puches all modifications to the upstream repository
```

### maak initieel een ssh key:
registreer de rsa.public key op de remote host
- ssh-keygen -t rsa


### Test de connectie:
- ssh -T [git@github.com](mailto:git@github.com)
- ssh -T [git@bitbucket.org](mailto:git@bitbucket.org)
voer een phrase password in

### Voor github:
maak de locale repository:
git clone ..... 