require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhdplus|tm4ksuper|lunix3-4k|galaxy4k"

SRCDATE = "20190424"
KV = "3.14.28"

SRC_URI[md5sum] = "ecd7d4fe488d7a19ba73754d5fc3254d"
SRC_URI[sha256sum] = "6bc8df8c26a451948619eca17939d6a2a65f2ef5681b9b609fd66c5b06c8e8d7"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
