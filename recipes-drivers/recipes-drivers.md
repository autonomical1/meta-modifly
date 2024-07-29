# Information

This set of recipes configures the lgpio library and the Sierra Wireless Module drivers.

## lgpio

This fetches `lg.zip` from the specified source, builds with GNU Make, and installs the necessary header and out files into the correct directory. 
It may be required to reconfigure the patch in `files/` as I set it up for my specific image. It could be different for another host system. 

## sierra

This ships with the tarball provided by Sierra, extracts it, and builds the proper files. It then installs the proper driver files into the target directory. It is considered a kernel module since it changes a file in the `kernel/drivers/` directory. 

