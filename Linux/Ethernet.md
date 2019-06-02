Ethernet

### Change mac address:
macchanger <device>  -r

### local ip address:
hostname -I

### public ip address:
curl ipinfo.io/ip

### scan local network
sudo arp-scan --interface=enp4s0 --localnet

```bash
sudo service network-manager restart
sudo vi [/etc/dhcp/dhclient.conf](file:///etc/dhcp/dhclient.conf)
```
edit "prepend domain-name-servers" for DNS servers

### Monitor wifi
wavemon