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

### available wifi networks
nmcli connection show

### which DNS server in use:
( nmcli dev list || nmcli dev show ) 2>/dev/null | grep DNS
nm-tool | grep DNS
