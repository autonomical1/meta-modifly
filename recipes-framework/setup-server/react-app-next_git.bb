LICENSE = "Apache-2.0 & LGPL-3.0-or-later & MIT"
LIC_FILES_CHKSUM = " \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
                    file://${COMMON_LICENSE_DIR}/LGPL-3.0-or-later;md5=c51d3eef3be114124d11349ca0d7e117 \
                    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    git://git@github.com/Edward-Serna/flask-python-app.git;protocol=ssh;branch=yocto-testing;subpath=react-app-next; \
    "



SRCREV = "${AUTOREV}"

S = "${WORKDIR}/${BPN}"

DEPENDS = "nodejs nodejs-native glibc"

do_compile[network] = "1"
do_compile:prepend() {
    # Clear any existing modules that might have wrong architecture
    rm -rf ${S}/node_modules ${S}/.package-lock.json
}

do_compile () {
    export HOME=${S}
    npm set cache ${S}/npm-cache
    npm cache clean --force
    npm --cpu=arm64 --verbose install
    npm --cpu=arm64 run build
}

do_install () {
    install -d ${D}/usr/lib/node_modules
    cp -r ${S}/node_modules ${D}/usr/lib/

    install -d -m 0755 ${D}/usr/lib/node_modules/react-app-next

    cp -r ${S}/public ${D}/usr/lib/node_modules/react-app-next
    cp -r ${S}/src ${D}/usr/lib/node_modules/react-app-next
    cp -r ${S}/.next ${D}/usr/lib/node_modules/react-app-next
    install -m 0775 ${S}/next.config.mjs ${D}/usr/lib/node_modules/react-app-next/next.config.mjs
    install -m 0775 ${S}/package.json ${D}/usr/lib/node_modules/react-app-next
}

FILES:${PN} = " \
            /opt \
            /opt/setup-server \
            /opt/setup-server/react-app-next \
            /usr/ \
            /usr/lib \
            /usr/lib/node_modules \
            /usr/lib/node_modules/* \
"

INSANE_SKIP:${PN} += "already-stripped ldflags file-rdeps arch buildpaths"
