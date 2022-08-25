package com.ugurrsnr.multilanguageexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugurrsnr.multilanguageexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myPreference : MyPreference
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.chooseLanguageButton.setOnClickListener {
            val intentToSettingsActivity =  Intent(this,SettingsActivity::class.java)
            startActivity(intentToSettingsActivity)
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        myPreference = MyPreference(newBase!!)
        val lang: String = myPreference.getLoginLanguage()
        super.attachBaseContext(MyContextWrapper.wrap(newBase,lang))

    }
}