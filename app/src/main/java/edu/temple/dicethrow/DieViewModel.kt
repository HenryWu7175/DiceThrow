package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel()  {
    //unique live data object that holds the value of the die
//    var currentDieValue: MutableLiveData<Int> = MutableLiveData()

    private var dieSides: Int = 6

    //lazy initialization of the live data object
    // a lazy initialization is a way to initialize a variable when it is first used
    private val currentDieValue : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getCurrentDieValue() : LiveData<Int> {
        return currentDieValue
    }

    fun setDieValue(roll: Int) {
        currentDieValue.value = roll
    }
    fun rollDie() {
        setDieValue(Random.nextInt(dieSides)+1)
    }


}