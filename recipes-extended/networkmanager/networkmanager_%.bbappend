LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"



SRC_URI:append = " \
                file://eth0.nmconnection \
                file://eth1.nmconnection \
                file://dns-servers.conf \
"


do_install:append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections/
    install -d ${D}${sysconfdir}/NetworkManager/conf.d/

    install -m 0600 ${WORKDIR}/sources-unpack/eth0.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
    install -m 0600 ${WORKDIR}/sources-unpack/eth1.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
    install -m 0600 ${WORKDIR}/sources-unpack/dns-servers.conf ${D}${sysconfdir}/NetworkManager/conf.d/dns-servers.conf
}

FILES:${PN}:append = " \
                ${sysconfdir}/NetworkManager/system-connections/eth0.nmconnection \
                ${sysconfdir}/NetworkManager/system-connections/eth1.nmconnection \
                ${sysconfdir}/NetworkManager/conf.d/dns-servers.conf\
"