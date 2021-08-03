package com.ntabenkin.binn.user


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ntabenkin.binn.user.MaterialPaletteAdapter
import com.ntabenkin.binn.User
import com.ntabenkin.binn.UserFragmentsListener
import com.ntabenkin.binn.R
import com.ntabenkin.binn.databinding.FragmentUserBinding
import java.util.*

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private val Users: MutableList<User> = ArrayList()
    private lateinit var listener: UserFragmentsListener

    // We decide which is going to be our Layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    // UI is ready to be used
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)

        // We initialize User array
        initUsers()

        // We instantiate the recyclerView
        val recyclerView = binding.recyclerView

        // We add the item divider decoration between each item
        recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )

        // val adapter = MaterialPaletteAdapter(this)

        val adapter = MaterialPaletteAdapter {
            listener.navigateToUserDetails(it)

        }

        // We set a MaterialPaletteAdapter to the recyclerView, sending as parameters the Users and Activity
        recyclerView.adapter = adapter
        adapter.addItems(Users)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as UserFragmentsListener
    }

    private fun initUsers() {
        Users.add(
            User(
                "UserBin #1331",
                resources.getString(R.string.md_red_500),
                resources.getColor(R.color.md_red_500)
            )
        )
        Users.add(
            User(
                getString(R.string.red),
                resources.getString(R.string.md_red_500),
                resources.getColor(R.color.md_red_500)
            )
        )
        Users.add(
            User(
                getString(R.string.pink),
                resources.getString(R.string.md_pink_500),
                resources.getColor(R.color.md_pink_500)
            )
        )
        Users.add(
            User(
                getString(R.string.purple),
                resources.getString(R.string.md_purple_500),
                resources.getColor(R.color.md_purple_500)
            )
        )
        Users.add(
            User(
                getString(R.string.deeppurple),
                resources.getString(R.string.md_deep_purple_500),
                resources.getColor(R.color.md_deep_purple_500)
            )
        )
        Users.add(
            User(
                getString(R.string.indigo),
                resources.getString(R.string.md_indigo_500),
                resources.getColor(R.color.md_indigo_500)
            )
        )
        Users.add(
            User(
                getString(R.string.blue),
                resources.getString(R.string.md_blue_500),
                resources.getColor(R.color.md_blue_500)
            )
        )
        Users.add(
            User(
                getString(R.string.lightblue),
                resources.getString(R.string.md_light_blue_500),
                resources.getColor(R.color.md_light_blue_500)
            )
        )
        Users.add(
            User(
                getString(R.string.cyan),
                resources.getString(R.string.md_cyan_500),
                resources.getColor(R.color.md_cyan_500)
            )
        )
        Users.add(
            User(
                getString(R.string.teal),
                resources.getString(R.string.md_teal_500),
                resources.getColor(R.color.md_teal_500)
            )
        )
        Users.add(
            User(
                getString(R.string.green),
                resources.getString(R.string.md_green_500),
                resources.getColor(R.color.md_green_500)
            )
        )
        Users.add(
            User(
                getString(R.string.lightgreen),
                resources.getString(R.string.md_light_green_500),
                resources.getColor(R.color.md_light_green_500)
            )
        )
        Users.add(
            User(
                getString(R.string.lime),
                resources.getString(R.string.md_lime_500),
                resources.getColor(R.color.md_lime_500)
            )
        )
        Users.add(
            User(
                getString(R.string.yellow),
                resources.getString(R.string.md_yellow_500),
                resources.getColor(R.color.md_yellow_500)
            )
        )
        Users.add(
            User(
                getString(R.string.amber),
                resources.getString(R.string.md_amber_500),
                resources.getColor(R.color.md_amber_500)
            )
        )
        Users.add(
            User(
                getString(R.string.orange),
                resources.getString(R.string.md_orange_500),
                resources.getColor(R.color.md_orange_500)
            )
        )
        Users.add(
            User(
                getString(R.string.deeporange),
                resources.getString(R.string.md_deep_orange_500),
                resources.getColor(R.color.md_deep_orange_500)
            )
        )
        Users.add(
            User(
                getString(R.string.brown),
                resources.getString(R.string.md_brown_500),
                resources.getColor(R.color.md_brown_500)
            )
        )
        Users.add(
            User(
                getString(R.string.grey),
                resources.getString(R.string.md_grey_500),
                resources.getColor(R.color.md_grey_500)
            )
        )
        Users.add(
            User(
                getString(R.string.bluegrey),
                resources.getString(R.string.md_blue_grey_500),
                resources.getColor(R.color.md_blue_grey_500)
            )
        )
    }
}
