package com.example.basicstatecodelab

import androidx.compose.runtime.Immutable

data class Person(val name:String, val addressCollection:AddressCollection, val properties: Properties)
@Immutable
data class AddressCollection(val addresses:MutableList<String>)

data class Properties(val house:List<House>, val car: List<Car>)
data class House(val size:Float, val sleepCount:Int, val restroomCount:Int)
data class Car(val branch:String, val seat:Int)