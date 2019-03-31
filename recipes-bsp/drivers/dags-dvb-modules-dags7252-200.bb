require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhd|tmtwin4k"

SRCDATE = "20190319"
KV = "3.14.28"

SRC_URI[md5sum] = "5061cee0befb457bc00839b73a14cd80"
SRC_URI[sha256sum] = "f10632bf246ff46906a43e5881392bc8db77636887765bd431e8436ca6b776ce"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-200mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
