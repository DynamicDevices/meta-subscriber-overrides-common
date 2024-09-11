SUMMARY = "ST USB 4500 support"
HOMEPAGE = "git://github.com/Atmelfan/stusb4500-rs"

LICENSE = "MIT"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/DynamicDevices/stusb4500-rs.git;protocol=https;branch=main"
SRCREV="dde400805838bfb44c31bb4ddb4021959b0d282a"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3570cec030817fca048fd7f61219a588"

EXTRA_CARGO_FLAGS = "--examples"
