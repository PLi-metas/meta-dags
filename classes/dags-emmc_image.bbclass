inherit image_types

IMAGE_TYPEDEP_dagsemmc = "ext4"

do_image_dagsemmc[depends] = " \
    parted-native:do_populate_sysroot \
    dosfstools-native:do_populate_sysroot \
    mtools-native:do_populate_sysroot \
    virtual/kernel:do_populate_sysroot \
    android-tools-native:do_populate_sysroot \
    dags-buildimage-native:do_populate_sysroot \
    "

IMAGE_CMD_dagsemmc () {
    rm -rf ${IMGDEPLOYDIR}/rootfs
    rm -rf ${IMGDEPLOYDIR}/rootfs_sub
    rm -rf ${IMGDEPLOYDIR}/rootfs_sub.ext4

    mkdir -p ${IMGDEPLOYDIR}/rootfs
    mkdir -p ${IMGDEPLOYDIR}/rootfs/linuxrootfs1
    mkdir -p ${IMGDEPLOYDIR}/rootfs/linuxrootfs2
    mkdir -p ${IMGDEPLOYDIR}/rootfs/linuxrootfs3
    mkdir -p ${IMGDEPLOYDIR}/rootfs/linuxrootfs4
    mkdir -p ${IMGDEPLOYDIR}/rootfs/lost+found
    echo "${MACHINE}'s ${IMAGE_ROOTFS}" >/tmp/${MACHINE}-image-log
    ls -la "${IMAGE_ROOTFS}" >> /tmp/${MACHINE}-image-log
    cp -fr --preserve=links,mode ${IMAGE_ROOTFS}/* ${IMGDEPLOYDIR}/rootfs/linuxrootfs1/
    echo "Using ${IMGDEPLOYDIR}/rootfs/linuxrootfs1" >> /tmp/${MACHINE}-image-log
    /usr/bin/fakeroot ls -la "${IMGDEPLOYDIR}/rootfs/linuxrootfs1/" >> /tmp/${MACHINE}-image-log
    eval local COUNT=\"0\"
    eval local MIN_COUNT=\"60\"
    if [ $ROOTFS_SIZE -lt $MIN_COUNT ]; then
        eval COUNT=\"$MIN_COUNT\"
    fi

    /usr/bin/fakeroot make_ext4fs -s -l 6968M ${IMGDEPLOYDIR}/${IMAGE_NAME}_subrootfs.ext4 ${IMGDEPLOYDIR}/rootfs
}
