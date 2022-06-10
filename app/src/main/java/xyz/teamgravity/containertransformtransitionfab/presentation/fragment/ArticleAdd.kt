package xyz.teamgravity.containertransformtransitionfab.presentation.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.Slide
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.MaterialContainerTransform
import xyz.teamgravity.containertransformtransitionfab.R
import xyz.teamgravity.containertransformtransitionfab.core.constant.Const
import xyz.teamgravity.containertransformtransitionfab.databinding.FragmentArticleAddBinding

class ArticleAdd : Fragment() {

    private var _binding: FragmentArticleAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentArticleAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transition()
    }

    private fun transition() {
        enterTransition = MaterialContainerTransform().apply {
            startView = requireActivity().findViewById(R.id.add_b)
            endView = binding.root
            duration = Const.DURATION_TRANSITION
            scrimColor = Color.TRANSPARENT
            containerColor = MaterialColors.getColor(requireContext(), com.google.android.material.R.attr.colorSurface, Color.WHITE)
            startContainerColor = MaterialColors.getColor(requireContext(), com.google.android.material.R.attr.colorSecondary, Color.WHITE)
            endContainerColor = MaterialColors.getColor(requireContext(), com.google.android.material.R.attr.colorSurface, Color.WHITE)
        }
        returnTransition = Slide().apply {
            duration = Const.DURATION_TRANSITION
            addTarget(R.id.parent_layout)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}