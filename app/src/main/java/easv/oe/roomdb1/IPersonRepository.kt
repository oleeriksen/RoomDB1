package easv.oe.roomdb1

interface IPersonRepository {

    fun getAll(): Array<BEPerson>

    fun getAllNames(): Array<String>

    fun add(p: BEPerson)

    fun update(p: BEPerson)

    fun delete(p: BEPerson)

    fun clear()

    fun size(): Int
}