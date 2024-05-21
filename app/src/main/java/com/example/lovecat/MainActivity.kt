package com.example.lovecat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.lovecat.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.catButton.setOnClickListener {
            lifecycleScope.launch {
                val result = RetrofitInstance.service.getImages(num = 4)
                Glide.with(this@MainActivity).load(result[0].url).transition(withCrossFade())
                    .into(binding.ivAlbum1)
                Glide.with(this@MainActivity).load(result[1].url).transition(withCrossFade())
                    .into(binding.ivAlbum2)
                Glide.with(this@MainActivity).load(result[2].url).transition(withCrossFade())
                    .into(binding.ivAlbum3)
                Glide.with(this@MainActivity).load(result[3].url).transition(withCrossFade())
                    .into(binding.ivAlbum4)
            }
        }
    }

}
