SUMMARY = "Install the Modifly Controller application"
LICENSE = "CLOSED"

SRC_URI = " \
            file://mf-controller \
            file://system.mpk \
            file://modifly.service \
            file://controller.toml \
            file://encrypt/enc_kp \
            file://encrypt/enc_kp.pub \
            file://encrypt/modifly-dev-rootca.pem \
            file://encrypt/modifly-dev.localhost.crt \
            file://encrypt/modifly-dev.localhost.key \
            "
DEPENDS = "boost curl openssl"
RDEPENDS:${PN}:append = "boost-filesystem boost-thread libcurl libssl"

do_install() {
    install -d ${D}/usr/bin/
    install -d ${D}/etc/modifly/config
    install -d 0700 ${D}/etc/modifly/pki/
    install -d ${D}${systemd_unitdir}/system/

    install -m 0755 ${UNPACKDIR}/controller.toml ${D}/etc/modifly/config/controller.toml
    install -m 0644 ${UNPACKDIR}/modifly.service ${D}${systemd_unitdir}/system/modifly.service


    install -m 0755 ${UNPACKDIR}/mf-controller ${D}/usr/bin/
    install -m 0755 ${UNPACKDIR}/system.mpk ${D}/usr/bin/

    install -m 0600 ${UNPACKDIR}/encrypt/modifly-dev.localhost.key ${D}/etc/modifly/pki/
    install -m 0600 ${UNPACKDIR}/encrypt/enc_kp ${D}/etc/modifly/pki/
    install -m 0644 ${UNPACKDIR}/encrypt/enc_kp.pub ${D}/etc/modifly/pki/
    install -m 0644 ${UNPACKDIR}/encrypt/modifly-dev.localhost.crt ${D}/etc/modifly/pki/
    install -m 0644 ${UNPACKDIR}/encrypt/modifly-dev-rootca.pem ${D}/etc/modifly/pki/
}

FILES:${PN} = " \
                /usr/bin/ \
                /etc/modifly/config/ \
                /etc/modifly/pki/ \
                /usr/lib/systemd/system/ \
                "

INSANE_SKIP:append = "file-rdeps"