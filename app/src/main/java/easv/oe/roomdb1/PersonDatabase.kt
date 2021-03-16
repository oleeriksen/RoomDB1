package easv.oe.roomdb1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BEPerson::class], version=1)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao
}