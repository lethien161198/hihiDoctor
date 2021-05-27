package com.example.test.modules.view

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.adapter.LatestNewsAdapter
import com.example.test.adapter.NewsAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_main.*

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun initComponent(viewBinding: FragmentHomeBinding) {
        var list = mutableListOf<String>()
        list.add("data:image/jpeg;base64,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")
        list.add("data:image/jpeg;base64,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")
        list.add("data:image/jpeg;base64,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")
        list.add("data:image/jpeg;base64,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")
        list.add("data:image/jpeg;base64,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")
        list.add("data:image/jpeg;base64,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")
        viewBinding.viewPager.adapter = context?.let { NewsAdapter(list, it) }

        viewBinding.latestNewsList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewBinding.latestNewsList.adapter = context?.let { LatestNewsAdapter(list,it) }
        viewBinding.latestNewsList.adapter?.notifyDataSetChanged()

//        viewBinding.seeAll.setOnClickListener {
//            replaceFragmentToMainFragment(ArticlesFragment(),"articles",true)
//        }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_home

}