package com.example.adtask

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson


public class  ProfileUtil(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        Constants.USER_SHARED_PREFERENCES,
        Context.MODE_PRIVATE
    )

    private var editor: SharedPreferences.Editor? = null

    var user: ListOfUsers? = null
        get() {
            val serializedUser = sharedPreferences.getString(Constants.USERLIST, "")
            return Gson().fromJson(serializedUser, ListOfUsers::class.java) ?: return null
        }


    fun saveUser(user:ListOfUsers?) {
        editor = sharedPreferences.edit()
        if (user == null) {
            editor!!.remove(Constants.USERLIST)
            editor!!.apply()
            return
        }
        editor = sharedPreferences.edit()
        editor?.putString(Constants.USERLIST, Gson().toJson(user))
        editor?.apply()
    }

    companion object {
        private var profileUtilInstance: ProfileUtil? = null
        val instance: ProfileUtil?
            get() {
                if (profileUtilInstance == null) {
                    profileUtilInstance =
                        RaiffeisenBankAplilcation.context?.let { ProfileUtil(it) }

                }
                return profileUtilInstance
            }

        fun getInstance(context: Context): ProfileUtil? {
            if (profileUtilInstance == null) {
                profileUtilInstance = ProfileUtil(context)
            }
            return profileUtilInstance
        }
    }
}