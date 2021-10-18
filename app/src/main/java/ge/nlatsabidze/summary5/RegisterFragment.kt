package ge.nlatsabidze.summary5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.summary5.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var binding: FragmentRegisterBinding? = null

    private lateinit var adapter: CardViewAdapter

    private val viewModel: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel.parseJson()

        init()
        return binding?.root
    }

    private fun init() {

        adapter = CardViewAdapter(viewModel, viewModel.parsedJson.value!!)
        binding?.rv?.adapter = adapter
        binding?.rv?.layoutManager = LinearLayoutManager(context)

        binding!!.btnRegister.setOnClickListener {
            viewModel.mapOfItems.observe(viewLifecycleOwner, {
                Log.d("tag", it.toString())
            })
        }
    }
}