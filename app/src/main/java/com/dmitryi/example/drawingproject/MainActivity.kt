package com.dmitryi.example.drawingproject


import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dmitryi.example.drawingproject.PaintView.Companion.colorList
import com.dmitryi.example.drawingproject.PaintView.Companion.currentBrush
import com.dmitryi.example.drawingproject.PaintView.Companion.pathList
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "LAST_SELECTED_ITEM"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationMenu: BottomNavigationView

 companion object {
        var path = Path()
        var brush = Paint()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        val intent = Intent(Intent.ACTION_SEND)
        intent.type="text/plain"
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Привет! Хочу поделиться классным приложением. Посмотри!"
        )

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.drawing -> {
                    fragment = DrawingFragment()
                    replaceFragment(fragment)

                }
                R.id.brush_size -> {
                    //on demo-verison not realise
                }
                R.id.share_app -> {
                    val chooser= Intent.createChooser(intent, "Поделиться")
                    startActivity(chooser)
                }
            }

            true
        }
        bottomNavigationMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.drawing

               val redButton = findViewById<ImageButton>(R.id.redColor)
               val grayButton = findViewById<ImageButton>(R.id.grayColor)
               val yellowButton = findViewById<ImageButton>(R.id.yellowColor)
               val greenButton = findViewById<ImageButton>(R.id.greenColor)
               val blueButton = findViewById<ImageButton>(R.id.blueColor)
               val darkBlueButton = findViewById<ImageButton>(R.id.darkBlueColor)
               val violetButton = findViewById<ImageButton>(R.id.violetColor)
               val whiteButton = findViewById<ImageButton>(R.id.whiteColor)
               val blackButton = findViewById<ImageButton>(R.id.blackColor)
               val eraser = findViewById<ImageButton>(R.id.eraser)

               redButton.setOnClickListener {
                   Toast.makeText(this, "Красный", Toast.LENGTH_SHORT).show()
                   brush.color = Color.RED
                   currentColor(brush.color)
               }

               grayButton.setOnClickListener {
                   Toast.makeText(this, "Оранжевый", Toast.LENGTH_SHORT).show()
                   brush.color = Color.GRAY
                   currentColor(brush.color)
               }

               yellowButton.setOnClickListener {
                   Toast.makeText(this, "Желтый", Toast.LENGTH_SHORT).show()
                   brush.color = Color.YELLOW
                   currentColor(brush.color)
               }

               greenButton.setOnClickListener {
                   Toast.makeText(this, "Зеленый", Toast.LENGTH_SHORT).show()
                   brush.color = Color.GREEN
                   currentColor(brush.color)
               }

               blueButton.setOnClickListener {
                   Toast.makeText(this, "Голубой", Toast.LENGTH_SHORT).show()
                   brush.color = Color.CYAN
                   currentColor(brush.color)
               }

               darkBlueButton.setOnClickListener {
                   Toast.makeText(this, "Синий", Toast.LENGTH_SHORT).show()
                   brush.color = Color.BLUE
                   currentColor(brush.color)
               }

               violetButton.setOnClickListener {
                   Toast.makeText(this, "Фиолетовый", Toast.LENGTH_SHORT).show()
                   brush.color = Color.MAGENTA
                   currentColor(brush.color)
               }

               whiteButton.setOnClickListener {
                   Toast.makeText(this, "Ластик", Toast.LENGTH_SHORT).show()
                   brush.color = Color.WHITE
                   currentColor(brush.color)
               }

               blackButton.setOnClickListener {
                   Toast.makeText(this, "Черный", Toast.LENGTH_SHORT).show()
                   brush.color = Color.BLACK
                   currentColor(brush.color)
               }

               eraser.setOnClickListener {
                   Toast.makeText(this, "Сброс листа", Toast.LENGTH_SHORT).show()
                   pathList.clear()
                   colorList.clear()
                   path.reset()
               }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }

    private fun currentColor(color: Int) {
        currentBrush = color
        path = Path()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}