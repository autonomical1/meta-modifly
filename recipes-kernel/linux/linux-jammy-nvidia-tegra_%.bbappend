FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://ath11k.cfg \
    file://mac80211.cfg \
    file://iwlwifi.cfg \
    file://r8169.cfg \
    file://em7595.cfg \
    file://tpm2.cfg \
    "
