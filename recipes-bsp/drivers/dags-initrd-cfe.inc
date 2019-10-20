SUMMARY = "2nd bootloader support"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "DAGS"
LICENSE = "proprietary"
PACKAGE_ARCH := "${MACHINE}"

require conf/license/license-gplv2.inc

ALLOW_EMPTY_${PN} = "1"

CHIPNAME ?= "7439b0"

inherit deploy
do_deploy() {
    if [ -e vmlinuz-initrd-${CHIPNAME}  ]; then
    install -m 0644 vmlinuz-initrd-${CHIPNAME}  ${DEPLOYDIR}/${MACHINE}_initrd_run.bin
    fi
}

SRC_URI = "http://en3homeftp.net/pub/down/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz"

S = "${WORKDIR}"

addtask deploy before do_build after do_install
