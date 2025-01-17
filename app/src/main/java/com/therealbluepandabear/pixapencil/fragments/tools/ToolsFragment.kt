package com.therealbluepandabear.pixapencil.fragments.tools

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
            StringConstants.Identifiers.PencilToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsPencilButton)
                } else {
                    onOptionTapped(binding.fragmentToolsPencilButtonH)
                }
            }

            StringConstants.Identifiers.EraseToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsEraseButton)
                } else {
                    onOptionTapped(binding.fragmentToolsEraseButtonH)
                }
            }

            StringConstants.Identifiers.MoveToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsMoveButton)
                } else {
                    onOptionTapped(binding.fragmentToolsMoveButtonH)
                }
            }

            StringConstants.Identifiers.ColorPickerToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsColorPickerButton)
                } else {
                    onOptionTapped(binding.fragmentToolsColorPickerButtonH)
                }
            }

            StringConstants.Identifiers.FillToolIdentifier  -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsFillButton)
                } else {
                    onOptionTapped(binding.fragmentToolsFillButtonH)
                }
            }

            StringConstants.Identifiers.LineToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsLineButton)
                } else {
                    onOptionTapped(binding.fragmentToolsLineButtonH)
                }
            }

            StringConstants.Identifiers.RectangleToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsRectangleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsRectangleButtonH)
                }
            }

            StringConstants.Identifiers.OutlinedRectangleToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsOutlinedRectangleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsOutlinedRectangleButtonH)
                }
            }

            StringConstants.Identifiers.SquareToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsSquareButton)
                } else {
                    onOptionTapped(binding.fragmentToolsSquareButtonH)
                }
            }

            StringConstants.Identifiers.OutlinedSquareToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsOutlinedSquareButton)
                } else {
                    onOptionTapped(binding.fragmentToolsOutlinedSquareButtonH)
                }
            }

            StringConstants.Identifiers.CircleToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsCircleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsCircleButtonH)
                }
            }

            StringConstants.Identifiers.OutlinedCircleToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsOutlinedCircleButton)
                } else {
                    onOptionTapped(binding.fragmentToolsOutlinedCircleButtonH)
                }
            }

            StringConstants.Identifiers.SprayToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsSprayButton)
                } else {
                    onOptionTapped(binding.fragmentToolsSprayButtonH)
                }
            }

            StringConstants.Identifiers.PolygonToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsPolygonButton)
                } else {
                    onOptionTapped(binding.fragmentToolsPolygonButtonH)
                }
            }

            StringConstants.Identifiers.DitherToolIdentifier -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    onOptionTapped(binding.fragmentToolsDitherButton)
                } else {
                    onOptionTapped(binding.fragmentToolsDitherButtonH)
                }
            }

            StringConstants.Identifiers.ShadingToolIdentifier  -> {
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