package com.example.mibihi.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    protected fun btnClic(view:View){
        val btnSelected = view as Button
        var cellId=0
        when(btnSelected.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }
       // Toast.makeText(this,"ID is:"+cellId,Toast.LENGTH_SHORT).show()
        playGame(cellId,btnSelected)
    }
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var activeplayer =1
    fun playGame(cellIid:Int,btnselected:Button){
        if(activeplayer==1){
            btnselected.text ="X"
            btnselected.setBackgroundColor(Color.GREEN)
            player1.add(cellIid)
            activeplayer=2
            autoPlay()

        }else{
            btnselected.text ="O"
            btnselected.setBackgroundColor(Color.BLUE)
            player2.add(cellIid)
            activeplayer=1

        }
        println("btnselected=======  "+ cellIid)
        btnselected.isEnabled=false
        checkWinner()

    }
    fun checkWinner(){
        var winner =-1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){winner=1}
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){winner=2}
        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){winner=1}
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){winner=2}
        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){winner=1}
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){winner=2}
        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){winner=1}
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){winner=2}
        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){winner=1}
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){winner=2}
        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){winner=1}
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){winner=2}
        if(winner != -1){
            if(winner==1){
                Toast.makeText(this,"Player1 is the winner",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Player2 is the winner",Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun autoPlay(){
        var emptyCells = ArrayList<Int>()
        for( cellId in  1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId)))
                emptyCells.add(cellId)
        }
        val r = Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellId = emptyCells[randIndex]
        var buSelect:Button?
        when(cellId){
            1->buSelect=btn1
            2->buSelect=btn2
            3->buSelect=btn3
            4->buSelect=btn4
            5->buSelect=btn5
            6->buSelect=btn6
            7->buSelect=btn7
            8->buSelect=btn8
            9->buSelect=btn9
            else->{buSelect=btn1}
        }
        playGame(cellId,buSelect)
    }
}
