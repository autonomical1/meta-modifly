SUMMARY = "Installs and configures Modifly's custom \
        first-time setup server using Python3, Flask, and React \
        "

LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
                    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    "

SRC_URI = " \
            git://git@github.com/Edward-Serna/flask-python-app.git;branch=main;protocol=ssh;subpath=flask-server; \
            "

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/sources-unpack/flask-server"

DEPENDS = " python3"

RDEPENDS:${PN} = " \
                    python3-blinker \
                    python3-click \
                    python3-flask \
                    python3-flask-cors \
                    python3-importlib-metadata \
                    python3-itsdangerous \
                    python3-jinja2 \
                    python3-markupsafe \
                    python3-pydbus \
                    python3-python-dotenv \
                    python3-sdbus \
                    python3-sdbus-networkmanager \
                    python3-zipp \
"

do_install[network] = "1"
do_install:append () {
    install -d ${D}/opt/setup-server/
    cp -r ${S}/* ${D}/opt/setup-server
}

RDEPENDS:${PN}:append = " bash"

FILES:${PN} = " \
                /opt \
                /opt/setup-server \
                /opt/setup-server/* \
                "