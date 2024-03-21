package com.example.basicstatecodelab

import androidx.compose.runtime.Immutable

data class Person(val name:String, val addressCollection:AddressCollection)
@Immutable
data class AddressCollection(val addresses:MutableList<String>)