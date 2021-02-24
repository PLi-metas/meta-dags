require conf/license/license-gplv2.inc

SRC_URI = "\
	file://turnoff_power \
	file://hisi3798mv200-shutdown.sh \
	"

INITSCRIPT_NAME = "hisi3798mv200-shutdown"
INITSCRIPT_PARAMS = "start 39 0 ."

inherit pkgconfig update-rc.d

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/hisi3798mv200-shutdown.sh ${D}${sysconfdir}/init.d/hisi3798mv200-shutdown
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/turnoff_power ${D}${bindir}
}

pkg_preinst_${PN}_prepend() {
#!/bin/sh
if [ -z "$D" ]; then
    chmod -x $D${sysconfdir}/init.d/hisi3798mv200-shutdown
fi
}

pkg_postinst_${PN}_append() {
#!/bin/sh
chmod 755 $D${sysconfdir}/init.d/hisi3798mv200-shutdown
}

pkg_prerm_${PN}() {
#!/bin/sh
exit 0
}

COMPATIBLE_MACHINE = "^(dual)$"
