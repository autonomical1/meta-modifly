DESCRIPTION = "Microsoft Azure Blob Storage Client Library for Python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ee51f94efd0db5b258b5b1b8107fea02"

SRC_URI = "https://files.pythonhosted.org/packages/8b/f3/f764536c25cc3829d36857167f03933ce9aee2262293179075439f3cd3ad/azure_storage_blob-12.25.1.tar.gz"
SRC_URI[sha256sum] = "4f294ddc9bc47909ac66b8934bd26b50d2000278b10ad82cc109764fdc6e0e3b"

inherit pypi python_setuptools_build_meta
PYPI_PACKAGE="azure-storage-blob"