package uz.evkalipt.sevenmodullesson131.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.evkalipt.sevenmodullesson131.ForPagerFragment
import uz.evkalipt.sevenmodullesson131.models.PagerModel

@Suppress("DEPRECATION")
class MyPagerAdapter(var list: List<PagerModel>, manager: FragmentManager):FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ForPagerFragment.newInstance(list[position])
    }

}