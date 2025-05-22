SUMMARY = "Command Line image with the Modifly Platform requirements installed"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"
IMAGE_INSTALL = " \
                    packagegroup-core-boot \
                    packagegroup-core-full-cmdline \
                    ${CORE_IMAGE_EXTRA_INSTALL} \
                    users \
                    kernel-modules \
                    gnupg \
                    dnsmasq \
                    apt \
                    modemmanager \
                    dhcpcd \
                    iproute2 \
                    ethtool \
                    tcpdump \
                    networkmanager \
                    iw \
                    libmbim \
                    libqmi \
                    hostapd \
                    wpa-supplicant \
                    react-app-next \
                    flask-server \
                    nodejs \
                    nodejs-npm \
                    setup-server \
                    modifly-controller \
                    usbutils \
                    pciutils \
                    iputils \
                    nano \
                    linux-firmware \
                    iptables \
                    python3-pip \
                    libgpiod \
                    libgpiod-tools \
                    kernel-module-spidev \
                    spidev-test \
                    tpm2-openssl \
                    dtc \
                    "

# Tegra-specific modules
IMAGE_INSTALL:append = " \
                        tegra-firmware \
                        tegra-libraries-core \
                        tegra-nvfancontrol \
                        tegra-nvstartup \
                        tegra-nvpower \
                        tegra-redundant-boot \
                        tegra-tools \
                        "

#### 
#### Change Modifly Controller to Modifly Platform
####
ROOTFS_POSTPROCESS_COMMAND:append = " symlinkfunc"

symlinkfunc () {
    ln -sf /usr/lib/systemd/system/dhcp-monitor.timer ${IMAGE_ROOTFS}/usr/lib/systemd/system/timers.target.wants/dhcp-monitor.timer
    ln -sf /usr/lib/systemd/system/modifly.service ${IMAGE_ROOTFS}/usr/lib/systemd/system/multi-user.target.wants/modifly.service
    ln -sf /dev/null ${IMAGE_ROOTFS}/usr/lib/systemd/network/99-default.link
    chown -R www-data:www-data ${IMAGE_ROOTFS}/usr/lib/node_modules/react-app-next/
    chown -R www-data:www-data ${IMAGE_ROOTFS}/opt/setup-server/

    chown -R usl:usl ${IMAGE_ROOTFS}/etc/modifly/
}

inherit core-image
