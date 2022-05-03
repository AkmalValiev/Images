package uz.evkalipt.sevenmodullesson131

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import uz.evkalipt.sevenmodullesson131.adapters.MyPaging3Adapter
import uz.evkalipt.sevenmodullesson131.databinding.FragmentForPagerBinding
import uz.evkalipt.sevenmodullesson131.models.PagerModel
import uz.evkalipt.sevenmodullesson131.photoModel.MyPhoto
import uz.evkalipt.sevenmodullesson131.viewModel.MyViewModel

private const val ARG_PARAM1 = "param1"

class ForPagerFragment : Fragment() {
    private var param1: PagerModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as PagerModel
        }
    }
    lateinit var binding:FragmentForPagerBinding
    lateinit var myPaging3Adapter: MyPaging3Adapter
    lateinit var myViewModel: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForPagerBinding.inflate(layoutInflater)
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
        binding.rvPagerFragment.adapter = myPaging3Adapter
        myViewModel =ViewModelProvider(this)[MyViewModel::class.java]
        myViewModel.getPhotos(param1?.page!!, param1?.name.toString()).observe(this, {
            GlobalScope.launch(Dispatchers.Main) {
                myPaging3Adapter.submitData(it)
            }
        })

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: PagerModel) =
            ForPagerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}