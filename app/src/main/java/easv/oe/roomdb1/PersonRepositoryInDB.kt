package easv.oe.roomdb1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.concurrent.Executors

class PersonRepositoryInDB private constructor(context: Context) {

    private val database: PersonDatabase = Room.databaseBuilder(context.applicationContext,
                                                                PersonDatabase::class.java,
                                                        "person-database").build()

    private val personDao = database.personDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun getAll(): LiveData<List<BEPerson>> = personDao.getAll()

    fun getAllNames(): LiveData<List<String>> = personDao.getAllNames()

    fun insert(p: BEPerson) {
        executor.execute{ personDao.insert(p) }
    }

    fun update(p: BEPerson) {
        executor.execute { personDao.update(p) }
    }

    fun delete(p: BEPerson) {
        executor.execute { personDao.delete(p) }
    }

    fun clear() {
        executor.execute { personDao.deleteAll() }
    }

    companion object {
        private var Instance: PersonRepositoryInDB? = null

        fun initialize(context: Context) {
            if (Instance == null)
                Instance = PersonRepositoryInDB(context)
        }

        fun get(): PersonRepositoryInDB {
            if (Instance != null) return Instance!!
            throw IllegalStateException("Person rep not initialized")
        }
    }
    // end of companion object
}