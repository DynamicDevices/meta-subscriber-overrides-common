SUMMARY = "Bleak is a GATT client software, capable of connecting to BLE devices acting as GATT servers."
HOMEPAGE = "https://github.com/hbldh/bleak"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bcbc2069a86cba1b5e47253679f66ed7"

SRCREV = "2fe1b69f89929ec95dbc8027fd58c47b7a1e3e0a"
PYPI_SRC_URI = "git://github.com/hbldh/bleak.git;protocol=https;branch=develop \
                file://01-remove-group-dependencies.patch \
"

inherit pypi python_poetry_core ptest

S = "${WORKDIR}/git"

SRC_URI += " \
	file://run-ptest \
"

RDEPENDS:${PN}-ptest += " \
	python3-pytest \
	python3-pytest-asyncio \
	python3-unittest-automake-output \
"

do_install_ptest() {
	install -d ${D}${PTEST_PATH}/tests
	cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}

RDEPENDS:${PN} += " \
	python3-core (>3.8) \
	python3-dbus-fast \
	python3-xml \
        python3-typing-extensions \
"
