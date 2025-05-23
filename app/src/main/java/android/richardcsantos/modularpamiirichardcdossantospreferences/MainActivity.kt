package android.richardcsantos.modularpamiirichardcdossantospreferences

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.richardcsantos.modularpamiirichardcdossantospreferences.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

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
            saveColor(color)
        }

        binding.color2.setOnClickListener {
            color = "#673AB7"
            saveColor(color)
        }

        binding.color3.setOnClickListener {
            color = "#FFC107"
            saveColor(color)
        }

        binding.color4.setOnClickListener {
            color = "#009688"
            saveColor(color)
        }

        binding.color5.setOnClickListener {
            color = "#FF5722"
            saveColor(color)
        }


    }

    override fun onResume() {
        super.onResume()

        val preferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE)
        val color = preferences.getString("color", "")

        if (color!!.isNotEmpty()) {
            binding.main.setBackgroundColor(Color.parseColor(color))
        }
    }

    private fun saveColor(color: String) {
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

    private fun snackBar(view: View) {
        val snackbar =
            Snackbar.make(view, "Cor de fundo alterada com sucesso", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK") {

        }

        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()
    }
}
