package io.eyram.db

import org.jetbrains.exposed.sql.Database

object DatabaseFactory {
    val db by lazy {
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/dots",
            driver = "org.postgresql.Driver",
            user = "eyram",
            password = "alchemist"
        )
    }
}
