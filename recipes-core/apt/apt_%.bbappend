FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " \
                   file://sources.list \
                   file://coral-edgetpu.list \
                   file://apt-key.gpg \
                   file://key1.gpg \
                   file://key2.gpg \
                   file://key3.gpg \
                   file://key4.gpg \
                   file://key5.gpg \
                   file://key6.gpg \
                   "


do_install:append () {
    install -d ${D}${sysconfdir}/apt/sources.list.d/
    install -m 0644 ${WORKDIR}/coral-edgetpu.list ${D}${sysconfdir}/apt/sources.list.d/coral-edgetpu.list
    install -d ${D}${sysconfdir}/apt/trusted.gpg.d/
    install -m 0644 ${WORKDIR}/apt-key.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/apt-key.gpg
    install -m 0644 ${WORKDIR}/key1.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key1.gpg
    install -m 0644 ${WORKDIR}/key2.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key2.gpg
    install -m 0644 ${WORKDIR}/key3.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key3.gpg
    install -m 0644 ${WORKDIR}/key4.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key4.gpg
    install -m 0644 ${WORKDIR}/key5.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key5.gpg
    install -m 0644 ${WORKDIR}/key6.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key6.gpg
    install -m 0644 ${WORKDIR}/sources.list ${D}${sysconfdir}/apt/sources.list
}
