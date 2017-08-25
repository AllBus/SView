# SView - Scala Android View

Library for easy UI manipulation


## Main clases

SActivity - trait сontaining method for find and change status View

SFragemnt - trait as SActivity but for Fragment

BusActivity - Activity with bus interface

BusProvider - Object with methods for bus

## Run method on UI thread
```Scala
	BusProvider.onUI{
		//your actions
	}
```

## Post message to Activity
```Scala
	case class ResultCalculate(message:String, state:Int) extends IBusSender{
		override def flags(): Int = Bus.FLAG_ALL
	}

	BusProvider.post(ResultCalculate("message",1))
```
## Handle message in Activity

```Scala
	class MainActivity extends BusActivity{
	
		override def busUpdate(updater: IBusSender): Unit = updater match {
    		case ResultCalculate(msg,state) ⇒ //Your actions
    		case _ ⇒ super.busUpdate(updater)
    	}
	}
```

