require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhdplus|tm4ksuper"

SRCDATE = "20190401"
KV = "3.14.28"

SRC_URI[md5sum] = "2a7c6a5c2715fffcfe36090c048bf2b4"
SRC_URI[sha256sum] = "937c6afdc2b29113549f4c3c776a2ee162b47b20879b840fe729f3b0da852608"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
