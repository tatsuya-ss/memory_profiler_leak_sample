package com.example.memory_profiler_leak_sample

import android.app.Application
import android.view.View

class ExampleApplication : Application() {
    val leakedView = mutableListOf<View>()
}
