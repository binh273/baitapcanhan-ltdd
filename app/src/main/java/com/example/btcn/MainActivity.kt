package com.example.btcn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        khong.setOnClickListener { input("0",false) }
        mot.setOnClickListener { input("1",false) }
        hai.setOnClickListener { input("2",false) }
        ba.setOnClickListener { input("3",false) }
        bon.setOnClickListener { input("4",false) }
        nam.setOnClickListener { input("5",false) }
        sau.setOnClickListener { input("6",false) }
        bay.setOnClickListener { input("7",false) }
        tam.setOnClickListener { input("8",false) }
        chin.setOnClickListener { input("9",false) }

        cong.setOnClickListener { input("+",true) }
        tru.setOnClickListener { input("-",true) }
        nhan.setOnClickListener { input("*",true) }
        chia.setOnClickListener { input("/",true) }
        ce.setOnClickListener {
            tvip.text = ""
            tvkq.text = ""
        }
        bang.setOnClickListener{
            try{
                val tvip1 = ExpressionBuilder(tvip.text.toString()).build()
                val tvkq1 = tvip1.evaluate()
                val longtvkq1 = tvkq1.toLong()
                if(tvkq1 == longtvkq1.toDouble())
                {
                    tvkq.text = tvkq1.toString()
                }else
                {
                    tvkq.text = tvkq1.toString()
                }
            }catch (e:Exception)
            {}
        }

    }
    fun input(string:String ,canClear :Boolean)
    {
        if(tvkq.text.isNotEmpty())
        {
            tvip.text = ""
        }
        if(canClear)
        {
            tvkq.text=""
            tvip.append(string)
        }else{
            tvip.append(tvkq.text)
            tvip.append(string)
            tvkq.text=""
        }
    }
}