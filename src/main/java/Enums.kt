enum class LocatorType {
    ID,
    XPATH,
    ACCESSIBILITY_ID,
    CLASS_NAME,
    IOS_CLASS_CHAIN,
    IOS_PREDICATE_STRING
}

enum class TypeOS {
    ANDROID,
    IOS
}

enum class ResponseType {
    JSON,
    HTML

} //  нужен т к в данной ситуации восврашаем html или json
// класс перечислений локаторов