package com.ntabenkin.binn


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ntabenkin.binn.databinding.ActivityListBinding
import com.ntabenkin.binn.user.UserFragment
import com.ntabenkin.binn.userdetails.UserDetailsFragment



interface UserFragmentsListener {
    fun navigateToUserDetails(user: User)
    fun navigateBack()
}

class MainActivity : AppCompatActivity(), UserFragmentsListener {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateToFragment(UserFragment())


        val user = intent.extras?.getParcelable("user") as User?
        if(user == null){
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            navigateToFragment(UserFragment())

        }

    }

    private fun navigateToFragment(fragment: Fragment, replace: Boolean = true) {
        if (replace) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, fragment)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(binding.container.id, fragment)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun navigateToUserDetails(user: User) {
        navigateToFragment(UserDetailsFragment.newInstance(user,true,"Something",0), false)

    }

    override fun navigateBack() {
        supportFragmentManager.popBackStack()
    }

}