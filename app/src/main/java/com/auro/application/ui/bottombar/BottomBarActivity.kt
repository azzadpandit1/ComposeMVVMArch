package com.auro.application.ui.bottombar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.auro.application.ui.bottombar.appstate.rememberAppState
import com.auro.application.ui.bottombar.navigation.BottomBarNavigation
import com.auro.application.ui.theme.AuroscholarAppTheme

class BottomBarActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.e("TAG", "onCreate: data is here  ", )
            AuroscholarAppTheme{
                val appState = rememberAppState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            if (appState.shouldShowBottomBar)
                                BottomAppBar(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentPadding = PaddingValues(horizontal = 20.dp),
                                    modifier = Modifier
                                        .height(70.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 24.dp, topEnd = 24.dp
                                            )
                                        )
                                ) {
                                    BottomBarRow(
                                        navHostController = appState.navHostController,
                                    )
                                }
                        }
                    ) { innerPadding ->
                        BottomBarNavigation(
                            navHostController = appState.navHostController,
                            padding = innerPadding,
                            this
                        )
                    }
                }
            }
        }

    }


}