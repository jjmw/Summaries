# Startup disk

ddrescue

fdisk -l   		# find the ricght device ie dev/sdX
ddrescue bionic-desktop-amd64.iso /dev/sdX --force -D    	# create the startup dusk/usbstick