SUMMARY = "Multiboot for ${MACHINE}"
LICENSE = "CLOSED"
PRIORITY = "required"
SECTION = "base"

require conf/license/license-close.inc

PACKAGE_ARCH = "${MACHINE}"

PR = "20210223"

SRC_URI = "http://source.mynonpublic.com/dags/dags-bootoptions-${PR}.zip"

SRC_URI[md5sum] = "d57d0b2472f31b65c8b03592a5bbbbd8"
SRC_URI[sha256sum] = "0a65d449eb415771ca564a001b3ea55edc844fa435e04cbb5a38c69fdf5ff5d2"

S = "${WORKDIR}"

do_compile() {
}

do_install() {
	install -d ${D}/boot/
	install -m 0755 ${S}/STARTUP* ${D}/boot/
}

do_package_qa() {
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "/boot/"

COMPATIBLE_MACHINE = "^(dual)$"
