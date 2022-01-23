package com.soopeach.droidcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.soopeach.droidcafe.databinding.ActivityMainBinding
import com.soopeach.droidcafe.databinding.ActivityOrderBinding
import com.soopeach.droidcafe.databinding.ContentMainBinding


class MainActivity : AppCompatActivity() {

    private var mbinding : ContentMainBinding? = null
    private val binding get() = mbinding!!

    lateinit var mOrderMessage : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mbinding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    public fun onClick(view: View?) {
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("EXTRA_MESSAGE", mOrderMessage)
        startActivity(intent)
    }

    public fun displayToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    /*
    shows a message that the donut image was clicked
     */
    public fun showDonutOrder(view : View){
        mOrderMessage = getString(R.string.donut_order_message)
        displayToast(mOrderMessage)
    }

    public fun showIceCreamOrder(view : View){
        mOrderMessage = getString(R.string.ice_cream_order_message)
        displayToast(mOrderMessage)
    }

    public fun showFroyoOrder(view : View){
        mOrderMessage = getString(R.string.froyo_order_message)
        displayToast(mOrderMessage)
    }

    override fun onDestroy() {
        mbinding = null
        super.onDestroy()
    }






}