package com.example.adtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {

    var taskList = ListOfUsers()
    var currentUsers: ArrayList<User>? = null
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
        return inflater.inflate(R.layout.fragment_sign_up, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        currentUsers = ProfileUtil.instance?.user
        taskList = currentUsers as ListOfUsers
        btnSignUp.setOnClickListener {
            if (loginViewModel.doSignUp(taskList,inputEmail.text.toString(),inputPassword.text.toString())==-1){
                Toast.makeText(context,"This user does exist...", Toast.LENGTH_SHORT).show()
            }else if(loginViewModel.doSignUp(taskList,inputEmail.text.toString(),inputPassword.text.toString())==0){
                Toast.makeText(context,"Your email input should be validated...",Toast.LENGTH_SHORT).show()
            }else if(loginViewModel.doSignUp(taskList,inputEmail.text.toString(),inputPassword.text.toString())==1){
                Toast.makeText(context,"Your password input should be at least 6 characters...",Toast.LENGTH_SHORT).show()
            }else{
                val data = User(inputEmail.text.toString(), inputPassword.text.toString())
                saveData(data)
                val action =
                    SignUpFragmentDirections
                        .actionSignUpFragmentToLoginFragment()
                view.findNavController().navigate(action)
            }
            
        }
        goToLogin.setOnClickListener{
            val action =
                SignUpFragmentDirections
                    .actionSignUpFragmentToLoginFragment()
            view.findNavController().navigate(action)
        }
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
    private fun saveData(user: User) {
        taskList.add(user)
        ProfileUtil.instance?.saveUser(taskList)
    }
}