/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 package com.example.android.navigation.fragments


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.R
import com.example.android.navigation.database.QuizzesDatabase
import com.example.android.navigation.databinding.FragmentTitleBinding
import com.example.android.navigation.utils.getAndroidQuizList
import com.example.android.navigation.viewmodels.TitleFragmentViewModel
import com.example.android.navigation.viewmodels.TitleFragmentViewModelFactory


class TitleFragment : Fragment() {


    lateinit var titleFragmentViewModel: TitleFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener { view : View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToQuizFragment("Android"))
        }

        binding.playWebQuiz.setOnClickListener { view : View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToQuizFragment("Web"))
           // Toast.makeText(context, "InDevelopment", Toast.LENGTH_SHORT).show()
        }

        binding.playSqlQuiz.setOnClickListener { view : View ->
            Toast.makeText(context, "InDevelopment", Toast.LENGTH_SHORT).show()
        }




        val application = requireNotNull(this.activity).application
        var dataSource = QuizzesDatabase.getInstance(application).questionDataDao
        val viewModelFactory = TitleFragmentViewModelFactory(dataSource, application)
        titleFragmentViewModel = ViewModelProvider(this, viewModelFactory).get(TitleFragmentViewModel::class.java)


//        titleFragmentViewModel.onSaveData("Android", getAndroidQuizList())
//        titleFragmentViewModel.onSaveData("Web", getAndroidQuizList())
//        titleFragmentViewModel.onSaveData("SQL", getAndroidQuizList())


        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }

}
