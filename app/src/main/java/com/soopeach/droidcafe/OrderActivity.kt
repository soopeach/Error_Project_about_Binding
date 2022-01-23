package com.soopeach.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soopeach.droidcafe.databinding.ActivityOrderBinding


class OrderActivity : AppCompatActivity() {

    private var mbinding : ActivityOrderBinding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_order)

        mbinding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val message = "Order: " + intent.getStringExtra("EXTRA_MESSAGE")
        binding.orderTextView.setText(message)


    }

    fun displayToast(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            binding.sameday.id -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))

            binding.nextday.id -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))

            binding.pickup.id -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))

            else -> {}
        }
    }



    override fun onDestroy() {

        mbinding = null
        super.onDestroy()
    }


}