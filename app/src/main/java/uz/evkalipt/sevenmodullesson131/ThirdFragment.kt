package uz.evkalipt.sevenmodullesson131

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.evkalipt.sevenmodullesson131.adapters.MyPaging3Adapter
import uz.evkalipt.sevenmodullesson131.databinding.FragmentThirdBinding
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto
import uz.evkalipt.sevenmodullesson131.viewModel.MyViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ThirdFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding: FragmentThirdBinding
    lateinit var myViewModel: MyViewModel
    lateinit var myPaging3Adapter: MyPaging3Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater)
        myPaging3Adapter = MyPaging3Adapter(object :MyPaging3Adapter.MyOnClick{
            override fun myClick(myPhoto: MyPhoto) {
                var intent = Intent(binding.root.context, PhotoActivity::class.java)
                intent.putExtra("url", myPhoto.urls.small_s3)
                intent.putExtra("author", myPhoto.user.name)
                intent.putExtra("likes", myPhoto.likes.toString())
                intent.putExtra("size", "${myPhoto.width}x${myPhoto.height}")
                startActivity(intent)
            }

        })
        binding.rvThird.adapter = myPaging3Adapter
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        myViewModel.getRandomPhotos().observe(this, {
            GlobalScope.launch(Dispatchers.Main){
                myPaging3Adapter.submitData(it)
            }
        })

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}