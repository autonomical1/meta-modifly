SUMMARY = "Installs the LGPIO driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SECTION = "drivers"

SRC_URI = " \
            http://abyz.me.uk/lg/lg.zip \
            file://0001-cross-compile-strip.patch \
            "

SRC_URI[md5sum] = "ee8f96ea76b840022d67c0cbfd2382c6"
SRC_URI[sha256sum] = "bb31c6031b632911a4cbbd1d47ea326f1249b9f9efe1504eca83d1e0ef0394af"

INSANE_SKIP:${PN}:append = "already-stripped"

S = "${WORKDIR}/lg"

EXTRA_OECONF = "--host=${HOST_SYS} --build=${BUILD_SYS}"

EXTRA_OEMAKE = "CC=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-gcc CXX=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-g++ \
                CFLAGS='${CFLAGS} --sysroot=${STAGING_DIR_TARGET}' \
                LDFLAGS='${LDFLAGS} --sysroot=${STAGING_DIR_TARGET}'"

CFLAGS:append = " -fPIC"
CXXFLAGS:append = " -fPIC"

do_compile () {
    oe_runmake
}
do_install () {
    oe_runmake install DESTDIR=${D}
}

FILES:${PN} = " \
  /usr/local \
  /usr/local/lib \
  /usr/bin \
  /usr/bin/rgpiod \
  /usr/bin/rgs \
  /usr/lib/liblgpio.so.1 \
  /usr/lib/librgpio.so.1 \
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
  /usr/local/lib/python3.10/dist-packages/rgpio-0.2.2.0.egg-info/PKG-INFO  \
"
