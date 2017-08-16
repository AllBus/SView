package com.kos.sview.adapter.holders

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.OnClickListener

/**
  * Created by Kos on 06.07.2016.
  */
class SimpleHolder[DT](topView:View,itemClick:OnClickListener) extends RecyclerView.ViewHolder(topView){

	@inline def find[T](@IdRes id: Int) = itemView.findViewById(id).asInstanceOf[T]

//	val image=find[ImageView](R.id.image)
//	val numberLabel=find[TextView](R.id.numberLabel)
//	val info=find[TextView](R.id.info)
//	val timeLabel=find[TextView](R.id.timeLabel)
//	val distanceLabel=find[TextView](R.id.distanceLabel)

	itemView.setOnClickListener(itemClick)

	def bind(position:Int,element:DT){
		itemView.setTag(element)
//		if (image!=null)
//			US.image(image,element.getImage)
//
//		//US.text(name,element.getName)
//		US.text(info,element.getInfo)
	}

}

