package com.ntabenkin.binn


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntabenkin.binn.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.extras?.getParcelable("user") as User?
        if(user == null){
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent = Intent(this,ListActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}