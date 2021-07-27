package com.example.adtask


import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.coroutines.Job


class LoginViewModel : ViewModel() {


    fun doLogin(taskList: ListOfUsers, username: String, password: String): Int {
        var response: Int = -2
        var found=false
        var foundPass=false
        for (i in 0 until taskList.size) {
             if (taskList[i].email == username.toString()) {
                 found=true
                 if (taskList[i].password != password.toString()) {
                     foundPass=true
                 }
            }
        }
        response = if (found){
            if (foundPass){
                0
            }else{
                -1
            }
        }else{
            1
        }
        return response

    }

    fun doSignUp(taskList: ListOfUsers, username: String, password: String): Int {
        var response: Int = -2
        ProfileUtil.instance?.saveUser(taskList)
        for (i in 0 until taskList.size) {
            if (username == taskList[i].email) {
                response = -1
            }
            if (username.length < 6 && !username.contains("@")) {
                response = 0
            }

            if (password.length < 6) {
                response = 1
            }

        }
        return response
    }

    private var viewModelJob = Job()


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}