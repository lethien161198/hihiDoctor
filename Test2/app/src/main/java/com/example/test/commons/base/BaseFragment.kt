package com.example.test.commons.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.test.R


abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel>(private val vmClass: Class<ViewModel>) :
    Fragment() {
    abstract val layoutRes: Int
    private lateinit var viewModel: ViewModel
    private lateinit var viewBinding: ViewBinding

    abstract fun initComponent(viewBinding: ViewBinding)

    internal fun getViewModel():ViewModel{
        return viewModel
    }

    internal fun replaceFragment(
        fragment: Fragment,
        TAG: String?,
        addToBackStack: Boolean
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.container, fragment)
            if (addToBackStack) {
                addToBackStack(TAG)
            }
            setTransition(FragmentTransaction.TRANSIT_NONE)
            commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewModel = ViewModelProvider(this).get(vmClass)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            //            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner

            root.isClickable = true
            executePendingBindings()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initComponent(viewBinding)
    }

    open fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    open fun onBackPress() {}

    internal fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}