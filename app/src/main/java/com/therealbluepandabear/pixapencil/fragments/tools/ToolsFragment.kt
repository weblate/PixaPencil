package com.therealbluepandabear.pixapencil.fragments.tools

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
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.therealbluepandabear.pixapencil.databinding.FragmentToolsBinding
import com.therealbluepandabear.pixapencil.listeners.ToolsFragmentListener
import com.therealbluepandabear.pixapencil.utility.constants.StringConstants

class ToolsFragment : Fragment() {
    private var backingBindingProperty: FragmentToolsBinding? = null

    val binding get(): FragmentToolsBinding {
        return backingBindingProperty!!
    }

    lateinit var caller: ToolsFragmentListener

    private fun setup() {
        setOnClickListeners()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            onOptionTapped(binding.fragmentToolsPencilButton)
        } else {
            onOptionTapped(binding.fragmentToolsPencilButtonH)
        }
    }

    fun tapOnToolByName(toolName: String) {
        when (toolName) {
            StringConstants.Identifiers.PENCIL_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsPencilButton)
                } else {
                    onOptionTapped(binding.fragmentToolsPencilButtonH)
                }
            }

            StringConstants.Identifiers.ERASE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsEraseButton)
                } else {
                    onOptionTapped(binding.fragmentToolsEraseButtonH)
                }
            }

            StringConstants.Identifiers.MOVE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsMoveButton)
                } else {
                    onOptionTapped(binding.fragmentToolsMoveButtonH)
                }
            }

            StringConstants.Identifiers.COLOR_PICKER_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsColorPickerButton)
                } else {
                    onOptionTapped(binding.fragmentToolsColorPickerButtonH)
                }
            }

            StringConstants.Identifiers.FILL_TOOL_IDENTIFIER  -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsFillButton)
                } else {
                    onOptionTapped(binding.fragmentToolsFillButtonH)
                }
            }

            StringConstants.Identifiers.LINE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsLineButton)
                } else {
                    onOptionTapped(binding.fragmentToolsLineButtonH)
                }
            }

            StringConstants.Identifiers.RECTANGLE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsRectangleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsRectangleButtonH)
                }
            }

            StringConstants.Identifiers.OUTLINED_RECTANGLE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsOutlinedRectangleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsOutlinedRectangleButtonH)
                }
            }

            StringConstants.Identifiers.SQUARE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsSquareButton)
                } else {
                    onOptionTapped(binding.fragmentToolsSquareButtonH)
                }
            }

            StringConstants.Identifiers.OUTLINED_SQUARE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsOutlinedSquareButton)
                } else {
                    onOptionTapped(binding.fragmentToolsOutlinedSquareButtonH)
                }
            }

            StringConstants.Identifiers.CIRCLE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsCircleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsCircleButtonH)
                }
            }

            StringConstants.Identifiers.OUTLINED_CIRCLE_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsOutlinedCircleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsOutlinedCircleButtonH)
                }
            }

            StringConstants.Identifiers.SPRAY_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsSprayButton)
                } else {
                    onOptionTapped(binding.fragmentToolsSprayButtonH)
                }
            }

            StringConstants.Identifiers.POLYGON_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsPolygonButton)
                } else {
                    onOptionTapped(binding.fragmentToolsPolygonButtonH)
                }
            }

            StringConstants.Identifiers.DITHER_TOOL_IDENTIFIER -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsDitherButton)
                } else {
                    onOptionTapped(binding.fragmentToolsDitherButtonH)
                }
            }

            StringConstants.Identifiers.SHADING_TOOL_IDENTIFIER  -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsShadingButton)
                } else {
                    onOptionTapped(binding.fragmentToolsShadingButtonH)
                }
            }
        }
    }

    companion object {
        fun newInstance(): ToolsFragment {
            return ToolsFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ToolsFragmentListener) caller = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        backingBindingProperty = FragmentToolsBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        backingBindingProperty = null
    }

}