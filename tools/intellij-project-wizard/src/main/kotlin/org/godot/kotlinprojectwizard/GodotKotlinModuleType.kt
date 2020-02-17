package org.godot.kotlinprojectwizard

import com.intellij.icons.AllIcons
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import javax.swing.Icon


class GodotKotlinModuleType : ModuleType<GodotKotlinModuleBuilder?>(ID) {
    override fun createModuleBuilder(): GodotKotlinModuleBuilder {
        return GodotKotlinModuleBuilder()
    }

    override fun getName() = "Godot Kotlin Project"
    override fun getDescription() = "A Godot project with Kotlin"
    override fun getNodeIcon(b: Boolean): Icon = AllIcons.General.ProjectStructure

    override fun createWizardSteps(
        wizardContext: WizardContext,
        moduleBuilder: GodotKotlinModuleBuilder,
        modulesProvider: ModulesProvider
    ): Array<ModuleWizardStep> {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider)
    }

    companion object {
        private const val ID = "GODOT_KOTLIN_MODULE_TYPE"

        @JvmStatic
        fun getInstance() = ModuleTypeManager.getInstance().findByID(ID)
    }
}