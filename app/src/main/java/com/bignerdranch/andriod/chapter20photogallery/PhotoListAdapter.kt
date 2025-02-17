package com.bignerdranch.andriod.chapter20photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bignerdranch.andriod.chapter20photogallery.api.GalleryItem
import com.bignerdranch.andriod.chapter20photogallery.databinding.ListItemGalleryBinding


class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
):RecyclerView.ViewHolder(binding.root){
    fun bind(galleryItem: GalleryItem){
        binding.itemImageView.load(galleryItem.url)
    }
}



class PhotoListAdapter(
    private val galleryItem: List<GalleryItem>
    ):RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItem[position]
        holder.bind(item)
    }

    override fun getItemCount() = galleryItem.size

    }
