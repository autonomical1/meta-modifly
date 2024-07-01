FILESEXTRAPATHS:prepend := "${THISDIR}/files/cfg:"
SRC_URI += "file://usb-net-qmi-wwan.cfg"

# Ensure FILES variables are properly set
FILES_${PN} = "${libdir}/modules/${KERNEL_VERSION}/kernel"
FILES_${PN}-dev = "${includedir}"
FILES_${PN}-dbg += "${libdir}/modules/${KERNEL_VERSION}/kernel/.debug"
FILES_${PN}-base = ""

# Add exclusion for qmi_wwan module
EXCLUDE_FROM_FILES += "/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/usb/qmi_wwan.ko"

# Ensure qmi_wwan is not installed
do_install:append() {
    rm -f ${D}${libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/usb/qmi_wwan.ko
}

