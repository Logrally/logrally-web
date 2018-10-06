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

package app

import react.*
import ringui.footer.FooterLineData
import ringui.footer.copyright
import ringui.footer.footer

interface LograllyAppProps : RProps {

}

interface LograllyAppState : RState {
    //var projects: Array<Project>?
}

class LograllyApp : RComponent<LograllyAppProps, LograllyAppState>() {
    override fun RBuilder.render() {
//        lograllyHeader {
//            attrs.projects = state.projects ?: emptyArray()
//        }

        footer {
            attrs.left = arrayOf("Logrally")
            attrs.center = arrayOf(copyright(2018) + " by logrally.com")
            attrs.right = arrayOf(FooterLineData("Contact", "/contact"))
        }
    }

    override fun componentDidMount() {

        setState {
            //            projects = arrayOf(
//                    Project("BS", "BashSupport", "BashSupport is a Bash plugin for Intellij", "org1"),
//                    Project("LR", "Logrally", "Logrally is log software", "org1"))
        }
    }
}

fun RBuilder.lograllyApp() = child(LograllyApp::class) {
    //   requireAll(require.context("@jetbrains/ring-ui/components/input/input.scss")
}