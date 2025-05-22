package android.richardcsantos.modularpamiirichardcdossantospreferences

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.richardcsantos.modularpamiirichardcdossantospreferences.databinding.ActivityMainBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var color = ""

    private lateinit var preferences: SharedPreferences

    companion object {
        const val NAME_FILE = "file_preferences.xml"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)
        binding.color1.setOnClickListener {
            color = "#E91E63"
            binding.main.setBackgroundColor(Color.parseColor(color))
        }

        binding.color2.setOnClickListener {
            color = "#673AB7"
            binding.main.setBackgroundColor(Color.parseColor(color))
        }

        binding.color3.setOnClickListener {
            color = "#FFC107"
            binding.main.setBackgroundColor(Color.parseColor(color))
        }

        binding.color4.setOnClickListener {
            color = "#009688"
            binding.main.setBackgroundColor(Color.parseColor(color))
        }

        binding.color5.setOnClickListener {
            color = "#FF5722"
            binding.main.setBackgroundColor(Color.parseColor(color))
        }

        binding.changeColor.setOnClickListener {
            binding.main.setBackgroundColor(Color.parseColor(color))
            val preferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("color", color)
            editor.putString("nome", "Richard")
            editor.putString("sobrenome", "Dos Santos")
            editor.putString("email", "Richard")
            editor.apply()

        }
    }

    private fun saveColor(color: String) {

    }
}