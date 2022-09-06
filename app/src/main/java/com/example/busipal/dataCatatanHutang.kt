package com.example.busipal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class dataCatatanHutang: Parcelable {

    var id: Int = 0
    var nama: String = ""
    var nominalUang: String = ""
    var tanggal: String = ""
    var keterangan: String = ""
}