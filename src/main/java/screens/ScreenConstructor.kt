package screens

data class ScreenConstructor(
        val androidAccessibilityId: String = "",
        val androidId: String = "",
        val androidXPath: String = "",
        val elementName: String = "",
        val className: String = ""
)
// для хранения информации и уменьшить расход памяти