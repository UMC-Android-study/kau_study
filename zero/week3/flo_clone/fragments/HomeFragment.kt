package com.example.flo_clone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.flo_clone.BannerVPAdapter
import com.example.flo_clone.MainActivity
import com.example.flo_clone.R
import com.example.flo_clone.databinding.FragmentHomeBinding

class HomeFragment:Fragment() {
    /*private val mBinding : FragmentHomeBinding? = null*/
    //위는 언제 뭐하려고 만든건지 알수없음;
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homePannelAlbumImgbIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
        }
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }
}