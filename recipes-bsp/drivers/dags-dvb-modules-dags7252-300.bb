require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhdplus|tm4ksuper"

SRCDATE = "20190116"
KV = "3.14.28"

SRC_URI[md5sum] = "e066e8181db209cc2e3b87fb8944d5ed"
SRC_URI[sha256sum] = "d6d1036908bb922f70fc7158499ff07463671b033e9b05ac6aeb7bff4dfa5bc2"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
