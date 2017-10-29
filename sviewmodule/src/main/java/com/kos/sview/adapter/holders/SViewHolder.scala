package com.kos.sview.adapter.holders

import android.support.v7.widget.RecyclerView
import android.view.View

/**
  * Created by Kos on 01.04.2017.
  */
class SViewHolder(topView:View)  extends RecyclerView.ViewHolder(topView) {
	def find[T <: View](viewId:Int) = itemView.findViewById[T](viewId)
}
