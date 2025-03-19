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
    val DIEVALUE = "dievalue"

    lateinit var dieTextView: TextView
//sides of the die
    private var dieSides: Int = 6
    private var currentdieValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getInt(DIESIDE)?.let {
                dieSides = it
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
//        throwDie()
        //listens for a click and calls the throwDie function
        //this shouldnt be here because we want the button to be the one changing the textview
//        view.setOnClickListener{
//            throwDie()
//        }

    currentdieValue = savedInstanceState?.getInt(DIEVALUE) ?:( Random.nextInt(dieSides)+1)
    dieTextView.text = currentdieValue.toString()



    }

    fun throwDie() {
//        //random number is generated and placed in the textview
//        dieTextView.text = (Random.nextInt(dieSides)+1).toString()
        currentdieValue = Random.nextInt(dieSides)+1
        dieTextView.text = currentdieValue.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DIEVALUE, currentdieValue)

    }
    companion object{

    fun newInstance(sides: Int) = DieFragment().apply {
        arguments = Bundle().apply {
            putInt(DIESIDE, sides)
        }
    }
    }
}