package com.zalocoders.onlinemenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.zalocoders.onlinemenu.ExpandableListData.data
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener{

    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        seeOrders.setOnClickListener(this)
        clearOrders.setOnClickListener(this)



        if (expanded_menu != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expanded_menu!!.setAdapter(adapter)
            expanded_menu!!.setOnGroupExpandListener { groupPosition ->

            }
            expanded_menu!!.setOnGroupCollapseListener { groupPosition ->

            }
            expanded_menu!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->

                addToOrdersDialog(
                    listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition)
                )

                false
            }
        }


        expandAll()
    }

    //method to expand all groups
    private fun expandAll() {
        val count: Int = adapter?.getGroupCount()!!
        for (i in 0 until count) {
            expanded_menu.expandGroup(i)
        }
    }


    private fun addToOrdersDialog(itemName:String){

        val builder: AlertDialog.Builder = AlertDialog.Builder(this);
        builder.setTitle("Add to Orders")
        builder.setMessage("Do you want to Add $itemName to your Order ?")
        builder.setNegativeButton("Cancel"){
            dialogInterface , which ->
                Toast.makeText(applicationContext,"Canceled",Toast.LENGTH_LONG).show()

        }
        builder.setPositiveButton("Add"){
            dialogInterface, i ->
            Toast.makeText(applicationContext,"$itemName added to orders",Toast.LENGTH_LONG).show()

        }


        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

    override fun onClick(view: View?) {

        if (view != null) {

            when(view.id){

                R.id.seeOrders -> {

                    val intent = Intent(this,MyOrdersActivity::class.java)
                    startActivity(intent)
                }
                R.id.clearOrders -> {

                    Toast.makeText(applicationContext,"Your orders have been cleared successfully",Toast.LENGTH_LONG).show()

                }
            }
        }
    }

}