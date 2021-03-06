package com.example.adtask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pay_pal.*
import kotlinx.android.synthetic.main.fragment_pay_pal.back_ic
import kotlinx.android.synthetic.main.fragment_settings.*


class PayPalFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay_pal, container, false)
    }


    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back_ic.setOnClickListener {
            var action =
                PayPalFragmentDirections
                    .actionPayPalToMain()
            main_nav_host_fragment.findNavController().navigate(action)
        }
        pay_pal_Wv.settings.javaScriptEnabled = true
        pay_pal_Wv.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl("https://www.paypal.com/al/signin")
                return true
            }
        }
        pay_pal_Wv.loadUrl("https://www.paypal.com/al/signin")
    }


    companion object {

        fun newInstance(param1: String, param2: String) =
            PayPalFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}