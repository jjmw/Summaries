Remve unused


### install 
sudo apt install deborphan

### run terminal version
deborphan

### To remove the orphaned packages, run:
sudo orphaner

### graphical version
sudo apt install gtkorphan
sudo gtkorphan

### Alternative 
sudo apt autoclean && sudo apt autoremove
dpkg --remove <name>

### check broken dependencies
sudo apt-get check

### search
apt-cache search [string1 stringn]

### list all available packages and search
apt-cache pkgnames
apt-cache search <packagename>

### get package info
apt-cache show <packagename>

### dependencies
apt-cache showpkg  <packagename>

### statistics
apt-cache stats

### distro update
sudo apt-get dist-upgrade
sudo apt-get install <packageName> --only-upgrade

### install specific version
sudo apt-get install vsftpd=2.3.5-3ubuntu1

### remove without removing configurations
sudo apt-get remove <packageName>

### remove configurations
sudo apt-get purge <packageName>

### remove package and configuration
sudo apt-get remove --purge <packageName>

### cleanup diskspace
sudo apt-get clean

### check log off a package
sudo apt-get change log <packageName>


### Get Debian version:
lsb_release -a

### Disk info
sudo hdparm -I /dev/sda1

### which kernels are installed?
dpkg --list | grep linux-image

sudo dpkg -i  <package name.deb>

sudo dpkg --remove <package name>

sudo add-apt-repository 'deb <https://typora.io/linux> ./'


### Create and install rpm installation package
sudo alien packagename.rpm
sudo dpkg -i packagename.deb