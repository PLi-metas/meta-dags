SUMMARY = "Platform Util drivers for ${STB_PLATFORM}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PV = "17.1"

SRC_URI = "\
	http://en3homeftp.net/pub/down/platform-util-${STB_PLATFORM}.tar.gz \
	file://${INITSCRIPT_NAME}.sysvinit \
	"

S = "${WORKDIR}/platform-util-${STB_PLATFORM}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/* ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME}.sysvinit ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

do_package_qa() {
}

FILES_${PN}="/"

inherit update-rc.d

INITSCRIPT_PARAMS = "start 65 S . stop 90 0 ."
INITSCRIPT_NAME = "dags-platform-util"
