FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append() {
    echo "net/ipv4/ip_forward=1" >> ${D}${sysconfdir}/sysctl.conf
}