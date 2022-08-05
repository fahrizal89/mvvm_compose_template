package com.fahrizal.mvvmcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fahrizal.mvvmcompose.R
import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.ui.MainViewModel.PrayUiState.Error
import com.fahrizal.mvvmcompose.ui.MainViewModel.PrayUiState.Loaded
import com.fahrizal.mvvmcompose.ui.common.ErrorDialog
import com.fahrizal.mvvmcompose.ui.common.Loading
import com.fahrizal.mvvmcompose.ui.theme.MVVMComposeTheme
import com.fahrizal.mvvmcompose.util.TimeUtil
import com.fahrizal.mvvmcompose.util.TimeUtil.getTimeFormated
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrayScreen()
        }
    }
}

@Composable
fun PrayScreen(mainViewModel: MainViewModel = viewModel()) {
    MVVMComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Title()

                when (val state = mainViewModel.uiState.collectAsState().value) {
                    is Loaded -> PrayList(state.prayList)
                    is Error -> ErrorDialog(state.resId)
                    else -> Loading()
                }
            }
        }
    }
}

@Composable
fun Title() {
    val title = stringResource(id = R.string.pray_schedules)
    val dateString = TimeUtil.getLocaleFormat(Date())
    Text(
        text = title.plus(" on ").plus(dateString),
        Modifier.padding(8.dp)
    )
}

@Composable
fun PrayList(prayList: List<Pray>) {
    Column(Modifier.padding(8.dp)) {
        for (pray in prayList) {
            Row {
                Text(text = pray.time.getTimeFormated())
                Text(text = pray.name, Modifier.padding(start = 32.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVMComposeTheme {
        val list = ArrayList<Pray>()
        list.add(Pray(0, "Jakarta", "Isha"))
//        PrayList(list)
        PrayScreen()
    }
}