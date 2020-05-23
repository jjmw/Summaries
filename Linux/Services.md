# Services


### list all services
service --status-all

### start - stop - pauze services
sudo service <package name> <start | off | pauze | .... >


### List services:
systemctl list-unit-files

### Statup time:
systemd-analyze blame