package com.ntabenkin.binn.userdetails

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ntabenkin.binn.User
import com.ntabenkin.binn.UserFragmentsListener
import com.ntabenkin.binn.R
import com.ntabenkin.binn.databinding.ActivityUserFragmentBinding
import com.ntabenkin.binn.databinding.FragmentUserDetailsBinding
import kotlinx.android.synthetic.main.fragment_user_details.*
import kotlinx.android.synthetic.main.item.view.*

private const val ARG_COLOR = "color"
private const val ARG_String = "string"
private const val ARG_BOOLEAN = "boolean"
private const val ARG_INT = "int"

class UserDetailsFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailsBinding
    private var color: User? = null
    private lateinit var listener: UserFragmentsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getParcelable(ARG_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            listener.navigateBack()
        }


        val gradientDrawable = binding.circleView.background as GradientDrawable
        color?.let { gradientDrawable.setColor(it.value) }

        binding.circleView.setOnClickListener{
            binding.img.setVisibility(View.INVISIBLE)
            Toast.makeText(requireContext(), "You Clicked Button", Toast.LENGTH_SHORT).show()


            ObjectAnimator.ofFloat(view, "translationX", 140f).apply {
                duration = 2000
                start()
            }
        }

        binding.textView.text = color?.name.toString()
        Toast.makeText(requireContext(), color?.name, Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as UserFragmentsListener
    }


    companion object {
        @JvmStatic
        fun newInstance(color: User, boolean: Boolean, string: String, int: Int) =
            UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_COLOR, color)
                    putBoolean(ARG_BOOLEAN, boolean)
                    putString(ARG_String, string)
                    putInt(ARG_INT, int)

                }
            }
    }
}
