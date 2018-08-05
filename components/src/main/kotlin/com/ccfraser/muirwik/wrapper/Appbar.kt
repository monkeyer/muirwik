package com.ccfraser.muirwik.wrapper

import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps


@JsModule("@material-ui/core/AppBar")
private external val iconModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val iconComponent: RComponent<MAppBarProps, RState> = iconModule.default

enum class MAppBarPosition {
    Fixed, Absolute, Sticky, Static;

    override fun toString(): String {
        return super.toString().toLowerCase()
    }
}

interface MAppBarProps : StyledProps {
    var color: String
    var position: String
}

fun RBuilder.mAppBar(
        color: MColor = MColor.Primary,
        position: MAppBarPosition = MAppBarPosition.Fixed,

        className: String? = null,
        handler: StyledHandler<MAppBarProps>? = null) = createStyled(iconComponent) {

    attrs.color = color.toString()
    attrs.position = position.toString()

    setStyledPropsAndRunHandler(className, handler)
}

