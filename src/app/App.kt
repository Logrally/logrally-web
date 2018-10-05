package app

import react.*
import react.dom.div
import react.dom.h1
import ringui.authdialog.authDialog
import ringui.button.button
import ringui.footer.FooterLineData
import ringui.footer.copyright
import ringui.footer.footer
import ringui.header.header
import ringui.header.tray
import ringui.link.link
import ringui.loader.loader

interface AppState : RState {
    var showLogin: Boolean
    var loggedIn: Boolean
}

class App : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        header {
            link(title = "Homepage", href = "/")

            tray {
                if (state.loggedIn == true) {
                    button("Logout") {
                        attrs.onClick = {
                            setState { loggedIn = false }
                        }
                    }
                } else {
                    button("Login") {
                        attrs.onClick = {
                            setState { showLogin = true }
                        }
                    }
                }
            }
        }

        div {
            authDialog(serviceName = "ACME Inc.", show = state.showLogin) {
                attrs.onConfirm = {
                    setState { showLogin = false; loggedIn = true }
                }
            }

            if (state.loggedIn) {
                h1 { +"Welcome to your application!" }
                loader("Loading application. Please wait ...")
            }
        }

        footer {
            attrs.right = arrayOf(FooterLineData(copyright(2018), "/"), "by firstname lastname")
        }
    }
}

fun RBuilder.app() = child(App::class) {}