package com.example.n007.automate.model

import com.google.gson.annotations.SerializedName

/**
 * Created by N007 on 27/4/2561.
 */
class Info {
    data class PersonalInfoResponse(
            @SerializedName("name") var _name: String?,
            @SerializedName("gender") var _gender: String,
            @SerializedName("birth_year") var _birth_year: String,
            @SerializedName("height") var _height: Int,
            @SerializedName("mass") var _mass: Int,
            @SerializedName("hair_color") var _hair_color: String,
            @SerializedName("skin_color") var _skin_color: String,
            @SerializedName("eye_color") var _eye_color: String,
            @SerializedName("homeworld") var _homeworld: String)
    data class address(
            val name: String,
            val terrain: String,
            val population: Int)

    data class species(
            val name: String,
            val classification: String,
            val language: String)


}
