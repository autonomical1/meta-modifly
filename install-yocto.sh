#!/bin/bash

sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 python3-subunit zstd liblz4-tool file locales libacl1
sudo locale-gen en_US.UTF-8

mkdir /opt/yocto/
cd /opt/yocto/

git clone https://git.yoctoproject.org/poky -b scarthgap
git clone https://github.com/openembedded/meta-openembedded -b scarthgap
git clone https://git.yoctoproject.org/meta-tensorflow
git clone https://git.yoctoproject.org/meta-raspberrypi -b scarthgap
git clone https://git.yoctoproject.org/meta-arm -b scarthgap
git clone https://github.com/NobuoTsukamoto/meta-tensorflow-lite
git clone https://github.com/autonomical1/meta-modifly.git

ls -la

source poky/oe-init-build-env
mv ../meta-modifly/conf-transfer/local.conf build/conf/local.conf
mv ../meta-modifly/conf-transfer/bblayers.conf build/conf/bblayers.conf
bitbake core-image-full-cmdline
        
