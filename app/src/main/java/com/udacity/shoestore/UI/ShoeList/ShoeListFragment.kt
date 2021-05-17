package com.udacity.shoestore.UI.ShoeList

import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.item.view.*


class ShoeListFragment : Fragment() {

    private lateinit var binding : FragmentShoeListBinding
    private val viewModel: ShoeListModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
       // viewModel = ViewModelProvider(requireActivity()).get(ShoeListModel::class.java)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener { view ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        viewModel.shoe.observe(viewLifecycleOwner, Observer<List<Shoe>> {
            if (it.isNotEmpty()) {
                it.forEach { shoe ->
                    val textView = TextView(this.context)
                    val content = " Shoe Name :${shoe.name}" +
                            "\n Size : ${shoe.size.toString()}" +
                            "\n Company : ${shoe.company} " +
                            "\n Description : ${shoe.description} " +
                            "\n"
                    textView.text = content
                    textView.textSize = 20F
                    binding.linlayout.addView(textView)
                }
            } else {
                Toast.makeText(requireContext(), "empty shoes", Toast.LENGTH_SHORT).show()
            }
        })

    }





    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }


}