package top.x86.demo.commonandroidproject.permission

import android.Manifest
import android.os.Build

object PermissionManager {
    val allRequiredPermissions: List<PermissionSpec>
        get() {
            val perms = listOf(
                PermissionSpec(
                    Manifest.permission.CAMERA,
                    "Camera",
                    "",
                ),
                PermissionSpec(
                    Manifest.permission.READ_SMS,
                    "Read SMS",
                    "",
                ),
                PermissionSpec(
                    Manifest.permission.READ_CALENDAR,
                    "Read calendar",
                    "",
                ),
                PermissionSpec(
                    Manifest.permission.READ_CONTACTS,
                    "Read contacts",
                    "",
                ),
                PermissionSpec(
                    Manifest.permission.READ_PHONE_STATE,
                    "Read phone state",
                    ""
                ),
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    PermissionSpec(
                        Manifest.permission.BLUETOOTH_CONNECT,
                        "Connect to paired Bluetooth devices",
                        ""
                    )
                } else {
                    PermissionSpec(
                        Manifest.permission.BLUETOOTH,
                        "Connect to paired bluetooth devices",
                        ""
                    )
                },
                PermissionSpec(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    "Access approximate location",
                    "" ,
                ),
                PermissionSpec(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    "Access precise location",
                    "",
                )
            ).let {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it + listOf(
                        PermissionSpec(
                            Manifest.permission.READ_MEDIA_IMAGES,
                            "Read image files from external storage",
                            "",
                        ),
                        PermissionSpec(
                            Manifest.permission.READ_MEDIA_AUDIO,
                            "Read audio files from external storage",
                            "",
                        ),
                        PermissionSpec(
                            Manifest.permission.READ_MEDIA_VIDEO,
                            "Read video files from external storage",
                            "",
                        ),
                    )
                } else {
                    it + listOf(
                        PermissionSpec(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            "Read external storage",
                            "",
                        )
                    )
                }
            }
            return perms.filter { it.enabled }
        }
}
