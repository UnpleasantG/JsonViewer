package top.college.jsonviewer

import kotlinx.serialization.Serializable

@Serializable
data class User(val id: String, val name: String)
