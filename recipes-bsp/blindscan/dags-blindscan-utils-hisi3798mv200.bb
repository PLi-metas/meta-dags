DESCRIPTION = "Utils for blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "^(dual)$"

PACKAGES = "dags-blindscan-utils-${SOC_FAMILY}"

PROVIDES += "virtual/blindscan-dvbs"
RPROVIDES_dags-blindscan-utils-${SOC_FAMILY} += "virtual/blindscan-dvbs"

SRC_URI = "http://en3homeftp.net/pub/down/dags_blindscan_${SOC_FAMILY}.tar.gz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d "${D}${bindir}"
	install -m 0755 "${S}/dags_blindscan_${SOC_FAMILY}" "${D}${bindir}/dags_blindscan"
}

FILES_${PN} = "${bindir}/dags_blindscan"

SRC_URI[md5sum] = "326941a796c21deb8938f714502c7f60"
SRC_URI[sha256sum] = "3c9f208da566cd4bd60766f7884358e8765aa11129a78c79ec5cec7f903b39c6"
