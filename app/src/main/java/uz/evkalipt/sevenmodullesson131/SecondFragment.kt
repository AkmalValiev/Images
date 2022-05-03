package uz.evkalipt.sevenmodullesson131

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.item_for_tab_layout.view.*
import uz.evkalipt.sevenmodullesson131.adapters.MyPagerAdapter
import uz.evkalipt.sevenmodullesson131.databinding.FragmentSecondBinding
import uz.evkalipt.sevenmodullesson131.databinding.ItemForTabLayoutBinding
import uz.evkalipt.sevenmodullesson131.models.PagerModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding: FragmentSecondBinding
    lateinit var myPagerAdapter: MyPagerAdapter
    lateinit var listSecond:ArrayList<PagerModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        loadList()
        myPagerAdapter = MyPagerAdapter(listSecond, childFragmentManager)
        binding.viewPagerSecond.adapter = myPagerAdapter
        binding.tabLayoutSecond.setupWithViewPager(binding.viewPagerSecond)

        val tabCount = binding.tabLayoutSecond.tabCount
        for (i in 0 until tabCount){
            var tabView = ItemForTabLayoutBinding.inflate(layoutInflater)
            binding.tabLayoutSecond.getTabAt(i)?.customView = tabView.root
            tabView.title1.text = listSecond[i].name
            tabView.title2.text = listSecond[i].name

            if (i==0){
                tabView.title1.visibility = View.INVISIBLE
                tabView.title2.visibility = View.VISIBLE
                tabView.circle2.visibility = View.VISIBLE
            }else{
                tabView.title1.visibility = View.VISIBLE
                tabView.title2.visibility = View.INVISIBLE
                tabView.circle2.visibility = View.INVISIBLE
            }
        }

        binding.tabLayoutSecond.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var tabView = tab?.customView
                tabView?.title1?.visibility = View.INVISIBLE
                tabView?.title_2?.visibility = View.VISIBLE
                tabView?.circle_2?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var tabView = tab?.customView
                tabView?.title1?.visibility = View.VISIBLE
                tabView?.title_2?.visibility = View.INVISIBLE
                tabView?.circle_2?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        return binding.root
    }

    private fun loadList() {
        listSecond = ArrayList()
        listSecond.add(PagerModel(30, "ALL", null))
        listSecond.add(PagerModel(30, "NEW", null))
        listSecond.add(PagerModel(30, "ANIMALS", null))
        listSecond.add(PagerModel(30, "TECHNOLOGY", null))
        listSecond.add(PagerModel(30, "NATURE", null))

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}