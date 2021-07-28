package com.example.adtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlin.collections.ArrayList


class LogInFragment : Fragment() {

    var currentUsers: ArrayList<User>? = null

    var taskList = ListOfUsers()

    private val loginViewModel: LoginViewModel by viewModels()


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
        return inflater.inflate(R.layout.fragment_log_in, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        currentUsers = ProfileUtil.instance?.user
        taskList = currentUsers as ListOfUsers
        btnLogin?.setOnClickListener {
            if (loginViewModel.doLogin(taskList,inputEmail.text.toString(),inputPassword.text.toString())==0){
                Toast.makeText(context,"Your password was incorrect",Toast.LENGTH_SHORT).show()
            }else if(loginViewModel.doLogin(taskList,inputEmail.text.toString(),inputPassword.text.toString())==1){
                Toast.makeText(context,"You have to register first",Toast.LENGTH_SHORT).show()
            }else{
                ProfileUtil.instance?.saveUsername(inputEmail.text.toString())
                view?.findNavController()?.navigate(R.id.action_loginActivity_to_mainActivity2)
            }
           /* val data = User(username.text.toString(), password.text.toString())
            saveData(data)*/
        }
        gotoRegister.setOnClickListener {
            val action =
                LogInFragmentDirections
                    .actionLoginActivityToSignUpFragment()
            view.findNavController().navigate(action)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            LogInFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}