SUMMARY = "Installs the LGPIO driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SECTION = "drivers"

SRC_URI = " \
            http://abyz.me.uk/lg/lg.zip \
            "

SRC_URI[md5sum] = "ee8f96ea76b840022d67c0cbfd2382c6"
SRC_URI[sha256sum] = "bb31c6031b632911a4cbbd1d47ea326f1249b9f9efe1504eca83d1e0ef0394af"

INSANE_SKIP:${PN}:append = "already-stripped"

S = "${WORKDIR}/lg"

do_compile () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake
}
do_install () {
    oe_runmake install DESTDIR=${D}
}


FILES:${PN}=" \
    /usr \
    /usr/bin \
    /usr/include \
    /usr/local \
    /usr/lib \
    /usr/share \
    /usr/bin/rgpiod \
    /usr/bin/rgs \
    /usr/include/lgpio.h \
    /usr/include/rgpio.h \
    /usr/local/lib \
    /usr/local/lib/python3.10 \
    /usr/local/lib/python3.10/dist-packages \
    /usr/local/lib/python3.10/dist-packages/rgpio.py \
    /usr/local/lib/python3.10/dist-packages/__pycache__ \
    /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info \
    /usr/local/lib/python3.10/dist-packages/__pycache__/rgpio.cpython-310.pyc \
    /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info/not-zip-safe \
    /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info/top_level.txt \
    /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info/SOURCES.txt \
    /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info/dependency_links.txt \
    /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info/PKG-INFO \
    /usr/lib/liblgpio.so \
    /usr/lib/liblgpio.so.1 \
    /usr/lib/librgpio.so \
    /usr/lib/librgpio.so.1 \
    /usr/share/man \
    /usr/share/man/man1 \
    /usr/share/man/man3 \
    /usr/share/man/man1/rgs.1 \
    /usr/share/man/man1/rgpiod.1 \
    /usr/share/man/man3/rgpio.3 \
    /usr/share/man/man3/lgpio.3 \
    "