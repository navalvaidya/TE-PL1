import os,sys

if(os.path.exists("/boot/efi") or os.path.exists("/sys/firmware/efi")):
	print "\nThis computer boots with UEFI mode\n"
else:
	print "\nThis computer boots with Legacy BIOS mode\n"

