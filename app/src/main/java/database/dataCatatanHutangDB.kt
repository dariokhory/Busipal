package database

import android.provider.BaseColumns

object dataCatatanHutangDB {
    class dataCatatanHutangTable: BaseColumns{
        companion object{
            val TABLE_DATA_CATATAN_HUTANG = "Data Catatan Hutang"
            val COLUMN_ID = "_id"
            val COLUMN_NAME = "nama"
            val COLUMN_NOMINAL = "nominal"
            val COLUMN_TANGGAL = "tanggal"
            val COLUMN_KETERANGAN = "keterangan"
        }
    }
}