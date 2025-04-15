SUMMARY = "Command Line image with the Modifly Platform requirements installed"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"
IMAGE_INSTALL ?= " \
                    packagegroup-core-boot \
                    packagegroup-core-full-cmdline \
                    ${CORE_IMAGE_EXTRA_INSTALL} \
                    kernel-modules \
                    dnsmasq \
                    networkmanager \
                    tcpdump \
                    iproute2 \
                    react-app-next \
                    flask-server \
                    nodejs \
                    nodejs-npm \
                    setup-server \
                    "

ROOTFS_POSTPROCESS_COMMAND:append = " symlinkfunc"

symlinkfunc () {
    ln -sf /usr/lib/systemd/system/dhcp-monitor.timer ${IMAGE_ROOTFS}/usr/lib/systemd/system/timers.target.wants/dhcp-monitor.timer
    chown -R www-data:www-data ${IMAGE_ROOTFS}/usr/lib/node_modules/react-app-next/
    chown -R www-data:www-data ${IMAGE_ROOTFS}/opt/setup-server/
}

inherit core-image