package easv.oe.roomdb1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BEPerson(
        @PrimaryKey(autoGenerate = true) var id:Int,
                                       var name: String,
                                        var age: Int)