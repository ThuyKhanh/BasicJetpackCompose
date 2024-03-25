/**
 * @file MainViewModel.kt
 * @author Ha Van Thuy/과장/메가존_MZ HMI
 *
 * © 2024 Hyundai Motor Company. All Rights Reserved.
 *
 * This software is copyright protected and proprietary to Hyundai Motor Company.
 * Do not copy without prior permission. Any copy of this software or of any
 * derivative work must include the above copyright notice, this paragraph and
 * the one after it.
 *
 * This software is made available on an “AS IS” condition, and Hyundai Motor Company
 * disclaims all warranties of any kind, whether express or implied, statutory or
 * otherwise, including without limitation any warranties of merchantability or
 * fitness for a particular purpose, absence of errors, accuracy, completeness of
 * results or the validity, scope, or non-infringement of any intellectual property.
 */
package com.example.basicstatecodelab

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    fun removeFistItem() {
        _resident.removeAt(0)
    }

    fun addToLast() {
        _resident.add(
            Person(
                "New person ${System.currentTimeMillis()}",
                addressCollection = AddressCollection(MutableList(4) { "New address $it" }),
                properties = Properties(house = List(2) { House(60.0f, 2, 2) },
                    car = List(1) { Car(branch = "Hyundai", seat = 4) })
            )
        )
    }

    private var _resident = mutableStateListOf<Person>()
    val resident: List<Person>
        get() = _resident

    init {
        _resident = List(50) { index ->
            Person(
                "Thuy $index",
                AddressCollection(addresses = MutableList(5) { "Address $it" }),
                properties = Properties(house = List(2) { House(60.0f, 2, 2) },
                    car = List(1) { Car(branch = "Hyundai", seat = 4) }
                ))
        }.toMutableStateList()
    }
}