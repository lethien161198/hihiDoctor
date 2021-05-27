package com.example.test.modules.view.tutorial

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.adapter.QuestionAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentQuestionBinding
import com.example.test.model.Question

class QuestionFragment : BaseFragment<FragmentQuestionBinding>() {
    private lateinit var questionAdapter: QuestionAdapter
    override val layoutRes: Int
        get() = R.layout.fragment_question

    override fun initComponent(viewBinding: FragmentQuestionBinding) {
        var listData = mutableListOf<Question>()
        listData.add(Question("1","2"))
        listData.add(Question("1","2"))
        listData.add(Question("1","2"))
        listData.add(Question("1","2"))

        questionAdapter = QuestionAdapter(listData)
        viewBinding.questionRecycler.layoutManager = LinearLayoutManager(context)
        viewBinding.questionRecycler.adapter = questionAdapter
        questionAdapter.notifyDataSetChanged()
    }

}