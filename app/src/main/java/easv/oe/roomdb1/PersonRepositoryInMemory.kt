package easv.oe.roomdb1

import android.content.res.TypedArray

class PersonRepositoryInMemory : IPersonRepository {

    private val mPersons = mutableListOf<BEPerson>(BEPerson(1,"peter", 23))

    override fun getAll(): Array<BEPerson> = mPersons.toTypedArray()

    override fun getAllNames() = (mPersons.map { p -> "${p.id}, ${p.name}"}).toTypedArray()

    override fun add(p: BEPerson){
        mPersons.add(p.also{ it.id = mPersons.size+1})
    }

    override fun update(p: BEPerson) {
        val position = mPersons.indexOfFirst { it.id == p.id }
        if (position >= 0)
            mPersons[position] = p
    }

    override fun delete(p: BEPerson) {
        val position = mPersons.indexOfFirst { it.id == p.id }
        if (position >= 0)
            mPersons.removeAt(position)
    }

    override fun size() = mPersons.size

    override fun clear() = mPersons.clear()
}