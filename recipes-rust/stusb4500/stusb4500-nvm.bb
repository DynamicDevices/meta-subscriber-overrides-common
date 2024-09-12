FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SUMMARY = "STUSB4500 support data file"
HOMEPAGE = "git://github.com/Atmelfan/stusb4500-rs"

LICENSE = "MIT"

SRC_URI:imx8mm-jaguar-sentai = " file://stusb4500.dat"

do_install:imx8mm-jaguar-sentai() {
  install -d ${D}/${base_libdir}/firmware
  install -m 0644 ${WORKDIR}/stusb4500.dat ${D}/${base_libdir}/firmware
}

FILES:${PN}:imx8mm-jaguar-sentai = "${base_libdir}/firmware/stusb4500.dat"
