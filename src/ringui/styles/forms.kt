package ringui.styles

import kotlinx.html.*
import react.RBuilder
import react.ReactElement
import react.dom.*

enum class InputSize {
    EXTRA_SHORT, SHORT, MEDIUM, LONG, FULL_WIDTH;

    fun className(): String? {
        return when (this) {
            EXTRA_SHORT -> "ring-input-size_xs"
            SHORT -> "ring-input-size_s"
            MEDIUM -> "ring-input-size_md"
            LONG -> "ring-input-size_l"
            else -> null
        }
    }
}

/**
 * @author jansorg
 */
fun RBuilder.ringuiForm(block: RDOMBuilder<FORM>.() -> Unit): ReactElement {
    importStyle(forms)
    return form(classes = "ring-form", block = block)
}

fun RDOMBuilder<FORM>.formTitle(title: String = "", block: RDOMBuilder<DIV>.() -> Unit = {}): ReactElement {
    return div(classes = "ring-form__title") {
        +title
        this.block()
    }
}

fun RDOMBuilder<FORM>.formGroup(block: RDOMBuilder<DIV>.() -> Unit): ReactElement {
    return div(classes = "ring-form__group", block = block)
}

fun RDOMBuilder<FORM>.formInput(label: String? = null, inputSize: InputSize = InputSize.FULL_WIDTH, errorBubble: String? = null, placeholder: String? = null, type: InputType? = null, formEncType: InputFormEncType? = null, formMethod: InputFormMethod? = null, name: String? = null, classes: String? = null, block: RDOMBuilder<INPUT>.() -> Unit = {}): ReactElement {
    return _formInput(label, inputSize, errorBubble, placeholder, type, formEncType, formMethod, name, classes, block)
}

fun RDOMBuilder<DIV>.formInput(label: String? = null, inputSize: InputSize = InputSize.FULL_WIDTH, errorBubble: String? = null, placeholder: String? = null, type: InputType? = null, formEncType: InputFormEncType? = null, formMethod: InputFormMethod? = null, name: String? = null, classes: String? = null, block: RDOMBuilder<INPUT>.() -> Unit = {}): ReactElement {
    return _formInput(label, inputSize, errorBubble, placeholder, type, formEncType, formMethod, name, classes, block)
}

private inline fun RDOMBuilder<*>._formInput(label: String?, inputSize: InputSize, errorBubble: String?, placeholder: String?, type: InputType?, formEncType: InputFormEncType?, formMethod: InputFormMethod?, name: String?, classes: String?, block: RDOMBuilder<INPUT>.() -> Unit): ReactElement {
    return when (label) {
        null -> input(type = type, formEncType = formEncType, formMethod = formMethod, name = name, classes = c("ring-input", classes, inputSize.className()), block = block)
        else -> {
            //fixme add id link
            label(classes = "ring-form__label") { +label }
            div(classes = "ring-form__control") {
                input(type = type, formEncType = formEncType, formMethod = formMethod, name = name, classes = c("ring-input", classes, inputSize.className())) {
                    placeholder?.let { attrs.placeholder = it }
                    this.block()
                }
                errorBubble?.let {
                    div("ring-error-bubble active") { +it }
                }
            }
        }
    }
}

fun c(vararg classes: String?): String {
    return classes.filterNotNull().joinToString(" ")
}
