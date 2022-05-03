package uz.evkalipt.sevenmodullesson131

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.item_for_tab_layout.view.*
import uz.evkalipt.sevenmodullesson131.adapters.MyPagerAdapter
import uz.evkalipt.sevenmodullesson131.databinding.FragmentFirstBinding
import uz.evkalipt.sevenmodullesson131.databinding.ItemForTabLayoutBinding
import uz.evkalipt.sevenmodullesson131.models.PagerModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding: FragmentFirstBinding
    lateinit var myPagerAdapter: MyPagerAdapter
    lateinit var listPhotos: ArrayList<PagerModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        loadList()
        myPagerAdapter = MyPagerAdapter(listPhotos, childFragmentManager)
        binding.pagerHome.adapter = myPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.pagerHome)

        val tabCount = binding.tabLayout.tabCount
        for (i in 0 until tabCount){
            var tabView = ItemForTabLayoutBinding.inflate(layoutInflater)
            binding.tabLayout.getTabAt(i)?.customView = tabView.root
            tabView.title1.text = listPhotos[i].name
            tabView.title2.text = listPhotos[i].name

            if (i==0){
                tabView.title2.visibility = View.VISIBLE
                tabView.circle2.visibility = View.VISIBLE
                tabView.title1.visibility = View.INVISIBLE
            }else{
                tabView.title2.visibility = View.INVISIBLE
                tabView.circle2.visibility = View.INVISIBLE
                tabView.title1.visibility = View.VISIBLE
            }
        }

        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var tabView = tab?.customView
                tabView?.circle_2?.visibility = View.VISIBLE
                tabView?.title_2?.visibility = View.VISIBLE
                tabView?.title1?.visibility = View.INVISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var tabView = tab?.customView
                tabView?.circle_2?.visibility = View.INVISIBLE
                tabView?.title_2?.visibility = View.INVISIBLE
                tabView?.title1?.visibility = View.VISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        return binding.root
    }

    private fun loadList() {
        listPhotos = ArrayList()
        listPhotos.add(PagerModel(15, "ALL", null))
        listPhotos.add(PagerModel(15, "NEW", null))
        listPhotos.add(PagerModel(15, "ANIMALS", null))
        listPhotos.add(PagerModel(15, "TECHNOLOGY", null))
        listPhotos.add(PagerModel(15, "NATURE", null))
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}