package com.fghilmany.dietmealapp.ui.home.profile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fghilmany.dietmealapp.R
import com.fghilmany.dietmealapp.databinding.ItemProfileBinding
import java.util.*
import kotlin.collections.ArrayList

class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.ViewHolder>(), Filterable {

    private val listImmutableProfile = ArrayList<Profile>()
    private var listProfile = ArrayList<Profile>()

    init {
        listImmutableProfile.addAll(listProfile())
        listProfile = listImmutableProfile
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = listProfile[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int = listProfile.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemProfileBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(result: Profile) {
            with(binding){
                result.apply {
                    tvName.text = name
                    tvWeight.text = "$weight KG"
                    tvHeight.text = "$height CM"

                    if (gender == "male")
                        ivGender.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.male_gender))
                    else
                        ivGender.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.female_gender))
                }
            }
        }

    }

    override fun getFilter(): Filter =
        object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                listProfile = if (charSearch.isEmpty()){
                    listImmutableProfile
                } else {
                    val result = ArrayList<Profile>()
                    for (i in listImmutableProfile){
                        if (i.name.lowercase(Locale.ROOT).contains(
                                charSearch.lowercase(
                                    Locale.ROOT
                                )
                            )
                        ){
                            result.add(i)
                        }
                    }
                    result
                }
                val filterResult = FilterResults()
                filterResult.values = listProfile
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, result: FilterResults?) {
                @Suppress("UNCHECKED_CAST")
                listProfile = result?.values as ArrayList<Profile>
                notifyDataSetChanged()
            }
        }
}