package com.adedom.ui_component.domain.models

data class ProfileComponent(
    val name: String,
    val value: String,
    val contentDescription: String?,
    val width: Int,
    val height: Int
) : UiComponent