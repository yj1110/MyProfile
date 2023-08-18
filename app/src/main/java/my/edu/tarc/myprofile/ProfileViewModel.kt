package my.edu.tarc.myprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
   /* private val _profile: MutableLiveData<Public> by lazy {
        MutableLiveData<Public>(
            Public("", "", ""))
    }*/


//    val profile: LiveData<Public> get() = _profile

    var profile = Public("", "", "");
}