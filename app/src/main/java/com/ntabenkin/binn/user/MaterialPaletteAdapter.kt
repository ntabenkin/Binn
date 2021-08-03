package com.ntabenkin.binn.user

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ntabenkin.binn.User
import com.ntabenkin.binn.R
import com.ntabenkin.binn.user.MaterialPaletteAdapter.PaletteViewHolder
import kotlinx.android.synthetic.main.item.view.*

/**
 * Created by Andres Oller.
 */
// En este constructor recibimos la lista de colores y ademas quien sera el listener del onClick
// On this constructor we receive the list of colors and who is going to be listening clicks
class MaterialPaletteAdapter(
    private val listener: (User) -> Unit
) : RecyclerView.Adapter<PaletteViewHolder?>() {

    private val userList: ArrayList<User> = arrayListOf()

    // Aqui decidimos cual sera el layout de los items "R.layout.item"
    // Here we decide which is the item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaletteViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PaletteViewHolder(row)
    }

    // Cada vez que se asocia una vista a la recycler se ejecuta este metodo, por lo tanto debemos actualizar la informacion del item
    // Everytime a view is attached to the reyclerview, this method is executed so we must update item info
    override fun onBindViewHolder(holder: PaletteViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun addItems(userList: List<User>) {
        this.userList.addAll(userList)
        notifyDataSetChanged()
    }

    fun deleteItem(userName: String) {
        this.userList.removeIf { it.name == userName }
        notifyDataSetChanged()
    }

    // This is the equivalent to the item.xml but using Kotlin code
    inner class PaletteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.titleTextView.text = user.name
            itemView.subtitleTextView.text = user.hex
            val gradientDrawable = itemView.circleView.background as GradientDrawable
            gradientDrawable.setColor(user.value)

            /**
             *
             *   Este OnClick es el que se ejecuta cuando hacemos click en un item de la lista y es el encargado de avisarle
             *   al listener (la Activity en este caso) que hubo un click en el adapter.
             *
             *   setOnClickListener is executed when we tap an item in the list (recyclerview) and is the one in charge
             *   of telling the listener (In our example the Activity) that there was a click happened on the adapter
             *
             **/
            itemView.setOnClickListener {
                listener(user)
            }
        }
    }
}
