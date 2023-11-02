package screens

data class ScreenConstructor(
        val androidAccessibilityId: String = "",
        val androidId: String = "",
        val androidXPath: String = "",
        val elementName: String = "",
        val className: String = "",
        val iosAccessibilityId: String = "",
        val iosId: String = "",
        val iosXPath: String = "",
        val iosClassChain:String = "",
        val iosPredicateString: String = ""
)
// для хранения информации и уменьшить расход памяти