package com.example.sb_bssd5250_hw12

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import android.graphics.drawable.GradientDrawable
import android.os.Build







class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val constraintLayout = ConstraintLayout(this)
        constraintLayout.setBackgroundColor(0xFF00FF00.toInt())
        constraintLayout.id = View.generateViewId()

        val textView = TextView(this)
        textView.text = "Select a Color" // set the text vewi text
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.id = View.generateViewId()
        constraintLayout.addView(textView) // add the text view to the layout
        setContentView(constraintLayout) //add the layout to the activity

        val blueButton = Button(this)
        blueButton.id = View.generateViewId()
        blueButton.text = "Blue"
        blueButton.setBackgroundColor(Color.BLUE)
        blueButton.setOnClickListener(View.OnClickListener {
            /* Log.d("MainActivity", "button clicked") */
            constraintLayout.setBackgroundColor(Color.BLUE)
        })
        constraintLayout.addView(blueButton)

        val redButton = Button(this)
        redButton.id = View.generateViewId()
        redButton.text = "Red"
        redButton.setBackgroundColor(Color.RED)
        redButton.setOnClickListener(View.OnClickListener {
            /* Log.d("MainActivity", "button clicked") */
            constraintLayout.setBackgroundColor(Color.RED)
        })
        constraintLayout.addView(redButton)

        val greenButton = Button(this)
        greenButton.id = View.generateViewId()
        greenButton.text = "Green"
        greenButton.setBackgroundColor(Color.GREEN)
        greenButton.setOnClickListener(View.OnClickListener {
            /* Log.d("MainActivity", "button clicked") */
            constraintLayout.setBackgroundColor(Color.GREEN)
        })
        constraintLayout.addView(greenButton)

        //important to constrain everything after the hierarchy has been created.
        val constraintSet = ConstraintSet() //Apply mu:n.419 constraints at once with a set
        val pid = ConstraintSet.PARENT_ID //the parent id. This will save typing below
        constraintSet.constrainHeight(textView.id, ConstraintSet.WRAP_CONTENT) //wrap only the text
        constraintSet.constrainWidth(textView.id, ConstraintSet.WRAP_CONTENT) //wrap only the text
        constraintSet.constrainHeight(blueButton.id, ConstraintSet.WRAP_CONTENT) //wrap only the text
        constraintSet.constrainWidth(blueButton.id, ConstraintSet.WRAP_CONTENT) //wrap only the text
        constraintSet.constrainHeight(redButton.id, ConstraintSet.WRAP_CONTENT) //wrap
        constraintSet.constrainWidth(redButton.id, ConstraintSet.WRAP_CONTENT) //wrap
        constraintSet.constrainHeight(greenButton.id, ConstraintSet.WRAP_CONTENT) //wrap
        constraintSet.constrainWidth(greenButton.id, ConstraintSet.WRAP_CONTENT) //wrap
        //Match bottom, top, left, and right. equal tension between all places textV in center
        constraintSet.connect(textView.id, ConstraintSet.BOTTOM,
            pid, ConstraintSet.BOTTOM)
        constraintSet.connect(textView.id, ConstraintSet.TOP,
            pid, ConstraintSet. TOP)
        constraintSet.connect(textView.id, ConstraintSet.LEFT,
            pid, ConstraintSet.LEFT)
        constraintSet.connect(textView.id, ConstraintSet.RIGHT,
            pid, ConstraintSet.RIGHT)

        constraintSet.connect(blueButton.id, ConstraintSet.LEFT,
            pid, ConstraintSet.LEFT)
        constraintSet.connect(blueButton.id, ConstraintSet.RIGHT,
            pid, ConstraintSet.RIGHT)
        constraintSet.connect(blueButton.id, ConstraintSet.TOP, textView.id, ConstraintSet.BOTTOM)

        constraintSet.connect(redButton.id, ConstraintSet.LEFT,
            pid, ConstraintSet.LEFT)
        constraintSet.connect(redButton.id, ConstraintSet.RIGHT,
            pid, ConstraintSet.RIGHT)
        constraintSet.connect(redButton.id, ConstraintSet.TOP, blueButton.id, ConstraintSet.BOTTOM)

        constraintSet.connect(greenButton.id, ConstraintSet.LEFT,
            pid, ConstraintSet.LEFT)
        constraintSet.connect(greenButton.id, ConstraintSet.RIGHT,
            pid, ConstraintSet.RIGHT)
        constraintSet.connect(greenButton.id, ConstraintSet.TOP, redButton.id, ConstraintSet.BOTTOM)

        constraintSet.applyTo(constraintLayout) //apply this to the layout container



    }
}