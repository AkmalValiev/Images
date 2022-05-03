package uz.evkalipt.sevenmodullesson131

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.evkalipt.sevenmodullesson131.adapters.MyRvAdapter
import uz.evkalipt.sevenmodullesson131.databinding.FragmentFourthBinding
import uz.evkalipt.sevenmodullesson131.db.MyDatabase
import uz.evkalipt.sevenmodullesson131.models.SaveModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FourthFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding: FragmentFourthBinding
    lateinit var myDatabase: MyDatabase
    lateinit var myRvAdapter: MyRvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourthBinding.inflate(layoutInflater)

        loadRv()

        return binding.root
    }

    override fun onResume() {
        loadRv()
        super.onResume()
    }

    private fun loadRv() {
        myDatabase = MyDatabase.getInstance(binding.root.context)
        myRvAdapter = MyRvAdapter(myDatabase.saveModelDao().getAllPhoto(), object :MyRvAdapter.MyOnClick{
            override fun myClick(saveModel: SaveModel) {
                var intent = Intent(binding.root.context, PhotoActivity::class.java)
                intent.putExtra("url", saveModel.url)
                intent.putExtra("author", saveModel.author)
                intent.putExtra("likes", saveModel.likes)
                intent.putExtra("size", saveModel.size)
                startActivity(intent)
            }

        })
        binding.rvSave.adapter = myRvAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FourthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}