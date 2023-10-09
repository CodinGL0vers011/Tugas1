package com.percobaan.tugas.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.percobaan.tugas.R
import com.percobaan.tugas.databinding.FragmentSkillBinding

class SkillFragment : Fragment() {

    private var _binding: FragmentSkillBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val skillViewModel =
            ViewModelProvider(this).get(SkillViewModel::class.java)

        _binding = FragmentSkillBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = binding.rvSkills
        val adapter = SkillsAdapter{
            navigateToDetail(it)
        }

        val textView: TextView = binding.textSkill
        skillViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun navigateToDetail(extraName: String){
        val bundle = Bundle()
        bundle.putString("extra_name", extraName)
        findNavController(this).navigate(R.id.action_navigation_skill_to_navigation_skill_detail, bundle)
        //findNavController().navigate(TransformFragmentDirections.actionNavTransformToTransformDetail(extraName))
    }
}