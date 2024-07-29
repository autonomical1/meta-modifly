# Information

This set of recipes configures apt, systemd, and the userspace. 

## apt
We import signed keys from the Debian keyring to properly authenticate the repositories in order for a working and configurable auto-update system. 

The `sources.list` file contains the links to the Debian repository containing the packages needed to maintain a Linux image. 

## systemd
This configures the network, allowing for WiFi connection as well as Ethernet. 

### !!! 
To allow for network connectivity, edit the `*.network` files in `systemd-conf/files/` to configure static IPs (or DHCP). 

## users
This enables the user `usl` on the system with sudo permissions, and a salted password which allows for added security. SSH is also enabled at this point as well. 