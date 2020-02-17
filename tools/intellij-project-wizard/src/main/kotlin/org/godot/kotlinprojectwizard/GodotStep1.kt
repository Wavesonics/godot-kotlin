package org.godot.kotlinprojectwizard

import com.intellij.ide.model
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import javax.swing.JComponent
import javax.swing.JLabel

class GodotStep1 : ModuleWizardStep() {
    override fun updateDataModel() {

    }

    override fun getComponent(): JComponent {
        return JLabel("Provide some setting here");
    }
}