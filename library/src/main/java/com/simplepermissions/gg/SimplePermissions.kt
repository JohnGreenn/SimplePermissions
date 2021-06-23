package com.simplepermissions.gg

import androidx.fragment.app.FragmentActivity

/**
 * Desc：
 * author：Christiano
 * github: https://github.com/JohnGreenn/SimplePermissions
 */
object SimplePermissions {

    private const val TAG = "PermissionFragment"

    fun request(activity: FragmentActivity, vararg permissions: String, callback: PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as PermissionFragment
        } else {
            val permissionFragment = PermissionFragment()
            fragmentManager.beginTransaction().add(permissionFragment, TAG).commitNow()
            permissionFragment
        }
        fragment.requestNow(callback, *permissions)
    }

}