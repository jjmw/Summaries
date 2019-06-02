# New Repo

## New repository when local reposity is created first

**remote:**
create remote repository in regular way, with *remoteRepoName*

**local:**
```bash
git init
git add .
git commit -m 'Init version'
git remote add origin <ssh://git@bitbucket.org/gitbucketwillems59/**remoteRepoName**.git>
git pull origin master --allow-unrelated-histories   // merge remote with local
git push origin master    // simply push to repository
```

---

- maak de locale repository:
- git clone .....

---

- Edit .gitignore to match the file you want to ignore
- git rm --cached /path/to/file
- [sample ignore files for languages](https://github.com/github/gitignore)

---