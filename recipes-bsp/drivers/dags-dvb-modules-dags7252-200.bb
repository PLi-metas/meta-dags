require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhd|tmtwin4k"

SRCDATE = "20190401"
KV = "3.14.28"

SRC_URI[md5sum] = "23275c9c854123365caf3334d38bbaed"
SRC_URI[sha256sum] = "71ff85e690d76bac3f10ae2bf63d01ad47037199841d603cd848b754fbf078c2"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-200mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
