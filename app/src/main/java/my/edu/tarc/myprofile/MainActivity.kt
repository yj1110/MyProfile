package my.edu.tarc.myprofile

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import my.edu.tarc.myprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
val profileViewModel: ProfileViewModel by viewModels()
private lateinit var myPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myPreference = getPreferences(Context.MODE_PRIVATE)

        binding.textViewName.text = myPreference
            .getString(getString(R.string.name),"")
        binding.textViewEmail.text = myPreference. getString(getString(R.string.email),"")
        binding.textViewPhone.text = myPreference. getString(getString(R.string.phone),"")

        binding.saveButton.setOnClickListener{
           profileViewModel.profile = Public(
               binding.editName.text.toString(),
               binding.editEmail.text.toString(),
               binding.editPhone.text.toString()
           )

            with (myPreference.edit()){
                putString(getString(R.string.name), binding.editName.text.toString())
                putString(getString(R.string.email), binding.editEmail.text.toString())
                putString(getString(R.string.phone), binding.editPhone.text.toString())
                apply()
            }

            binding.textViewName.text = profileViewModel.profile.name
            binding.textViewEmail.text = profileViewModel.profile.email
            binding.textViewPhone.text = profileViewModel.profile.phone

        }
        Log.d("Main", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main", "onDestroy")
    }
}