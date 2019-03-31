require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhdplus|tm4ksuper"

SRCDATE = "20190319"
KV = "3.14.28"

SRC_URI[md5sum] = "07403873f7e88b7d26d5f39a7b60a5aa"
SRC_URI[sha256sum] = "8e5e664fd63d6944aa72a1491fffc77a4983cd20325ebaa74c088c763058d846"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
