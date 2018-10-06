package ringui.styles

interface Style {}

@JsModule("@jetbrains/ring-ui/components/form/form.scss")
external val forms: Style

@JsModule("@jetbrains/ring-ui/components/input/input.scss")
external val input: Style

@JsModule("@jetbrains/ring-ui/components/input-size/input-size.scss")
external val inputSize: Style

@JsModule("@jetbrains/ring-ui/components/palette/palette.scss")
external val palette: Style

// dummy to force a reference to the module
fun importStyle(style: Style) {}