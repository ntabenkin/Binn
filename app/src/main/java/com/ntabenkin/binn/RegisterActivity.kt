package com.ntabenkin.binn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.ntabenkin.binn.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Access Items
        val states = resources.getStringArray(R.array.location_supported)

        //access spinner
        val spinner = findViewById<Spinner>(R.id.location)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,states)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@RegisterActivity,
                        getString(R.string.selected_item) + " " +
                                "" + states[position], Toast.LENGTH_SHORT
                    ).show()
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }

            }
            binding.register.setOnClickListener {
                val user = User(
                  binding.toString(),
                    binding.toString(),
                   33
                )
                val intent = Intent(this, MainActivity::class.java)

                intent.putExtra("user", user)
                startActivity(intent)
                finish()

            }
        }


    }
}
