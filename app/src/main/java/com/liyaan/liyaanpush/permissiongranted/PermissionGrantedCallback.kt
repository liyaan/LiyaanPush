package com.yzw.permissiongranted


interface PermissionGrantedCallback {
    //同意
    fun granted()
    //拒绝
    fun denied()
}
