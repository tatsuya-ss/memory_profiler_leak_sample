package com.example.memory_profiler_leak_sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.memory_profiler_leak_sample.databinding.ActivitySelectionDetailBinding

class SelectionDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_selection_detail)

        Log.d("Tatsuya", "onCreate: $intent")
        Log.d("Tatsuya", "onCreate: ${intent?.getStringExtra(SELECTION)}")
        binding.textView.text = intent.getStringExtra(SELECTION) ?: "???"


        val app = application as ExampleApplication
        app.leakedView.add(binding.textView)
        Log.d("Tatsuya", "app.leakedView.size: ${app.leakedView.size}")

        binding.backButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        private const val SELECTION = "selection"

        fun createIntent(context: Context, selection: String): Intent {
            val intent = Intent(context, SelectionDetailActivity::class.java)
            intent.putExtra(SELECTION, selection)
            return intent
        }
    }
}
