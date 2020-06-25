package austinwhite.tech.restaurantpicker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import android.util.Log
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input: EditText = findViewById(R.id.userInput)
        val add: Button = findViewById(R.id.add)
        val clear: Button = findViewById(R.id.clear)
        val choose: Button = findViewById(R.id.choose)
        val choice1: TextView = findViewById(R.id.choices)
        val result: TextView = findViewById(R.id.result)

        val choicesArr = ArrayList<String>(5)

        add.setOnClickListener {
            choicesArr.add(input.text.toString())
            choice1.text = choicesArr.toString().replace("[", "").replace("]", "")
            input.setText("")
            //Log.i("Debug Check", choicesArr.toString()) //for debug purposes
        }

        clear.setOnClickListener {
            choicesArr.clear()
            choice1.text = ""
            result.text = getString(R.string.result)
            //Log.i("Debug Check", choicesArr.toString()) //for debug purposes
        }

        choose.setOnClickListener {
            if (choicesArr.isEmpty()) {
                result.text = getString(R.string.emptyError)
            } else {
                result.text = choicesArr.random().toString()
            }
        }

    }
}