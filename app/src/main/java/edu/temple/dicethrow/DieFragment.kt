package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView
//sides of the die
    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            //code begins here
            //textview is assigned to a variable
            dieTextView = findViewById(R.id.dieTextView)

        }
    }

//do we even need this?
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //button is assigned to a variable
        throwDie()
        //listens for a click and calls the throwDie function
        //this shouldnt be here because we want the button to be the one changing the textview
//        view.setOnClickListener{
//            throwDie()
//        }
    }

    fun throwDie() {
        //random number is generated and placed in the textview
        dieTextView.text = (Random.nextInt(dieSides)+1).toString()
    }

//    //companion object is used to create a static object
//    companion object {
//        //this is used to create a new instance of the fragment
//        fun newInstance(sides: Int) = DieFragment().apply {
//            //arguments is used to pass data to the fragment
//            arguments = Bundle().apply {
//                //putInt is used to put the data into the bundle
//                putInt(DIESIDE, sides)
//            }
//        }
//    }
}