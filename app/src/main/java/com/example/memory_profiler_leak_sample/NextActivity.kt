package com.example.memory_profiler_leak_sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.memory_profiler_leak_sample.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_next)

        supportFragmentManager.beginTransaction().replace(
            binding.fragmentContainerView.id,
            NextFragment.newInstance()
        ).commit()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, NextActivity::class.java)
        }
    }
}
