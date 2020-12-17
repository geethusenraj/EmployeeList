package com.geethu.employeesearch.ui.adapters

import com.geethu.employeesearch.model.User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geethu.employeesearch.R
import kotlinx.android.synthetic.main.item_layout.view.*

class EmployeeListAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<EmployeeListAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.apply {

            }
            itemView.apply {
                tvUserName.text = user.name
                tvUserEmail.text = user.email
                Glide.with(ivAvatar.context)
                    .load(user.profile_image)
                    .into(ivAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}