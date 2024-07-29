# Introduction

This is the *meta-modifly* layer to build the ModiflyPlatform onto a embedded Linux image.

Yocto works in a layer-based system. Each layer contains recipes (metadata that tells the build system what to download, where to put it, and how to configure it). The *meta-modifly* layer contains 3 sets of recipes. 

### recipes-core

This set of recipes takes care of system dependencies and configurations, including configuring the userspace, apt repositories, and systemd (for networking). Refer to the recipes-core info file [here](recipes-core/recipes-core.md).

### recipes-drivers

This set of recipes takes care of fetching, installing, and configuring the drivers required for certain components of the platform. Refer to the recipes-drivers info file [here](recipes-drivers/recipes-drivers.md).

### recipes-framework

This set of recipes contains the framework recipe file to install and configure ModiflyPlatform. It fetches the git repository from the private repository (this requires extra setup), configures, builds, and installs the binaries into the proper directory. Refer to the recipes-framework info file [here](recipes-framework/modiflyplatform.md).

# System Requirements

The Yocto build system requires immense processing power, RAM, and storage to optimally build images. 

- Ubuntu 20.04+
- 32+ cores
- 32+ GB RAM
- 350 GB of storage or greater
- 25 MB/s internet connection

# Configuration

To get started with the Yocto build system, install Poky, the Yocto layer that contains the recipes necessary to get a barebones Linux image up and running. Layers that are compatible with the Yocto Project are available [here](https://layers.openembedded.org/layerindex/branch/scarthgap/layers/)

This is the location of all of the Yocto Metadata Layers: (https://git.yoctoproject.org)

(7-29-2024) Scarthgap is the most current version of Yocto

```
mkdir /opt/yocto/
cd /opt/yocto/

git clone https://git.yoctoproject.org/poky.git -b scarthgap
```

At this point, you can also install the other layers required to build Yocto properly.

```
git clone https://github.com/openembedded/meta-openembedded -b scarthgap

git clone https://git.yoctoproject.org/meta-tensorflow

git clone https://git.yoctoproject.org/meta-raspberrypi -b scarthgap

git clone https://git.yoctoproject.org/meta-arm -b scarthgap

git clone https://github.com/NobuoTsukamoto/meta-tensorflow-lite
```

Once all of these layers have been cloned, you can begin setting up the build environment.

```
cd poky/
source oe-init-build-env
```

After sourcing the script, you will be placed into the `build/` directory. Here is where many important files remain, including the `conf/local.conf` and `conf/bblayers.conf` file.

### local.conf/bblayers.conf

Navigate to the `conf-transfer/` directory in this repository and replace the `local.conf` and `bblayers.conf` file into the `/opt/yocto/poky/build/conf/` directory. This file contains the configuration for the build process, including the system type and directory/package configurations. 

# Building

After completing all of the steps required to configure your system for Yocto, you can now begin to start building a Yocto image. 

Sourcing the `oe-init-build-env` file allows you to use the `bitbake` utility. This allows you to begin building/configuring the image. 

This command will allow the build process to begin: 
```
bitbake core-image-full-cmdline
```

Once building completes, depending on what machine you set in `local.conf`, there will be a few different ways to start it up. 

By default, the image builds as a QEMU Arm-based image, but you can reconfigure it for different embedded board types. For example, if using the Raspberry Pi, you would change the `MACHINE` variable in `local.conf` to `MACHINE ??= "raspberrypi*"`.

If building for QEMU, you can run the `runqemu` command to run a virtualized image to test (`slirp` allows for networking).
```
runqemu qemuarm64 slirp
```

# Final notes
To disable ssh, find the `EXTRA_IMAGE_FEATURES` line in `conf/local.conf` and delete `debug_tweaks`. This also disables root login.

To see environment variables while building, use this command:

```
bitbake -e <image> | grep ^<variable to find>
```
