SUMMARY = "Installs service files to run first time setup server"
LICENSE = "CLOSED"

SRC_URI = " \
            file://flask-app.service \
            file://next-js.service \
            file://dhcp-lease-check.service \
            file://dhcp-monitor.sh \
            file://dhcp-monitor.timer \
            "

RDEPENDS:${PN}:append = " bash"
do_install () {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${UNPACKDIR}/flask-app.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${UNPACKDIR}/next-js.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${UNPACKDIR}/dhcp-lease-check.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${UNPACKDIR}/dhcp-monitor.timer ${D}${systemd_unitdir}/system/
    
    install -d ${D}/usr/local/bin/
    install -m 0755 ${UNPACKDIR}/dhcp-monitor.sh ${D}/usr/local/bin/dhcp-monitor.sh
}

FILES:${PN} = " \
                /usr \
                /usr/lib \
                /usr/local \
                /usr/lib/systemd \
                /usr/lib/systemd/system \
                /usr/lib/systemd/system/dhcp-lease-check.service \
                /usr/lib/systemd/system/dhcp-monitor.timer \
                /usr/lib/systemd/system/next-js.service \
                /usr/lib/systemd/system/flask-app.service \
                /usr/local/bin \ 
                /usr/local/bin/dhcp-monitor.sh \
                "