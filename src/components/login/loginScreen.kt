/**
 * Copyright 2018 Joachim Ansorg
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package components.login

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import ringui.REventFunc
import ringui.button.button
import ringui.dialog.dialog
import ringui.island.islandContent
import ringui.island.islandHeader
import ringui.panel.panel
import ringui.styles.formInput
import ringui.styles.ringuiForm

interface LoginScreenProps : RProps {
    var className: String?
    var title: String?
    var loginCaption: String?

    var errorMessage: String?
    var errorClassName: String?

    var show: Boolean?
    var confirmLabel: String?
    var cancelLabel: String?
    var cancelOnEsc: Boolean?

    var onLogin: () -> Unit
    var onCancel: () -> Unit
    var onEscPress: REventFunc
}

class LoginScreen : RComponent<LoginScreenProps, RState>() {
    override fun RBuilder.render() {
        val title = props.title ?: "Login to Logrally.com"
        val confirmLabel = props.confirmLabel ?: "Login"
        val cancelLabel = props.cancelLabel ?: "Cancel"


        dialog(true, "dialog-login", props.className ?: "content") {
            attrs {
                onEscPress = props.onEscPress
                trapFocus = true
            }

//            +title
            islandHeader { +title }

            islandContent {
                props.errorMessage?.let {
                    div(classes = props.errorClassName) {
                        +it
                    }
                }
//
                ringuiForm {
                    formInput("Username", placeholder = "Username or email")
                    formInput("Password", placeholder = "Password")
                }
            }

            panel {
                button(confirmLabel, primary = true) {
                    attrs.className = "first-button"
                    // attrs.onClick = { props.onLogin(User("jansorg", "mail@joachim-ansorg.de", "id")) }
//                attrs.asDynamic().style = kotlinext.js.js {
//                    background = "red"
//                }
                }

                button(cancelLabel) {
                    attrs.onClick = { props.onCancel() }
                }
            }
        }
    }
}
