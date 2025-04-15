FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append =  " \
                    file://dnsmasq.conf \
                    file://dnsmasq.service \
                    "

do_install:append() {
    install -m 0644 ${UNPACKDIR}/dnsmasq.conf ${D}${sysconfdir}
    install -m 0644 ${UNPACKDIR}/dnsmasq.service ${D}${systemd_unitdir}/system/dnsmasq.service
}