package com.blue.callblock.shared

import android.app.role.RoleManager
import android.content.Context
import android.content.Context.ROLE_SERVICE
import android.content.Intent


object PermissionAndRole {
    fun getRequestCallScreenRoleIntent(context: Context): Intent? {
        val roleManager = context.getSystemService(ROLE_SERVICE) as RoleManager
        return if (roleManager.isRoleAvailable(RoleManager.ROLE_CALL_SCREENING)) {
            roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING)
        } else {
            null
        }
    }

    fun hasCallScreeningService(context: Context): Boolean {
        val roleManager = context.getSystemService(ROLE_SERVICE) as RoleManager
        return if (roleManager.isRoleAvailable(RoleManager.ROLE_CALL_SCREENING)) {
            roleManager.isRoleHeld(RoleManager.ROLE_CALL_SCREENING)
        } else {
            true
        }
    }
}