# SView - Scala Android View
Library for easy UI manipulation

## Main clases
SActivity - trait сontaining method for find and change status View
SFragemnt - trait as SActivity but for Fragment
BusActivity - Activity with bus interface
BusProvider - Object with methods for bus

## Run method on UI thread
```
BusProvider.onUI{
//your actions
}
```
