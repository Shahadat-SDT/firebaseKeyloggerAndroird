package com.sm.sdt.firebasekeyloggerandroird

import android.text.TextUtils
import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth
import com.sm.sdt.firebasekeyloggerandroird.Consts.firebaseAuth
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


object ConstFun {

    fun getDateTime(): String {
        val dateFormat = SimpleDateFormat("dd MMM yyyy hh:mm a")
        return dateFormat.format(Calendar.getInstance().time)
    }


    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    fun isLoggedIn(firebaseAuth: FirebaseAuth): Boolean {
        return firebaseAuth.currentUser != null
    }

}