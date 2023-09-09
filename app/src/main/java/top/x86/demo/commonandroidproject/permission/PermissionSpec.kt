package top.x86.demo.commonandroidproject.permission

data class PermissionSpec(
    val permissionId: String, //权限
    val localDescription: String,//对权限本身的描述
    val why: String, //对该权限的需求原因
    val enabled: Boolean = true,
    val optional: Boolean = false
)