package com.kos.sview.adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
  * Created by Kos on 01.04.2017.
  */
class SViewHolder(topView:View)  extends RecyclerView.ViewHolder(topView) {
	def find[T <: View](viewId:Int) = itemView.findViewById[T](viewId)
}
