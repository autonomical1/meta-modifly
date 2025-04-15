# Once transitioning to Jetson, change file name to linux_tegra_%.bbappend
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://ath11k.cfg \
    file://mac80211.cfg \
    file://iwlwifi.cfg \
    "

