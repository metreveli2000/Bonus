package com.example.bonus

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.bonus.fragments.Fragment22
import com.example.bonus.fragments.PageFragment11
//import kotlinx.android.synthetic.main.fill_your_profile.*
//import kotlinx.android.synthetic.main.profile.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView3: TextView
    private lateinit var name_input: EditText
    private var pager: ViewPager? = null
    private var pagerAdapter: PagerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name_input = findViewById(R.id.name_input)
        button = findViewById(R.id.button)
        textView3 = findViewById(R.id.textView3)


        loadData()
        button.setOnClickListener {
            saveData()
        }

        val list: MutableList<Fragment> =
            ArrayList()
        list.add(PageFragment11())
        list.add(Fragment22())
        pager = findViewById(R.id.pager)
        pagerAdapter = SlidePagerAdapter(supportFragmentManager, list)
        pager!!.adapter = pagerAdapter


    }

    private fun saveData() {

        val insertedText = name_input.text.toString()
        textView3.text = insertedText

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedText)
        }.apply()

        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT ).show()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)


        textView3.text = savedString


    }




}