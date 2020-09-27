package com.example.silly_cat_api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SillyCatResponseItem(
    //Newly Added
    val breeds: List<Breeds>,
    //val categories: List<Cat egory>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
):Parcelable



@Parcelize
data class Breeds(
    val weight: Weight?,
    val id: String,
    val name: String?,

    val cfa_url: String,
    val vetstreet_url: String,
    val vcahospitals_url: String,

    val temperament: String,
    val origin: String,
    val country_codes: String,
    val country_code: String,

    val description: String,
    val life_span: String,

    //Boolean - Int value between 0 & 1
    val indoor: Int,

    val alt_name: String,

    //Values - Int between 1 & 5
    val adaptability: Int,
    val affection_level: Int,
    val child_friendly: Int,
    val dog_friendly: Int,
    val energy_level: Int,
    val grooming: Int,
    val health_issues: Int,
    val intelligence: Int,
    val shedding_level: Int,
    val social_needs: Int,
    val stranger_friendly: Int,
    val vocalisation: Int,

    //Boolean values - Int between 0 & 1
    val experimental: Int,
    val hairless: Int,
    val natural: Int,
    val rare: Int,
    val rex: Int,
    val suppressed_tail: Int,
    val short_legs: Int,

    //String
    val wikipedia_url: String,

    //Boolean value - Int between 0 & 1
    val hypoallergenic: Int


):Parcelable



@Parcelize
data class Weight(
    val imperial: String,
    val metric: String
):Parcelable