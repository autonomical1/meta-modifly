LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " modemmanager dnsmasq wifi wwan"
SRC_URI:append = " \
                file://dns-servers.conf \
                file://NetworkManager.conf \
                file://eth0.nmconnection \
                file://eth1.nmconnection \
                file://usl-gw.nmconnection \
                file://wwan0.nmconnection \
"


do_install:append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections/
    install -d ${D}${sysconfdir}/NetworkManager/conf.d/

    install -m 0600 ${WORKDIR}/sources-unpack/eth0.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
    install -m 0600 ${WORKDIR}/sources-unpack/eth1.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
    install -m 0600 ${WORKDIR}/sources-unpack/usl-gw.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
    install -m 0600 ${WORKDIR}/sources-unpack/wwan0.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
    install -m 0644 ${WORKDIR}/sources-unpack/dns-servers.conf ${D}${sysconfdir}/NetworkManager/conf.d/
    install -m 0644 ${WORKDIR}/sources-unpack/NetworkManager.conf ${D}${sysconfdir}/NetworkManager/
}


FILES:${PN}:append = " \
                ${sysconfdir}/NetworkManager/conf.d/dns-servers.conf\
"