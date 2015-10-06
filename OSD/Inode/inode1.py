import os
import sys,stat
filename=raw_input("Enter the name of file")
fl=os.open(filename,os.O_RDWR)
info=os.fstat(fl)

print "1. Size of file is",info.st_size
print "2. ID of device containing file ",info.st_dev
print "3. Inode number is",info.st_ino
print "4. Mode:(octal)",info.st_mode
print "5. Link count:",info.st_nlink
print "6. UID owner:",info.st_uid
print "7. GID owner:",info.st_gid
print "8. Preferred I/O block size:",info.st_blksize,"In Bytes"
print "9. File size:",info.st_size,"In Bytes"
print "10. Blocks allocated:",info.st_blocks,"In Bytes"
print "11. Time of last access:",info.st_atime
print "12. Time of last modification:",info.st_mtime
print "13. Time of status change:",info.st_ctime



if stat.S_ISREG(info.st_mode):
	print "REGULAR FILE"
elif stat.S_ISDIR(info.st_mode):
	print "DIRECTORY FILE"
elif stat.S_ISCHR(info.st_mode):
	print "CHARACTER FILE"
elif stat.S.ISBLK(info.st_mode):
	print "BLOCK FILE"
elif stat.S.ISFIFO(info.st_mode):
	print " FIFO FILE"
elif stat.S_ISLINK(info.st_mode):
	print " SYMBOLIC LINK"
elif stat.S_ISSOCK(info.st_mode):
	print " SOCKET"



