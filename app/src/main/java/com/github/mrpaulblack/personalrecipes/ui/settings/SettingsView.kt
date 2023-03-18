package com.github.mrpaulblack.personalrecipes.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.mrpaulblack.personalrecipes.repository.Repository

object Settings {
    const val route: String = "settings"

    @Composable
    fun Content() {
        val repository = Repository(LocalContext.current) // Init of repository

        ElevatedCard(
            modifier = Modifier
                .size(
                    width = LocalConfiguration.current.screenWidthDp.dp,
                    height = (LocalConfiguration.current.screenHeightDp.dp)
                )
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )

        ) {
            Column(Modifier
                .fillMaxSize()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row() {
                        Text(
                            text = "Personal Settings",
                            fontSize = 30.sp
                        )
                    }
                }
                Column() {
                    Row() {
                        Text(
                            text = "Tools: ",
                        )
                    }
                    Row() {
                        Text(
                            text = "DELETE THIS -> Here should be Georgs searchable list",
                        )
                    }
                }
                Column() {
                    Row() {
                        Text(
                            text = "Health Labels: ",
                        )
                    }
                    Row() {
                        Text(
                            text = "Health Labels: ",
                        )
                        repository.setLocaleStorageData("test", "123")
                        println(repository.getLocaleStorageData("test"))
                    }
                }
                Column() {
                    Row() {
                        Text(
                            text = "Cautions",
                        )
                    }
                }
            }
        }
    }
}
