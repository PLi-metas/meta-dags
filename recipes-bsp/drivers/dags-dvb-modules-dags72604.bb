require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force4"

SRCDATE = "20181205"
KV = "4.1.20"

SRC_URI[md5sum] = "8e230a4c78f899c0328ea92d97404010"
SRC_URI[sha256sum] = "3d22971a5ef36ca973d9ab0207855bdc24b995c4329126d45e99a869adbba88d"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_72604-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
