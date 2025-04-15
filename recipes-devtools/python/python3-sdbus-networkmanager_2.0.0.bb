DESCRIPTION = "NetworkManager binds for sdbus."
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[sha256sum] = "3572ac3a8189c683ec0416acb148761773a8f0881ad3d78b6d6f6864eff9c50b"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
        python3-sdbus \
"