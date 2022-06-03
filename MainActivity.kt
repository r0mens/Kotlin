package com.example.colorinputdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var colorNames = arrayOf<String>("AliceBlue", "AntiqueWhite", "Aqua",
        "Aquamarine", "Azure", "Beige", "Bisque", "Black", "BlanchedAlmond",
        "Blue", "BlueViolet", "Brown", "BurlyWood", "CadetBlue", "Chartreuse",
        "Chocolate", "Coral", "CornflowerBlue", "Cornsilk", "Crimson",
        "Cyan", "DarkBlue", "DarkCyan", "DarkGoldenRod", "DarkGray",
        "DarkGrey", "DarkGreen", "DarkKhaki", "DarkMagenta",
        "DarkOliveGreen", "Darkorange", "DarkOrchid", "DarkRed",
        "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue", "DarkSlateGray",
        "DarkSlateGrey", "DarkTurquoise", "DarkViolet", "DeepPink",
        "DeepSkyBlue", "DimGray", "DimGrey", "DodgerBlue", "FireBrick",
        "FloralWhite", "ForestGreen", "Fuchsia", "Gainsboro", "GhostWhite",
        "Gold", "GoldenRod", "Gray", "Grey", "Green", "GreenYellow",
        "HoneyDew", "HotPink", "IndianRed", "Indigo", "Ivory", "Khaki",
        "Lavender", "LavenderBlush", "LawnGreen", "LemonChiffon", "LightBlue",
        "LightCoral", "LightCyan", "LightGoldenRodYellow", "LightGray",
        "LightGrey", "LightGreen", "LightPink", "LightSalmon",
        "LightSeaGreen", "LightSkyBlue", "LightSlateGray", "LightSlateGrey",
        "LightSteelBlue", "LightYellow", "Lime", "LimeGreen", "Linen",
        "Magenta", "Maroon", "MediumAquaMarine", "MediumBlue", "MediumOrchid",
        "MediumPurple", "MediumSeaGreen", "MediumSlateBlue",
        "MediumSpringGreen", "MediumTurquoise", "MediumVioletRed",
        "MidnightBlue", "MintCream", "MistyRose", "Moccasin", "NavajoWhite",
        "Navy", "OldLace", "Olive", "OliveDrab", "Orange", "OrangeRed",
        "Orchid", "PaleGoldenRod", "PaleGreen", "PaleTurquoise",
        "PaleVioletRed", "PapayaWhip", "PeachPuff", "Peru", "Pink", "Plum",
        "PowderBlue", "Purple", "Red", "RosyBrown", "RoyalBlue",
        "SaddleBrown", "Salmon", "SandyBrown", "SeaGreen", "SeaShell",
        "Sienna", "Silver", "SkyBlue", "SlateBlue", "SlateGray", "SlateGrey",
        "Snow", "SpringGreen", "SteelBlue", "Tan", "Teal", "Thistle",
        "Tomato", "Turquoise", "Violet", "Wheat", "White", "WhiteSmoke",
        "Yellow", "YellowGreen")

    var hexCodes = arrayOf<String>("#F0F8FF", "#FAEBD7", "#00FFFF",
        "#7FFFD4", "#F0FFFF", "#F5F5DC", "#FFE4C4", "#000000", "#FFEBCD",
        "#0000FF", "#8A2BE2", "#A52A2A", "#DEB887", "#5F9EA0", "#7FFF00",
        "#D2691E", "#FF7F50", "#6495ED", "#FFF8DC", "#DC143C", "#00FFFF",
        "#00008B", "#008B8B", "#B8860B", "#A9A9A9", "#A9A9A9", "#006400",
        "#BDB76B", "#8B008B", "#556B2F", "#FF8C00", "#9932CC", "#8B0000",
        "#E9967A", "#8FBC8F", "#483D8B", "#2F4F4F", "#2F4F4F", "#00CED1",
        "#9400D3", "#FF1493", "#00BFFF", "#696969", "#696969", "#1E90FF",
        "#B22222", "#FFFAF0", "#228B22", "#FF00FF", "#DCDCDC", "#F8F8FF",
        "#FFD700", "#DAA520", "#808080", "#808080", "#008000", "#ADFF2F",
        "#F0FFF0", "#FF69B4", "#CD5C5C", "#4B0082", "#FFFFF0", "#F0E68C",
        "#E6E6FA", "#FFF0F5", "#7CFC00", "#FFFACD", "#ADD8E6", "#F08080",
        "#E0FFFF", "#FAFAD2", "#D3D3D3", "#D3D3D3", "#90EE90", "#FFB6C1",
        "#FFA07A", "#20B2AA", "#87CEFA", "#778899", "#778899", "#B0C4DE",
        "#FFFFE0", "#00FF00", "#32CD32", "#FAF0E6", "#FF00FF", "#800000",
        "#66CDAA", "#0000CD", "#BA55D3", "#9370D8", "#3CB371", "#7B68EE",
        "#00FA9A", "#48D1CC", "#C71585", "#191970", "#F5FFFA", "#FFE4E1",
        "#FFE4B5", "#FFDEAD", "#000080", "#FDF5E6", "#808000", "#6B8E23",
        "#FFA500", "#FF4500", "#DA70D6", "#EEE8AA", "#98FB98", "#AFEEEE",
        "#D87093", "#FFEFD5", "#FFDAB9", "#CD853F", "#FFC0CB", "#DDA0DD",
        "#B0E0E6", "#800080", "#FF0000", "#BC8F8F", "#4169E1", "#8B4513",
        "#FA8072", "#F4A460", "#2E8B57", "#FFF5EE", "#A0522D", "#C0C0C0",
        "#87CEEB", "#6A5ACD", "#708090", "#708090", "#FFFAFA", "#00FF7F",
        "#4682B4", "#D2B48C", "#008080", "#D8BFD8", "#FF6347", "#40E0D0",
        "#EE82EE", "#F5DEB3", "#FFFFFF", "#F5F5F5", "#FFFF00", "#9ACD32")

        val hex_pattern= Regex("^#[0-9A-Fa-f]{6}$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actvColorName = findViewById<AutoCompleteTextView>(R.id.actvColorName)
        val tvColor1 = findViewById<TextView>(R.id.tvColor1)

        val etHexCode = findViewById<EditText>(R.id.etHexCode)
        val tvColor2 = findViewById<TextView>(R.id.tvColor2)



        val aaColorName = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, colorNames)
        actvColorName.setAdapter(aaColorName)
        actvColorName.setThreshold(1);

        actvColorName.setOnItemClickListener { adapterView, view, i, l ->

            Toast.makeText(applicationContext,actvColorName.text.toString(),Toast.LENGTH_LONG).show()
            try {
                tvColor1.setBackgroundColor(Color.parseColor(actvColorName.text.toString()))
            }catch(e: Exception){
                var index = colorNames.indexOf(actvColorName.text.toString())
                Toast.makeText(applicationContext,""+index,Toast.LENGTH_LONG).show()
                tvColor1.setBackgroundColor(Color.parseColor(hexCodes[index]))
            }
        }

        etHexCode.addTextChangedListener(object : TextWatcher {
            //sometimes you need to have some methods even if they are empty
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if(hex_pattern.matches(s)){
                    etHexCode.setBackgroundColor(Color.GREEN)
                }else{
                    etHexCode.setBackgroundColor(Color.GRAY)
                }
            }
        }) //end addTextChangeListener

        etHexCode.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Toast.makeText(this,"Enter",Toast.LENGTH_LONG).show()
                if(hex_pattern.matches(etHexCode.text.toString())){
                    tvColor2.setBackgroundColor(Color.parseColor(etHexCode.text.toString()))
                }else{
                    tvColor2.setBackgroundColor(Color.BLACK)
                    Toast.makeText(this,"Problem with hexcode", Toast.LENGTH_LONG).show()
                }

            return@OnKeyListener true
            }
            false
        })

    }//end onCreate
}//end MainActivity