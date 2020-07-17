SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "${MACHINE}"

PV = "${KV}+${SRCDATE}"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}

do_populate_sysroot() {
}

do_install() {
		install -d ${D}${base_libdir}/modules/${KV}/extra
		for f in ${S}${base_libdir}/modules/${KV}/extra/*.ko; do
			install -m 0644 $f ${D}${base_libdir}/modules/${KV}/extra;
		done
		install -d ${D}/${sysconfdir}/modules-load.d
		for i in `ls ${D}${base_libdir}/modules/${KV}/extra | grep \\.ko | sed -e 's/.ko//g'`; do
		    echo $i _hwtype=\$hwtypenum >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
		done
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf ${base_libdir}/modules/${KV}/extra"
