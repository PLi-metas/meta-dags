SUMMARY = "libreader for Dags ${SOC_FAMILY}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} = "libsdl"

COMPATIBLE_MACHINE = "^(dual)$"

SRCDATE = "20210312"

PV = "${SRCDATE}"

SRC_URI = "http://en3homeftp.net/pub/down/hisi3798mv200-libreader-${SRCDATE}.tar.gz"

SRC_URI[md5sum] = "0a2b311348d5c460af09b10b43fd2ffb"
SRC_URI[sha256sum] = "1c15df936d5766e397cb4792eee3ff1279ba09530de23e720b9907d2ae6c1d9f"

S = "${WORKDIR}"

do_compile() {
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/app_init ${D}${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/app_init"
