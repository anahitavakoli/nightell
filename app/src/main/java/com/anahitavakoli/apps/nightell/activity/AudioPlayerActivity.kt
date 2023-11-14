package com.anahitavakoli.apps.nightell.activity


import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anahitavakoli.apps.nightell.R
import com.anahitavakoli.apps.nightell.database.Database
import com.anahitavakoli.apps.nightell.databinding.ActivityMusicPlayerBinding
import com.anahitavakoli.apps.nightell.model.Audio
import java.util.Timer
import java.util.TimerTask


class AudioPlayerActivity : AppCompatActivity() {

    lateinit var binding: ActivityMusicPlayerBinding
    var audio: Audio ?= null
    lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        audio = if(Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra("audio",Audio::class.java)
        }else{
            intent.getParcelableExtra<Audio>("audio")
        }

        var audioSource = audio!!.mp3Url
        player = MediaPlayer()
        player.setDataSource(audioSource)
        player.prepare()
        player.start()

        binding.btnPlay.setOnClickListener {
            if(player.isPlaying){
                player.pause()
                binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
            }
            else{
                player.start()
                binding.btnPlay.setImageResource(R.drawable.baseline_pause_24)
            }
        }

        if(Database.db.favoriteDao().isAudioExist(audio!!.id)){
            binding.btnFav.setImageResource(R.drawable.baseline_favorite_24)
        }else{
            binding.btnFav.setImageResource(R.drawable.baseline_favorite_border_24)
        }

        binding.btnFav.setOnClickListener {

            if(!Database.db.favoriteDao().isAudioExist(audio!!.id)){
                var result = Database.db.favoriteDao().addAudio(audio!!)
                if(result > 0){
                    Toast.makeText(applicationContext,"Audio added",Toast.LENGTH_LONG).show()
                    binding.btnFav.setImageResource(R.drawable.baseline_favorite_24)
                }
                else{
                    Toast.makeText(applicationContext,"Ridi",Toast.LENGTH_LONG).show()
                }
            }
            else{
                Database.db.favoriteDao().delete(audio!!)
                binding.btnFav.setImageResource(R.drawable.baseline_favorite_border_24)
            }

        }


        var audioDuration = player.duration
        var audioPosition = player.currentPosition
        var timer = Timer()

        binding.seekbar.max = audioDuration
        binding.seekbar.progress = audioPosition

        val arrayDuration = splitTime(audioDuration)
        binding.txtDuration.text = "${arrayDuration[0]} : ${arrayDuration[1]}"


        timer.scheduleAtFixedRate(object: TimerTask(){
            override fun run() {
                if(player.isPlaying){
                    binding.seekbar.progress = player.currentPosition
                    val arrayCurrent = splitTime(player.currentPosition)
                    runOnUiThread{
                        binding.txtCurrentPosition.text = "${arrayCurrent[0]} : ${arrayCurrent[1]}"
                    }
                }
            }

        },0,1000)


    }


    fun splitTime(ms : Int) : IntArray{
        var s = ms/1000
        val m = s/60
        s -= m * 60
        return intArrayOf(m , s)
    }

}