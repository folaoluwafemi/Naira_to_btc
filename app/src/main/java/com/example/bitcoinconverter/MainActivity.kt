package com.example.bitcoinconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bitcoinconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener {
            convertNairaToBitcoin()
        }
    }

    private fun convertNairaToBitcoin() {

        val bitcoinToNaira = 0.00000005
        val amount = binding.amount.text.toString().toDoubleOrNull()

        if (amount == null || amount == 0.0000){
            displayResult(0.0)
            return
        }
        var result = bitcoinToNaira * amount

        if (binding.roundSwitch.isChecked) {
            result = kotlin.math.round(result)
        }
        displayResult(result)
    }
    private fun displayResult(result: Double){
        val formattedResult = NumberFormat.getInstance().format(result)
        binding.resultText.text = getString(R.string.bitcoin_amount, formattedResult)
    }
}