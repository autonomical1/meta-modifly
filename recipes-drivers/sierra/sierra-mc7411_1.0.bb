SUMMARY = "Installs the Sierra Wireless MC7411/7421 LTE Wireless Drivers" 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SECTION = "drivers"

inherit module

SRC_URI = "file://MBPL_DRIVERS_R35_ENG4-usb-src.tar.gz"

SRC_URI[md5sum] = "a47316b48ed7f5fd3f84554f5e708c44"
SRC_URI[sha256sum] = "cc05729658822b340672105fc6a6e24ec2c07b705e5161a68667963060c537af"

S = "${WORKDIR}/usb"

KERNEL_SRC = "${STAGING_KERNEL_DIR}"
KERNEL_BUILD = "${STAGING_KERNEL_BUILDDIR}"

EXTRA_OEMAKE = 'KERNELDIR=${KERNEL_SRC}'

RPROVIDES:${PN} = "kernel-module-sierra-mc7411"

FILES:${PN} = " \
                /usr/lib/modules/6.6.23-yocto-standard/modules.alias.bin \
                /usr/lib/modules/6.6.23-yocto-standard/modules.alias \
                /usr/lib/modules/6.6.23-yocto-standard/modules.devname \
                /usr/lib/modules/6.6.23-yocto-standard/modules.dep \
                /usr/lib/modules/6.6.23-yocto-standard/modules.symbols \
                /usr/lib/modules/6.6.23-yocto-standard/modules.builtin.bin \
                /usr/lib/modules/6.6.23-yocto-standard/modules.softdep \
                /usr/lib/modules/6.6.23-yocto-standard/modules.symbols.bin \
                /usr/lib/modules/6.6.23-yocto-standard/modules.dep.bin \
                /usr/lib/modules/6.6.23-yocto-standard/modules.builtin.alias.bin \
                "


do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake -C ${S} KERNEL_SRC=${STAGING_KERNEL_DIR} KERNEL_BUILD=${STAGING_KERNEL_BUILDDIR}
}

do_install () {
    install -d ${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/usb/
    install -d ${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/usb/serial/
    install -m 0644 ${S}/qcserial.ko ${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/usb/serial/
    install -m 0644 ${S}/usb_wwan.ko ${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/usb/serial/
    install -m 0644 ${S}/qmi_wwan.ko ${D}/usr/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/usb/

}

do_install:append () {
    depmod -a -b ${D}/usr ${KERNEL_VERSION}
}

