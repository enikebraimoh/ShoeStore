package com.udacity.shoestore.UI.ShoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.UI.ShoeList.ShoeListModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding :FragmentShoeDetailsBinding
    private val viewModel: ShoeListModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_details,container,false)
        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //viewModelFactory = ViewModelFactory(shoe)
        //viewModel = ViewModelProvider(requireActivity()).get(ShoeListModel::class.java)

        binding.SaveButton.setOnClickListener { view ->
            val shoe = Shoe(binding.shoeNameEditText.text.toString(),
                binding.shoeSizeEditText.text.toString(),
                binding.companyNameEditText.text.toString(),
                binding.shoeDescriptionEditText.text.toString())
            viewModel.addShoe(shoe)
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())

        }

    }



}