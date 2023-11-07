package com.example.walmart

import java.io.Serializable

class User(var firstName: String?, var lastName:String?, var userName:String?, var password:String?) : Serializable{
    override fun toString(): String {
        return "UserAccount(firstName = $firstName,lastName=$lastName,emailId=$userName,password=$password)"
    }
}