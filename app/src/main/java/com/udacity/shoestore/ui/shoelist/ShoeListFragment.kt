package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ViewShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {


    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe in shoeList) {
                addShoeListEntry(container, shoe)
            }
        })

        viewModel.navigateDetail.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                viewModel.navigateDetailComplete()
            }
        })

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun addShoeListEntry(
        container: ViewGroup?,
        shoe: Shoe
    ) {
        val shoeBinding: ViewShoeItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.view_shoe_item, container, false
        )
        shoeBinding.shoe = shoe
        binding.shoeElementList.addView(shoeBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}