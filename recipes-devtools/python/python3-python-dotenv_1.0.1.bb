DESCRIPTION = "Read key-value pairs from a .env file and set them as environment variables"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e914cdb773ae44a732b392532d88f072"

SRC_URI[sha256sum] = "e324ee90a023d808f1959c46bcbc04446a10ced277783dc6ee09987c37ec10ca"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
        python3-click \
        python3-ipython \
        python3-sh \
        python3-tox \
        python3-twine \
        python3-wheel \
"