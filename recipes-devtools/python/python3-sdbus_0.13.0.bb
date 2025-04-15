SUMMARY = "Modern Python library for the systemd D-Bus"
HOMEPAGE = "https://python-sdbus.readthedocs.io/en/latest/"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[sha256sum] = "801bd46608ee82614d42960c8ba8ae9300edb1bf5bbeb534bc8fd21f13d2c20e"

REQUIRED_DISTRO_FEATURES = "systemd"
DEPENDS += "systemd"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-numbers \
    python3-core \
"

inherit pypi setuptools3 features_check pkgconfig
