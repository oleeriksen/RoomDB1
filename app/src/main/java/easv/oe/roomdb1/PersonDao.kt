package easv.oe.roomdb1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {

    @Query("SELECT * from BEPerson order by id")
    fun getAll(): LiveData<List<BEPerson>>

    @Query("SELECT name from BEPerson order by name")
    fun getAllNames(): LiveData<List<String>>

    @Insert
    fun insert(p: BEPerson)

    @Update
    fun update(p:BEPerson)

    @Delete
    fun delete(p:BEPerson)

    @Query("DELETE from BEPerson")
    fun deleteAll()
}