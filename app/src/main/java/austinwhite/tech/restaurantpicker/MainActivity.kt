package austinwhite.tech.restaurantpicker

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input: EditText = findViewById(R.id.userInput)
        val removeInput: EditText = findViewById(R.id.removeInput)
        val add: Button = findViewById(R.id.add)
        val clear: Button = findViewById(R.id.clear)
        val choose: Button = findViewById(R.id.choose)
        val removeButton: Button = findViewById(R.id.remove)
        val choices: TextView = findViewById(R.id.choices)
        val result: TextView = findViewById(R.id.result)

        val choicesArr = ArrayList<String>()

        add.setOnClickListener {
            if (input.text.toString().isBlank()){
                Toast.makeText(this@MainActivity, getString(R.string.empty), Toast.LENGTH_SHORT).show()

            } else {
                choicesArr.add(input.text.toString())
                choices.text = choicesArr.toString().replace("[", "").replace("]", "")
                input.setText("")
                Log.i("Debug Check", choicesArr.toString()) //for debug purposes
            }
        }

        clear.setOnClickListener {
            choicesArr.clear()
            choices.text = getString(R.string.choice)
            result.text = getString(R.string.result)
            Log.i("Debug Check", choicesArr.toString()) //for debug purposes
        }

        choose.setOnClickListener {
            if (choicesArr.isEmpty()) {
                Toast.makeText(this@MainActivity, getString(R.string.empty), Toast.LENGTH_SHORT).show()

            } else {
                result.text = choicesArr.random().toString()
            }
        }

        removeButton.setOnClickListener {

            if (removeInput.text.toString().isBlank()) {
            Toast.makeText(this@MainActivity, "Nothing Here!", Toast.LENGTH_SHORT).show()

        } else {
                if (choicesArr.contains(removeInput.text.toString())) {
                    choicesArr.remove(removeInput.text.toString())
                    choices.text = choicesArr.toString().replace("[", "").replace("]", "")
                    Log.i("Debug Check", choicesArr.toString()) //for debug purposes
                    removeInput.setText("")

                } else {
                    Toast.makeText(this@MainActivity, "Entry not found", Toast.LENGTH_SHORT).show()


                }
            }
        }

    }
}