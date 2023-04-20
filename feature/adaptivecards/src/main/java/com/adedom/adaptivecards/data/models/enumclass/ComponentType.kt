package com.adedom.adaptivecards.data.models.enumclass

enum class ComponentType(val value: String) {
    ACTION_OPEN_URL("Action.OpenUrl"),
    ACTION_SHOW_CARD("Action.ShowCard"),
    ACTION_SUBMIT("Action.Submit"),
    ADAPTIVE_CARD("AdaptiveCard"),
    COLUMN("Column"),
    COLUMN_SET("ColumnSet"),
    FACT_SET("FactSet"),
    IMAGE("Image"),
    INPUT_DATE("Input.Date"),
    INPUT_TEXT("Input.Text"),
    TEXT_BLOCK("TextBlock"),
    BANNER("Banner"),
    TEXT("Text"),
    CONTAINER("Container"),
    CARDS("Cards"),
    BUTTON("Button"),
    BADGE("Badge"),
    ACTION_OPEN_MORE("Action.OpenMore"),
    TEXT_BADGE("TextBadge"),
    LAZY_HORIZONTAL("LazyHorizontal"),
}