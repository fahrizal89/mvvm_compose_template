package com.fahrizal.mvvmcompose.ui

import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.domain.usecase.GetPraySchedules
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class MainVIewModelTest {

    @Test
    fun fetchDataShouldReturnPrayList() = runTest {
        //given
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        val getPraySchedules = Mockito.mock(GetPraySchedules::class.java)
        val viewModel = MainViewModel(testDispatcher, getPraySchedules)
        val city = "Jakarta"
        val mockResult = createMockPraySchedules()
        Mockito
            .`when`(getPraySchedules(city))
            .thenReturn(flow { emit(mockResult) })

        //when
        viewModel.fetchData(city)

        //then
        val prays = (viewModel.uiState.value as MainViewModel.PrayUiState.Loaded).prayList
        for (i: Int in prays.indices) {
            Assert.assertEquals(prays[i], mockResult[i])
        }
    }

    private fun createMockPraySchedules(): List<Pray> {
        val prays = ArrayList<Pray>()

        prays.add(Pray(1660365647, "Jakarta", "Fajr"))
        prays.add(Pray(1660365647, "Jakarta", "Dhuhr"))
        prays.add(Pray(1660365647, "Jakarta", "Ashr"))
        prays.add(Pray(1660365647, "Jakarta", "Maghrib"))
        prays.add(Pray(1660365647, "Jakarta", "Isha"))

        return prays
    }
}