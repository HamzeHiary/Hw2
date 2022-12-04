package com.example.a2kotln

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.navigation.NavigationBarView
import android.view.Menu
import android.view.MenuItem
import android.view.MenuInflater as MenuInflater1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag: String = "Europe"
        val spinnerVal: Spinner = findViewById(R.id.spin)
        var options = arrayOf("Europe", "Latinos")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)


        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == 0) {
                    val fragEurope = EuropeFragment()
                    fragEurope.show(supportFragmentManager, "Europe")
                } else if (p2 == 1) {
                    val fragLatinos = LatinosFragment()
                    fragLatinos.show(supportFragmentManager, "Latinos")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.my_first_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.item1 -> Toast.makeText(this, "Europe selected", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Latinos selected", Toast.LENGTH_SHORT).show()
        }
        return true
    }
    fun receiveFeedback(feedback: String) {
        val resultTV: TextView = findViewById(R.id.textResult)

        resultTV.text = feedback;
    }

}