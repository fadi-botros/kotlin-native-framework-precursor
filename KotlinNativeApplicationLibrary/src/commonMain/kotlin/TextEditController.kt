package com.experiments.common

interface Platform {

}

/**
 * Should be overridden in all platforms, each platform has his own private data
 * i.e. in Android: this can be implemented in the form of a View,
 * and in iOS: this can be implemented in the form of an UIView
 *
 * @param P Platform in which this is overridden
 */
interface View<P: Platform, ViewSpecific: View<P, ViewSpecific>> {
    fun addSubview(view: ViewSpecific)
}

/**
 * A wrapper which contains a view, typically here a wrapper wraps something like a
 * text view, but when one request a platform specific view implementation to add
 * in a linearlayout/stackview, it gives something it contains
 */
interface ViewWrapper<P: Platform, ViewSpecific: View<P, ViewSpecific>> {
    val wrappee: ViewSpecific
}

//fun <P: Platform> getView(): View<P> {
//
//}
//
interface TextEdit<P: Platform, ViewSpecific: View<P, ViewSpecific>>: ViewWrapper<P, ViewSpecific> {
    fun create()
    fun addChangeListener(change: (str: String) -> Unit)
    var text: String
}

interface LinearLayout<V: View<P, V>, P: Platform>: ViewWrapper<P, V> {
    fun addView(view: V)
}

interface HorizontalLinearLayout<V: View<P, V>, P: Platform>: LinearLayout<V, P> {
    fun create()
}

interface ListViewDatasource<P: Platform, ViewSpecific: View<P, ViewSpecific>> {
    fun dequeue(pos: Int): View<P, ViewSpecific>
    fun bind(pos: Int, view: View<P, ViewSpecific>)
    fun onSelect(pos: Int)
}

interface CommonListView<P: Platform, ViewSpecific: View<P, ViewSpecific>> : View<P, ViewSpecific> {
    var dataSource: ListViewDatasource<P, ViewSpecific>

}

interface ViewFactory<P: Platform,
        TextEditSpecific: TextEdit<P, ViewSpecific>,
        HorizontalLinearLayoutSpecific: HorizontalLinearLayout<ViewSpecific, P>,
        ViewSpecific: View<P, ViewSpecific>> {
    fun textEdit(): TextEditSpecific
    fun horizontalLinearLayout(): HorizontalLinearLayoutSpecific
}

class MainView<P: Platform,
        TextEditSpecific: TextEdit<P, ViewSpecific>,
        HorizontalLinearLayoutSpecific: HorizontalLinearLayout<ViewSpecific, P>,
        ViewSpecific: View<P, ViewSpecific>>(private val factory: ViewFactory<P, TextEditSpecific, HorizontalLinearLayoutSpecific, ViewSpecific>) {
    fun create(on: ViewWrapper<P, ViewSpecific>) {
        val layout = factory.horizontalLinearLayout()
        val nameTextField = factory.textEdit()
        val addressTextField = factory.textEdit()
        nameTextField.addChangeListener {
            addressTextField.text = nameTextField.text
        }
        layout.addView(nameTextField.wrappee)
        layout.addView(addressTextField.wrappee)
        on.wrappee.addSubview(layout.wrappee)
    }
}