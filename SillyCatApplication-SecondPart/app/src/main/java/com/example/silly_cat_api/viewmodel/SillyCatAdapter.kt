package com.example.silly_cat_api.viewmodel

import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.silly_cat_api.R
import com.example.silly_cat_api.model.SillyCatResponseItem
import kotlinx.android.synthetic.main.activity_single_cat_layout.view.*
import kotlinx.android.synthetic.main.single_cat_item.view.*


class SillyCatAdapter(val catList: List<SillyCatResponseItem> , private val onCatClickListener: OnCatClickListener):RecyclerView.Adapter<SillyCatAdapter.SillyCatViewHolder >(){

    //private var items: List<SillyCatResponseItem> = ArrayList()
    private var items = catList

    class SillyCatViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.iv_cat_image_view

        //Newly added
        val name: TextView? = itemView.tv_name
        val weight: TextView? = itemView.tv_weight
        val temperament: TextView? = itemView.tv_temperament
        val origin: TextView? = itemView.tv_origin
        val description: TextView? = itemView.tv_description
        val life_span: TextView? = itemView.tv_life_span
        val indoor: TextView? = itemView.tv_indoor
        val adaptability: TextView? = itemView.tv_adaptability
        val affection_lvl: TextView? = itemView.tv_affection_lvl
        val child_friendly: TextView? = itemView.tv_child_friendly
        val energy_lvl: TextView? = itemView.tv_energy_lvl
        val grooming: TextView? = itemView.tv_grooming
        val health_issues: TextView? = itemView.tv_health_issues
        val intelligence: TextView? = itemView.tv_intelligence
        val shedding_lvl: TextView? = itemView.tv_shedding_lvl
        val social_needs: TextView? = itemView.tv_social_needs
        val stranger_friendly: TextView? = itemView.tv_stranger_friendly
        val vocal: TextView? = itemView.tv_vocal
        val hairless: TextView? = itemView.tv_hairless
        val rare: TextView? = itemView.tv_rare
        val suppressed_tail: TextView? = itemView.tv_suppressed_tail
        val short_hair: TextView? = itemView.tv_short_legs
        val hypoallergenic: TextView? = itemView.tv_hypoallergenic

        fun bind(catList: SillyCatResponseItem){

            Glide.with(itemView.context)
                .load(catList.url)
                .into(imageView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SillyCatViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_cat_item,
        parent,false)

        return SillyCatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SillyCatViewHolder, position: Int) {
        //holder.imageView.setImageResource(catList[position].url as Int)
        holder.bind(items.get(position))
        //holder.imageView.iv_cat_image_view = item.get(position)
        //holder.bind(items.catList.get(position))

        //Items that need to be trasferred

        holder.imageView.tv_name?.text = items[position].breeds[position].description
        holder.imageView.tv_temperament?.text = items[position].breeds[position].temperament
        holder.imageView.tv_origin?.text = items[position].breeds[position].origin
        holder.imageView.tv_life_span?.text = items[position].breeds[position].life_span
        //To string
        holder.imageView.tv_indoor?.text = items[position].breeds[position].indoor.toString()
        holder.imageView.tv_adaptability?.text = items[position].breeds[position].adaptability.toString()
        holder.imageView.tv_affection_lvl?.text = items[position].breeds[position].affection_level.toString()
        holder.imageView.tv_child_friendly?.text = items[position].breeds[position].child_friendly.toString()
        holder.imageView.tv_energy_lvl?.text = items[position].breeds[position].energy_level.toString()
        holder.imageView.tv_grooming?.text = items[position].breeds[position].grooming.toString()
        holder.imageView.tv_health_issues?.text = items[position].breeds[position].health_issues.toString()
        holder.imageView.tv_intelligence?.text = items[position].breeds[position].intelligence.toString()
        holder.imageView.tv_shedding_lvl?.text = items[position].breeds[position].shedding_level.toString()
        holder.imageView.tv_social_needs?.text = items[position].breeds[position].social_needs.toString()
        holder.imageView.tv_stranger_friendly?.text = items[position].breeds[position].stranger_friendly.toString()
        holder.imageView.tv_vocal?.text = items[position].breeds[position].vocalisation.toString()
        holder.imageView.tv_hairless?.text = items[position].breeds[position].hairless.toString()
        holder.imageView.tv_rare?.text = items[position].breeds[position].rare.toString()
        holder.imageView.tv_suppressed_tail?.text = items[position].breeds[position].suppressed_tail.toString()
        holder.imageView.tv_short_legs?.text = items[position].breeds[position].short_legs.toString()
        holder.imageView.tv_hypoallergenic?.text = items[position].breeds[position].hypoallergenic.toString()


        //Create onClick functionality for image view
        holder.imageView.setOnClickListener {
            onCatClickListener.onCatItemClicked(position)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

/*
    fun onImageItemClicked(position: Int){
        Log.d("Position", "Position = ${position}")
    }
*/

}