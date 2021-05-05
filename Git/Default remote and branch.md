# GIT

## Default remote and branch

```bash
cat .git/config    // wil list the remote and branch
git add .    // adds all modifications to the staging area
git commit -m "some text"  
git push  // push all modifications to the upstream repository
```

### make initial ssh key:
### register the rsa.public key on remote host
```bash
ssh-keygen -t rsa
```

### add global username and email address
```bash
git config --global user.name "Your Name"
git config --global user.email "youremail@yourdomain.com"
```
### Test connection

- ssh -T [git@github.com](mailto:git@github.com)
- ssh -T [git@bitbucket.org](mailto:git@bitbucket.org)
enter a phrase password