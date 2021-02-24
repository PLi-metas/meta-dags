SUMMARY = "player daemon helper"
MAINTAINER = "dags"

require conf/license/license-gplv2.inc

SRC_URI = "file://dags-libreader-hisi3798mv200.sh"

INITSCRIPT_NAME = "dags-libreader"
INITSCRIPT_PARAMS = "start 05 S ."

inherit update-rc.d

S = "${WORKDIR}"

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/dags-libreader-hisi3798mv200.sh ${D}${sysconfdir}/init.d/dags-libreader
}

COMPATIBLE_MACHINE = "^(dual)$"
