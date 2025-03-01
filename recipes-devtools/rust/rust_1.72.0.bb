require rust-target.inc
require rust-source-${PV}.inc
require rust-snapshot-${PV}.inc

LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=c2cccf560306876da3913d79062a54b9"

INSANE_SKIP_${PN}_class-native = "already-stripped"

do_compile () {
    rust_runx build --stage 2
}

rust_do_install() {
    rust_runx install
}

python () {
    pn = d.getVar('PN')

    if not pn.endswith("-native"):
        raise bb.parse.SkipRecipe("Rust recipe doesn't work for target builds at this time. Fixes welcome.")
}

