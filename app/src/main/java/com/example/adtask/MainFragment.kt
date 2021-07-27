package com.example.adtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(logo.context)
            .load("data:image/jpeg;base64,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w7aDrBAP1Cv8n0ArMSxSWVpMb+JHY/le42+wSdOjTryrtJx2r9eAm2kvJks35q14THUU0hY+oexnqvIewjdw+VlhM0Y7UxRYXEKiRjpI2STOD3NcdR/F8lG8xYBUUtV6ENToXSh8OxIcH7D+nyUkx/ChWY1BSuaeFHE1jtiBpEZP9FZSoW9OKxhx5f5BuTyZWHFarF6kNpXyU9FTO9pKxxDpfgfPstgRs0tDQSbCwuS47dytX5MqZcLr5MPqQeFM72b7HSHfhcD2K2kFz+sf2zjGCWzGVjyX0+giIvFLQiIgCIiwAiIgCIiAIiID41ZkEchhDTKGOMYeSGF9ttXldcxZrqKuSrmNdqFQHWe122i3JoHRvZdRqNZwyXTYmGGW8csZAErANZZfdh7jt2PzB6DQ9SpWk2qi4fnyiitTclwaMyXlGfEptDBohYQZpSPVjb/J8l0PgOCQUMLYKZmljdyeb3u/M49SvrhOGQ0sLIKdgjjjFgB1PcnqfNXihqusTu3tjxBePfzFKkod9hUewEEEAgixBFwQeaqqrxIyaeUXYNLeJPhwYtdXQsJiA1zQgXMX6md2+XT4LVguF13ZQ2Tw2oDXCr0er75p7DgmT83/AF/Tyv5bHsNO/EMY03C47XT9mrUoc5R68L6muloGurhtYCne4njSRgc3D6WPM/dTAgJZFzV3cfGrSqRW3Po2IxwsMWSyItVzk/JLAslkRN8uhgW+yWRE3y9jAsiIsOTYwERFEyEREAREQBERAEREAREQBERAFVURZAREWAERFkBERYAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAf/2Q==")
            .into(logo)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}