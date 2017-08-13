package com.kos.sview

import android.support.v7.widget.RecyclerView
import android.view.View

/**
  * Created by Kos on 01.04.2017.
  */
class SViewHolder(topView:View)  extends RecyclerView.ViewHolder(topView) {
	def find[T](viewId:Int) = itemView.findViewById(viewId).asInstanceOf[T]
}
