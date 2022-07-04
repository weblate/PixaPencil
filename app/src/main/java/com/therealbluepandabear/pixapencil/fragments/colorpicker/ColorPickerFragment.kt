package com.therealbluepandabear.pixapencil.fragments.colorpicker

/**
 * Fragment Structure -> If you are making any changes to the code, follow these guidelines:
 *
 * ,------------,
 * [    Root    ]
 * '------------'
 *      │
 *      ▼
 * ,---------------,
 * [    Binding    ]
 * '---------------'
 *      │
 *      ▼
 * ,--------------,
 * [    Caller    ]
 * '--------------'
 *      │
 *      ▼
 * ,-------------,
 * [    Title    ]
 * '-------------'
 *      │
 *      ▼
 * ,-----------------,
 * [    Variables    ]
 * '-----------------'
 *      │
 *      ▼
 * ,-----------------------------------,
 * [    Private Functions/Functions    ]
 * '-----------------------------------'
 *      │
 *      ▼
 * ,------------------------,
 * [    Companion Object    ]
 * '------------------------'
 *      │
 *      ▼
 * ,----------------------------------,
 * [    Interface Caller Functions    ]
 * '----------------------------------'
 *      │
 *      ▼
 * ,---------------,
 * [    OnAttach   ]
 * '---------------'
 *      │
 *      ▼
 * ,--------------------------,
 * [    OnCreateOptionsMenu   ]
 * '--------------------------'
 *      │
 *      ▼
 * ,-------------------,
 * [    OnCreateView   ]
 * '-------------------'
 *      │
 *      ▼
 * ,---------------,
 * [    OnCreate   ]
 * '---------------'
 *      │
 *      ▼
 * ,--------------------,
 * [    OnDestroyView   ]
 * '--------------------'
 */

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.databinding.FragmentColorPickerBinding
import com.therealbluepandabear.pixapencil.fragments.base.ActivityFragment
import com.therealbluepandabear.pixapencil.listeners.ColorPickerFragmentListener
import com.therealbluepandabear.pixapencil.models.ColorPalette
import com.therealbluepandabear.pixapencil.utility.constants.StringConstants

class ColorPickerFragment : Fragment(), ActivityFragment {
    private var paramOldColor: Int? = null
    private var paramColorPalette: ColorPalette? = null

    override val title: String by lazy { getString(R.string.fragment_color_picker_title_in_code_str) }

    fun setParams(paramOldColor: Int, paramColorPalette: ColorPalette?) {
        this.paramOldColor = paramOldColor
        this.paramColorPalette = paramColorPalette
    }

    private fun instantiateVariables() {
        if (paramOldColor != null) {
            oldColor_ = paramOldColor!!
            colorPalette = paramColorPalette
        }
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.fragmentColorPickerViewPager2.adapter = adapter
        binding.fragmentColorPickerViewPager2.offscreenPageLimit = 3
        binding.fragmentColorPickerViewPager2.isUserInputEnabled = false
        binding.fragmentColorPickerTabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.fragmentColorPickerViewPager2.setCurrentItem(tab.position, false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }

            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })
    }

    private fun setup() {
        instantiateVariables()
        setupViewPager()
    }

    companion object {
        fun newInstance(paramOldColor: Int, paramColorPalette: ColorPalette? = null): ColorPickerFragment {
            val fragment = ColorPickerFragment()
            fragment.setParams(paramOldColor, paramColorPalette)

            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ColorPickerFragmentListener) caller = context
        requireActivity().title = title
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding_ = FragmentColorPickerBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        if (savedInstanceState != null) {
            prevColorPickerTab = savedInstanceState.getInt(StringConstants.Identifiers.PREV_COLOR_PICKER_TAB_BUNDLE_IDENTIFIER)
        }
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentColorPickerTabLayout.getTabAt(binding.fragmentColorPickerViewPager2.currentItem)?.select()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding_ = null
        requireActivity().title = (requireActivity() as CanvasActivity).projectTitle
    }
}