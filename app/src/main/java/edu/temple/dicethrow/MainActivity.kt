package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    val dieViewModel: DieViewModel by lazy {
        ViewModelProvider(this).get(DieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this is used to set the edge to edge
        supportFragmentManager.beginTransaction()
            //this is used to add the fragment to the container
            .add(R.id.fragmentContainerView, DieFragment.newInstance(6))
            //this is used to commit the transaction
            .commit()



        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            //3.20.25 in class activity implementation

            dieViewModel.rollDie()



            //use supportFragmentManager to get the fragment and call the throwDie function when the button is clicked
            //the id of the container is used to get the fragment

            //this is one way to do it
//            supportFragmentManager
                //let is used to return the fragment, it is a lambda function that returns the fragment
//                .findFragmentById(R.id.fragmentContainerView).let {
//                (it as DieFragment).throwDie()
//            }


            //this is the other way to do it
//                (supportFragmentManager
//                    //as is used to cast the fragment to the DieFragment
//                    //the difference between let and as is that let returns the fragment and as casts the fragment to the DieFragment
//                .findFragmentById(R.id.fragmentContainerView) as DieFragment).throwDie()

        }
    }
}