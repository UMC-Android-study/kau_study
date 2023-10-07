package com.example.flo_clone

import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import androidx.appcompat.app.AppCompatActivity
import com.example.flo_clone.databinding.ActivityMainBinding
import com.example.flo_clone.databinding.ActivitySongBinding

/*이파일은 전부 ㄱㅊ아요*/

class SongActivity :AppCompatActivity() {
    lateinit var binding: ActivitySongBinding //binding은 xml파일과 class파일을 연결하는 것

    override fun onCreate(savedInstanceState: Bundle?) { //함수가 실행될떄 처음으로실행되는애
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root) //xml에 있는걸가져와서우리가맘껏쓰게할거야!
        //binding.root 가 우리가 맘대로쓸아이디
        //root는 xml파일의 최상단 뷰. 즉, 맥티비티_송xml의 맨위constraint레이아웃뷰
        binding.songBtnArrowDownIv.setOnClickListener {
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }

        //받는사람입장에선 인텐트데이터가올수도안올수도잇으니 if문
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            binding.songPlayerTitleTv.text = intent.getStringExtra("title")
            binding.songPlayerNameTv.text = intent.getStringExtra("singer")
        }

    }

    fun setPlayerStatus(isPlaying : Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
        else{
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }

}