FILESEXTRAPATHS:prepend:class-target := "${THISDIR}/files:"
SRC_URI:append:class-target = " \
                   file://sources.list \
                   file://key1.gpg \
                   file://key2.gpg \
                   file://key3.gpg \
                   file://key4.gpg \
                   file://key5.gpg \
                   file://key6.gpg \
                   "


do_install:append:class-target () {
    install -d ${D}${sysconfdir}/apt/sources.list.d/
    install -d ${D}${sysconfdir}/apt/trusted.gpg.d/
    install -m 0644 ${WORKDIR}/sources-unpack/key1.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key1.gpg
    install -m 0644 ${WORKDIR}/sources-unpack/key2.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key2.gpg
    install -m 0644 ${WORKDIR}/sources-unpack/key3.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key3.gpg
    install -m 0644 ${WORKDIR}/sources-unpack/key4.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key4.gpg
    install -m 0644 ${WORKDIR}/sources-unpack/key5.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key5.gpg
    install -m 0644 ${WORKDIR}/sources-unpack/key6.gpg ${D}${sysconfdir}/apt/trusted.gpg.d/key6.gpg
    install -m 0644 ${WORKDIR}/sources-unpack/sources.list ${D}${sysconfdir}/apt/sources.list
}