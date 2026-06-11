package org.shahtott.pet_shelter_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

