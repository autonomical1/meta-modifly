DESCRIPTION = "Microsoft Azure Storage Management Client Library for Python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e848d080178fb2d08b67acc5ba80b9fd"

SRC_URI = "https://files.pythonhosted.org/packages/2f/e7/1f6a1384a77513c0d636ae411e169d22433a07fd146c8b8b7d6027f90dbb/azure_mgmt_storage-22.1.1.tar.gz"
SRC_URI[sha256sum] = "25aaa5ae8c40c30e2f91f8aae6f52906b0557e947d5c1b9817d4ff9decc11340"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE="azure-mgmt-storage"

RDEPENDS:${PN} += "\
        python3-asyncio \
"