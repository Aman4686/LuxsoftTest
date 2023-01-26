package com.example.luxsofttest.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.luxsofttest.ui.screens.main.state.DisplayMainViewState
import com.example.luxsofttest.ui.screens.main.view.MainScreenDisplay

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {

    val state by viewModel.mainViewStateFlow.collectAsState()
    MainScreenDisplay()
//    when(state){
//        is DisplayMainViewState -> {
//            MainScreenDisplay()
//        }
//    }
}