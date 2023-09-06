package com.example.testapphostel.present

import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.testapphostel.data.*
import com.example.testapphostel.domian.DataClass.*
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
open class ViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _isLoadFile: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoadFile: StateFlow<Boolean> = _isLoadFile.asStateFlow()

    private val _listImages: MutableStateFlow<List<String>?> = MutableStateFlow(emptyList())
    val listImages = _listImages.asStateFlow()

    private val _hostel: MutableStateFlow<Hostels?> = MutableStateFlow(null)
    val hostel = _hostel.asStateFlow()

    private val _listRoom: MutableStateFlow<List<Room>?> = MutableStateFlow(emptyList())
    val listRoom = _listRoom.asStateFlow()

    private val _reservList: MutableStateFlow<Rezerv?> = MutableStateFlow(null)
    val reservList = _reservList.asStateFlow()

    fun getDataHostel() {
        viewModelScope.launch {
            var response = repository.getDataHostel()
            if (response?.id !=null){
                _hostel.value=response
                _listImages.value=response.image_urls
                _isLoadFile.value =true

                listImages.collect { android.util.Log.d("MyLog","ViewModel.kt. getData: $it") }
            }
        }


    }

    suspend fun getDataRoom(){
        viewModelScope.launch {
            _listRoom.value=repository.getDataRoom()?.rooms
        }.join()
    }

    suspend fun getDataRezerv(){
        viewModelScope.launch {
            _reservList.value=repository.getDataRezerv()

        }.join()
    }
}