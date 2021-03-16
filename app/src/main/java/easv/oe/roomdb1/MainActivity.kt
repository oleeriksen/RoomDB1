package easv.oe.roomdb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRep = PersonRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshAdapter()

    }

    private fun refreshAdapter() {
        val adapter: ListAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, mRep.getAllNames()
        )
        lvNames.adapter = adapter
    }

    fun onClickInsert(view: View) {
        mRep.add(BEPerson(0, etName.text.toString(), 23))
        refreshAdapter()
    }

    fun onClickClear(view: View) {
        mRep.clear()
        refreshAdapter()
    }
}