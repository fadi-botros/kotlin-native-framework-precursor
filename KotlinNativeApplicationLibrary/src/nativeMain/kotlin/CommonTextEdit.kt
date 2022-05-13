package com.experiments.common
import kotlinx.cinterop.CValue
import kotlinx.cinterop.useContents
import platform.Foundation.NSRange
import platform.Security.kSecAttrAccessibleAfterFirstUnlockThisDeviceOnly
import platform.UIKit.*
import platform.darwin.NSObject

class TextEditContainer(val textField: UITextField) : NSObject(), UITextFieldDelegateProtocol {
    val changeListener: MutableList<(str: String) -> Unit> = mutableListOf()
    override fun textField(
        textField: UITextField,
        shouldChangeCharactersInRange: CValue<NSRange>,
        replacementString: String
    ): Boolean {
        shouldChangeCharactersInRange.useContents {
            changeListener.forEach { it(textField.text!!.replaceRange(this.location.toInt(),
                this.length.toInt() + this.location.toInt(), replacementString)) }
        }
        return true
    }
}

class TextEditiOS constructor(textField: UITextField): TextEdit<iOS, iOSView> {
    private val textEditContainer = TextEditContainer(textField)

    init {
        create()
    }

    override val wrappee: iOSView
        get() = iOSView(textEditContainer.textField)

    override fun create() {
        textEditContainer.textField.delegate = this.textEditContainer
    }

    override fun addChangeListener(change: (str: String) -> Unit) {
        textEditContainer.changeListener.add(change)
    }

    override var text: String
        get() = textEditContainer.textField.text ?: ""
        set(value) { textEditContainer.textField.text = value }


}

class iOSView(val view: UIView): View<iOS, iOSView>, ViewWrapper<iOS, iOSView> {
    override val wrappee: iOSView
        get() = iOSView(view)

    override fun addSubview(view: iOSView) {
        view.wrappee.view.setFrame(this.wrappee.view.bounds)
        this.wrappee.view.addSubview(view.wrappee.view)
    }
}

interface iOS: Platform {

}

class HorizontalLinearLayoutiOS : HorizontalLinearLayout<iOSView, iOS> {
    val stackView = UIStackView()
    override val wrappee: iOSView get() = iOSView(stackView)

    override fun create() {
    }

    override fun addView(view: iOSView) {
        stackView.addArrangedSubview(view.view)
    }
}

class MainObjectContainer {
    val mainObject: MainObject

    init {
        mainObject = MainObject()
    }
}

class MainObject: UIViewController(nibName = null, bundle = null) {
    val handler = MainView(object : ViewFactory<iOS, TextEditiOS, HorizontalLinearLayoutiOS, iOSView> {
        override fun textEdit(): TextEditiOS = TextEditiOS(UITextField())

        override fun horizontalLinearLayout(): HorizontalLinearLayoutiOS = HorizontalLinearLayoutiOS()
    })

    override fun loadView() {
        this.view = UIView(UIScreen.mainScreen.bounds)
        this.view.backgroundColor = UIColor.blueColor
        handler.create(iOSView(this.view))
    }
}
