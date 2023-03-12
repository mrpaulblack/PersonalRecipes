package com.github.mrpaulblack.personalrecipes.repository

interface LocaleDatabase {
    fun fetchDatabase(): List<String>
}

// Keine Sample data
// This is the Comunications gateway
class DatabaseRepository: LocaleDatabase {

    private val dataSource: Database = Database()
    // in contructor : connectin to firebase sdk

    // Fetch the data/cache the data here
    // suspend == async (but without await ???)
    override fun  fetchDatabase() : List<String> {

        // Make DB call OR fetch from Cache
        return dataSource.fetchDatabase();
    }
}
