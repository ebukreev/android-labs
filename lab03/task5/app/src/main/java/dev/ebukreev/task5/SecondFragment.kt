package dev.ebukreev.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ebukreev.task5.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(layoutInflater)
        val navController = findNavController()
        binding.toFirst.setOnClickListener {
            navController.navigate(R.id.action_second_to_first)
        }
        binding.toThird.setOnClickListener {
            navController.navigate(R.id.action_second_to_third)
        }
        binding.toAbout.setOnClickListener {
            toAboutActivity(requireActivity())
        }

        return binding.root
    }
}