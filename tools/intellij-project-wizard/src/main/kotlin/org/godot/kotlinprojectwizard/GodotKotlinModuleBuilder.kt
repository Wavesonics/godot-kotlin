package org.godot.kotlinprojectwizard

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import javax.swing.JComponent
import javax.swing.JLabel


class GodotKotlinModuleBuilder : ModuleBuilder() {
    @Throws(ConfigurationException::class)
    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {

    }

    override fun getModuleType(): ModuleType<*>  = GodotKotlinModuleType()
    override fun getGroupName() = "kotlin"

    override fun createWizardSteps(
        wizardContext: WizardContext,
        modulesProvider: ModulesProvider
    ): Array<out ModuleWizardStep>? {
        return arrayOf<ModuleWizardStep>(GodotStep1())
    }
}