package com.ugurrsnr.multilanguageexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ugurrsnr.multilanguageexample.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    lateinit var myPreference : MyPreference

    val languageList = arrayOf("en","tr","es")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreference = MyPreference(this) //initialize myPreference

        binding.spinner.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1, languageList)

        val lang : String = myPreference.getLoginLanguage()
        val index : Int = languageList.indexOf(lang)
        if (index >= 0){
            binding.spinner.setSelection(index)
        }

        //submit Button
        binding.button.setOnClickListener {
            myPreference.setLoginLanguage(languageList[binding.spinner.selectedItemPosition])
            val intentToMainActivity = Intent(this,MainActivity::class.java)
            startActivity(intentToMainActivity)
            finish()
        }



    }
}