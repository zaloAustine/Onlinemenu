package com.zalocoders.onlinemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MyOrdersActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)


    }

    private fun addToOrdersDialog(itemName:String){

        val builder: AlertDialog.Builder = AlertDialog.Builder(this);
        builder.setTitle("Complete Orders")
        builder.setMessage("Do you want to Add complete of total ${itemName} your Order ?")
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
                R.id.complete->addToOrdersDialog("400")
                R.id.clearOrders -> Toast.makeText(this,"Cleared orders",Toast.LENGTH_SHORT).show()
            }
        }
    }

}