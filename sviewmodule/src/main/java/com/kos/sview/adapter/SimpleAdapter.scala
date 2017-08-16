package com.kos.sview.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View.OnClickListener
import android.view.{LayoutInflater, View, ViewGroup}
import com.kos.sview.adapter.holders.SimpleHolder

import scala.reflect.ClassTag

/**
  * Created by Kos on 06.07.2016.
  */
class SimpleAdapter[DT: ClassTag, T<: SimpleHolder[DT]](
														  context:Context,
														  @LayoutRes layoutRes:Int,
														  constructor: (View,OnClickListener) ⇒ T,
														  clickItem: DT ⇒ Unit,
														  onUpdateItems: Array[DT] ⇒ Unit
										 ) extends RecyclerView.Adapter[T]{



	val click=new OnClickListener {
		override def onClick(v: View): Unit = {
			v.getTag match {
				case x:DT ⇒
					clickItem(x)
				case _ ⇒
			}
		}
	}

	val infalter=LayoutInflater.from(context)
	private[this] var list:Array[DT]=Array.empty[DT]

	def getList = list

	override def getItemCount: Int = {
		list.length
	}

	def getItem(position: Int):DT = {
		list(position)
	}

	override def onBindViewHolder(holder: T, position: Int): Unit = {
		holder.bind(position,getItem(position))
	}

	override def onCreateViewHolder(parent: ViewGroup, viewType: Int): T = {
		constructor(infalter.inflate(layoutRes,parent,false),click)
	}

	def changeList(model: Array[DT]) = {
		if (model ne list){
			list=model
			onUpdateItems(list)
			notifyDataSetChanged()
		}
	}

	def updateItems(id: Seq[Int]): Unit = {
		id.foreach{x ⇒
			val y=list.indexOf(x)
			if (y>=0)
				notifyItemChanged(y)
		}
	}

	def updateVisibleItems(list:RecyclerView) = {
		if (list!=null)
		{


			try {
				var wantedChild: Int = 0
				while (wantedChild < list.getChildCount) {
					val wantedView: RecyclerView.ViewHolder = list.getChildViewHolder(list.getChildAt(wantedChild))

					if (wantedView != null) {
						val pos = wantedView.getLayoutPosition
						updateChild(wantedView, getItem(pos), pos)
					}
					wantedChild += 1
				}
			}catch {
				case _ :Throwable =>

			}


		}

	}

	def updateChild(wantedView: RecyclerView.ViewHolder,element:DT,position:Int) {
		wantedView match{
			case holder : SimpleHolder[DT] ⇒ holder.bind(position,element)
			case _ ⇒
		}
	}
}
