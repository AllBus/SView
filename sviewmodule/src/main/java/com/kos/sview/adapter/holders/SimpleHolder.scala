package com.kos.sview.adapter.holders


import android.view.View
import android.view.View.OnClickListener
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
  * Created by Kos on 06.07.2016.
  */
class SimpleHolder[DT](topView:View,itemClick:OnClickListener) extends RecyclerView.ViewHolder(topView){

	@inline def find[T <: View](@IdRes id: Int) = itemView.findViewById[T](id)

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

