package easv.oe.roomdb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PersonRepositoryInDB.initialize(this)
        insertTestData()

        refreshAdapter()

    }

    private fun insertTestData() {
        val mRep = PersonRepositoryInDB.get()
        mRep.insert(BEPerson(0,"Rip", 3))
        mRep.insert(BEPerson(0,"Rap", 3))
        mRep.insert(BEPerson(0,"Rup", 3))
    }

    private fun refreshAdapter() {
        val mRep = PersonRepositoryInDB.get()
        val nameObserver = Observer<List<String>>{ names ->
        val adapter: ListAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, names.toTypedArray()
        )
        lvNames.adapter = adapter
        }
        mRep.getAllNames().observe(this, nameObserver)
    }

    fun onClickInsert(view: View) {
        val mRep = PersonRepositoryInDB.get()
        mRep.insert(BEPerson(0, etName.text.toString(), 23))
        refreshAdapter()
    }

    fun onClickClear(view: View) {
        val mRep = PersonRepositoryInDB.get()
        mRep.clear()
        refreshAdapter()
    }
}