package com.adonizio.honorsmobileapps.courtcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var aTotal =0
    var bTotal = 0
    lateinit var teamAScore: TextView
    lateinit var teamBScore: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        teamAScore = findViewById(R.id.scoreA)
        teamBScore = findViewById(R.id.ScoreB)
        val A3: Button = findViewById(R.id.A3)
        val A2: Button = findViewById(R.id.A2)
        val AFT: Button = findViewById(R.id.AFT)
        val B3: Button = findViewById(R.id.B3)
        val B2: Button = findViewById(R.id.B2)
        val BFT: Button = findViewById(R.id.BFT)
        val reset: Button = findViewById(R.id.reset)
        val buttongroup: List<View> = listOf(A3, A2, AFT, B3, B2, BFT)
        reset.setOnClickListener{view->
            aTotal = 0
            bTotal = 0
            teamAScore.text = aTotal.toString()
            teamBScore.text = bTotal.toString()
        }
        val mainListener: View.OnClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.A3 -> addforTeamA(3)
                R.id.A2 -> addforTeamA(2)
                R.id.AFT -> addforTeamA(1)
                R.id.B3 -> addforTeamB(3)
                R.id.B2 -> addforTeamB(2)
                R.id.BFT -> addforTeamB(1)
            }
            teamAScore.text = aTotal.toString()
            teamBScore.text = bTotal.toString()
        }
        for (button in buttongroup)
            button.setOnClickListener(mainListener)
    }


    fun addforTeamA(num:Int){
        aTotal+=num
        if(num==3){
            Snackbar.make(findViewById(R.id.myCoordinatorLayout),"Yay Team A",Snackbar.LENGTH_SHORT).show()
        }
    }
    fun addforTeamB(num:Int){
        bTotal+=num
        if(num==3){
            Snackbar.make(findViewById(R.id.myCoordinatorLayout),"Yay Team B",Snackbar.LENGTH_SHORT).show()
        }
    }
}